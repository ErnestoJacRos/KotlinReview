package funcionesOrdenSuperior.exercise

val number = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
val groupedByFirstLetter = number.groupBy {
    it.first().uppercase()
}
fun main() {
    println(groupedByFirstLetter)
    println(groupedByFirstLetter.size)
    println(groupedByFirstLetter.count())
    for((key, value) in groupedByFirstLetter) {
        println("Key: $key, value: $value")
    }
}