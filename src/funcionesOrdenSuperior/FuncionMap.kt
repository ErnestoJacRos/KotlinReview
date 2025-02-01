package funcionesOrdenSuperior

/**
 * La funcion Map() te permita transformar una coleccion en otra nueva con la misma cantidad de elementos
 * Por ejemplo: map() podria transformar una List<Cookie> en una List<String> que solo contenga el name de la
 * galleta, siempre que indiques a la funcion map() como crear una String de cada elemento Cookie*/
fun main() {
    val fullMenu = cookies.map {
        "${it.name} -> $${it.price}"
    }
    fullMenu.forEach {
        println(it)
    }
}