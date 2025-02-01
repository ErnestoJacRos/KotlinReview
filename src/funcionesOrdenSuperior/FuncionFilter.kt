package funcionesOrdenSuperior

/**
 * Funcion Filter te permite crear un subconjunto de una coleecion, por ejemplo: si tuvieras una lista de numeros,
 * podrias usar filter() para crear unua lsita nueva que solo contenga numeros divisibles en 2  mientras que map regresa
 * una lista del mismo tamnho pero con transformacion de la lista , filter() puede devolver del mismo tamanho o menor,
 * pero, la lista que regresa es del mimso tipo si aplicas filter en una List<Cookie> devolvera uan Lista<Cookie> de menor
 * o de igual manera , y para hacer esto , si el resultado de la lambda es true se incluira en la nueva Lista*/
fun main() {
    val softBakedMenu = cookies.filter {
        /**esto regresa un boolean por eso se agregara a la nueva lista */
        //it.price.toInt() % 2 == 0
        //como el parametro es boolean y es justo lo que necesita retornar el filter no se necesita hacer nada mas
        it.softBaked
    }
    println("Soft Cookies")
    softBakedMenu.forEach {
        println("${it.name} -> ${it.price}")
    }
}