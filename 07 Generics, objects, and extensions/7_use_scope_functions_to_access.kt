/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}


class Quiz : ProgressPrintable {
    
    override val progressText: String
    	get() = "${answered} of ${total} answered"
    
    override fun printProgressBar(){
        repeat(Quiz.answered){
            print("▓")
        }
        repeat(Quiz.total - Quiz.answered){
            print("▒")
        }
        println()
        println(progressText)
    }
    
    /* Replace long object names using let()
 * The let() function allows you to refer to an object in a lambda expression 
 * using the identifier it, instead of the object's actual name. 
 * This can help you avoid using a long, more descriptive object name 
 * repeatedly when accessing more than one property. 
 * 
 */
    fun printQuiz(){
        question1.let{
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        
        question2.let { quiz ->
            println(quiz.questionText)
            println(quiz.answer)
            println(quiz.difficulty)
        }
        println()
        
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress{
        var total: Int = 10
        var answered: Int = 3
    }
}


fun main() {
    
    /* Call an object's methods without a variable using apply()
     * 
     * One of the cool features of scope functions is that you can call them on an 
     * object before that object has even been assigned to a variable. 
     * For example, the apply() function is an extension function that can 
     * be called on an object using dot notation.
     * 
     * 
     * Quiz().apply {
     * printQuiz()
     * }
     * 
 	*/
    val quiz = Quiz()
    quiz.apply{
        printQuiz()
    }

}