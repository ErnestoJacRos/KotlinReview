package colecciones

fun main() {
    val solarSystem =
        mutableListOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"
    solarSystem.removeAt(9)
    solarSystem.remove("Future Moon")
    solarSystem.forEach {
        println(it)
    }

    println(solarSystem.contains("Future Moon"))
    println("Future Moon" in solarSystem)
}