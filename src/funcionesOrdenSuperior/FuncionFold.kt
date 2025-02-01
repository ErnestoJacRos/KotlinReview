package funcionesOrdenSuperior

/**
 * la funcion fold() se usa para general un valor unico apartir de una coleccion. Por lo general se usa
 * para calcular un total o sumar todos los elementos de una lista para crear un promedio*/

fun main() {
    val totalPrice = cookies.fold(0.0) {
        total, cookie ->
        total + cookie.price
    }
    println("total price: $totalPrice")
}