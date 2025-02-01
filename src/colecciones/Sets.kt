package colecciones

fun main() {
    //no tiene un orden especifico ni permite valores duplicados
    /**
     * garantiza  la singularidad no tiene un orden especifico el indiceo es mediante el hashcode
     * pero hayq ue tener presente la colision de hash pero la posbilidad e smuy pequenha
     * */

    val systemSystem: MutableSet<String> =
        mutableSetOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(systemSystem.size)
    systemSystem.add("Pluto")
    println(systemSystem.size)
    println(systemSystem.contains("Pluto"))
    println("Pluto" in systemSystem)
    systemSystem.add("Pluto")
    println(systemSystem.size)
    systemSystem.remove("Pluto")
    println(systemSystem.size)


}