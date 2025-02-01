fun main() {
//    val coins: (Int) -> String = { quantity ->
//        "$quantity quarters"
//    }
    val coins: (Int) -> String = {
        "$it quarters"
    }
    val cupcake = { quantity: Int ->
        "have a cupcake!"
    }

    //val treatFunction = trickOrTreat(false, {"$it quarters"})
//    val treatFunction = trickOrTreat(false) {toper -> "$toper quarters"}
    val treatFunction = trickOrTreat(false) {"$it quarters"}

//    val trickFunction = trickOrTreat(true, cupcake)
    val trickFunction = trickOrTreat(true, cupcake)
    repeat(4){
        treatFunction()
    }
    treatFunction()
    trickFunction()

}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick
    } else {
        if (extraTreat != null) println(extraTreat(5))
        treat
    }
}

val trick = {
    println("No treats!")
}
val treat: () -> Unit = {
    println("Have a treat!")
}