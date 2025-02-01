package funcionesOrdenSuperior

/**
 * Funcion GroupBy: se puede usar para convertir una lista en un map con base en una funcion,
 * cada valor unico que se muestra en la funcion se convierte en una clave en el map resultante, los valoores de cada
 * clave son todos los elementos de la concion que produjeron ese valor unico
 * */
fun main() {
    var numList = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
    var paresImpares = numList.groupBy {
        if(it % 2 == 0) "Par" else "Impar"
    }

    paresImpares.forEach {
        println(it)
    }

    val groupedMenu = cookies.groupBy {
        //se crea un map<Boolean, List<Cookie>>
        it.softBaked //es un boolean loq ue va a definir la key y todos los que tengan este key crearan los nuvos maps
    }

    val softBackedMenu = groupedMenu[true] ?: listOf()
    println("Soft Cookie")
    softBackedMenu.forEach {
        println("${it.name}  -> ${it.price}")
    }
    val crunchyMenu = groupedMenu[false] ?: listOf()
    println("Crunchy Cookies")
    crunchyMenu.forEach {
        println("${it.name} -> ${it.price}")
    }

}