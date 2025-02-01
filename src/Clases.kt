import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice public constructor(val name: String = "Android Tv", val category: String = "Entertainment") {

    //los setters y getters debes ser del mismo nivel de acceso o menor acceso
    var deviceStatus = "online"
        protected set
    open val deviceType = "unknown"


    public constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }

}

public class SmartTvDevice public constructor(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Tv"

    //    private var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    //    private var channelNumber = 1
//        set(value) {
//            if (value in 1..200) {
//                field = value
//            }
//        }
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set $speakerVolume and channel number is set to $channelNumber"
        )
    }

    override fun turnOff() {
        super.turnOff()
        println(
            "$name turned off"
        )
    }
}

public class SmartLightDevice public constructor(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    //    private var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {

        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is: $brightnessLevel")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

public class SmartHome public constructor(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0

    fun turnOnTv() {
        if (smartTvDevice.deviceStatus == "off") {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }

    }

    fun turnOffTv() {

        if (smartTvDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }

    fun increaseVolume() {
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        }
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on")
            smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        if (smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

    fun increaseLightBrightness() {
        if (smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        }
    }

    fun turnOffAllDevice() {

        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}


fun main() {

    val smartHome = SmartHome(
        smartTvDevice = SmartTvDevice("Roku tv", "entertainment"),
        smartLightDevice = SmartLightDevice("Asus Light", "Utility")
    )

    smartHome.smartTvDevice.previousChannel()
    var smartDevice: SmartDevice = SmartTvDevice(deviceName = "Android Tv", deviceCategory = "Entertainment")
    smartDevice.turnOn()
    if (smartDevice is SmartTvDevice) {
        smartDevice.decreaseVolume()
        smartDevice.decreaseVolume()
        smartDevice.printDeviceInfo()
    }


    smartDevice = SmartLightDevice(deviceName = "Google Light", deviceCategory = "Utility")
    smartDevice.turnOn()
    if (smartDevice is SmartLightDevice) {
        smartDevice.printDeviceInfo()
        smartDevice.decreaseBrightness()

    }


}