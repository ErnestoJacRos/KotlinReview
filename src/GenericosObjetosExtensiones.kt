data class Question<T>(
    /**
     * Genericos:
     * En Kotlin, genéricos son una característica del lenguaje que permite escribir clases, interfaces y funciones que
     * puedan operar sobre diferentes tipos de datos mientras garantizan seguridad de tipos en tiempo de compilación.
     * énfasis en type safety en tiempo de compliacion a comparacion de usar Any*/
    /**
     * una data class almenos debe tener un parametro en el constructor, y todos los parametros del constructor deben
     * estya marcados con var o val, una dataclass tampoco puede ser abstract, open, sealed in inner
     * Cuando se define como dataClass se implemntan los sigs, metodos :
     * equals()
     * hashCode(),
     * toString(),
     * componentN(),
     * copy()*/
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    /**
     * coleccionde de constantes, */
    EASY, MEDIUM, HARD
}

/**
 * Interface es un contrato, una clase que se ajusta a una interfaz extiende la interfaz, una clase puede declarar que
 * le gustaria extender una interfaz con 2 puntos a cambio la clase debe implementar las propiedades y los metodos
 * especificados en la interfaz no tiene constructor**/

interface ProgressPrintable {
    val progressText : String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    override val progressText: String
        get() = "${answered} of ${total} answered"

    val question1 = Question(questionText = "Quoth the raven", answer = "nevermore", difficulty = Difficulty.EASY)
    val question2 =
        Question(questionText = "The sky is green. Ture o False ", answer = false, difficulty = Difficulty.MEDIUM)
    val question3 =
        Question(questionText = "How many days are there between full moons", answer = 28, difficulty = Difficulty.HARD)

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(Quiz.progressText)
    }


    /**Clase singleton un singleton es una clase que solo puede tener una unica instancia en lugar de class usas object,
     * no puede tener constructor las propiedades se declaran en las llaves y deben ser inicializadas
     * para acceder a ella debes usar el nombre de la clase singleton y con "." llamar a sus propiedades*/

    /**las clases y los objetos en kotlin se pueden definir dentro otrros tipos y pueden ser una excelente manera de
     * organizar tu codigo* puedes definir un objecto singleton dentro de otra clase por medio de un objeto complementario,
     * un obeto comlmentario te permita acceder a sus propiedades y metodos desde dentro de la la clase, si las
     * porpiedades y los metodos del objetos pertencen a esa clase se usa la keyword "companion"
     * */

    companion object StudentProgress {
        val total: Int = 10
        val answered = 3
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

    }
}


/**
 * son una forma de agregar nuevas propiedades a las clases existente sin tener que modificar su codigo
 * original. una propiedad de extension se declara como si fuera una propiedad normal, pero se agrega al
 * contexto de una clase usando la sintaxis del receptor
 * ->propiedades calcualdos: las propiedades de extension no pueden almacenar valores, solo pueden tener un getter y un
 * y opcionalmete un setter si es mutable
 * -> Dentro de una propiedad de extensio, puedes acceder a los miebros publicos de la clase a la que se extiende
 * -> Visibilidad, solo están disponible en el archivo o módulo donde se definieron
 * */
val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"

/**Funcion de extension */
fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}



fun main() {

    println("${Quiz.StudentProgress.answered} of ${Quiz.StudentProgress.total} answered")

    println(Quiz.progressText)
    Quiz.printProgressBar()


    println("Con interfaz")
    val quiz = Quiz()
    quiz.printQuiz()

    Quiz().printProgressBar()
    println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4")
    Quiz().apply {
        printQuiz()
    }
    println("=====================Salario==================")
    Quiz().printQuiz()

}