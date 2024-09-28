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


/* interface
 * An interface is defined using the interface keyword, 
 * followed by a name in UpperCamelCase, 
 * followed by opening and closing curly braces. 
 * Within the curly braces, you can define any method signatures 
 * or get-only properties that any class conforming to the interface must implement.
 * 
 * interface InterfaceName{
 * 	 	INTERFACE_BODY
 * }
 * 
 * An interface is a contract. 
 * A class that conforms to an interface is said to extend the interface. 
 * A class can declare that it would like to extend an interface using a colon (:), 
 * followed by a space, followed by the name of the interface.
 * 
 * class ClassName : InterfaceName{
 * 		CLASS_BODY
 * }
 * 
 * 
 */

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

    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress{
        var total: Int = 10
        var answered: Int = 3
    }
}


fun main() {
    
    Quiz().printProgressBar()
    //Output> 
    
    //▓▓▓▒▒▒▒▒▒▒
	//3 of 10 answered

}