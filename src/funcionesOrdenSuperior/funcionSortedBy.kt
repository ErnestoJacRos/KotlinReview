package funcionesOrdenSuperior

/**
 * funcion sortedBy() a diferencia de sort() donde puede ordenar elementos en una lista normal, en listas de objetos
 * como Cookie el cual tiene varias propiedades y kotlin no sabra por  cual elemento ordenar
 * sortBy() te permite espeficicar un lambda que muestra la propiedad segun la cual deseas ordenar */
fun main() {
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }

    println("Alphabetical Menu:")
    println()

    alphabeticalMenu.forEach {
        println(it.name)
    }
}