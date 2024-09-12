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


class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress{
        var total: Int = 10
        var answered: Int = 3
    }
}

/* Add an extension property
 * To define an extension property, add the type name and a dot operator (.) before the variable name.
 * 
 * val TYPE_NAME.PROPERTY_NAME: DATA_TYPE
 * 		PROPERTY_GETTER
 * 
 * Ex:
 * val Quiz.StudentProgress.progressText: String
 * 		get() = "${answered} of ${total} answered"
 * 
 * Note: Extension properties can't store data, so they must be get-only.
 */

 val Quiz.StudentProgress.progressText: String
    	get() = "${answered} of ${total} answered"




/* Add an extension function
 * To define an extension function, add the type name and a dot operator (.) before the function name.
 * 
 * fun TYPE_NAME.FUNCTION_NAME (PARAMETERS): RETURN_TYPE{
 * 		FUNCTION_BODY
 * }
 * 
 * Ex:
 * fun Quiz.StudentProgress.printProgressBar() {
 * 		repeat(Quiz.answered) { print("▓") }
 * }
 * 
 */

fun Quiz.StudentProgress.printProgressBar(){
    repeat(Quiz.answered){
        print("▓")
    }
    repeat(Quiz.total - Quiz.answered){
        print("▒")
    }
    println()
    println(Quiz.progressText)
}


fun main() {
    
    Quiz.printProgressBar()
    //Output> 
    
    //▓▓▓▒▒▒▒▒▒▒
	//3 of 10 answered
    
   
}