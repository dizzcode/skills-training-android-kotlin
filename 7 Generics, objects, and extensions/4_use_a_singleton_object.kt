/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/* singleton
 * 
 * A singleton is a class that can only have a single instance. 
 * You can clearly communicate in your code that an object should have only one instance by defining it as a singleton. 
 * Kotlin provides a special construct, called an object, that can be used to make a singleton class.
 * 
 * Define a singleton object
 * 
 * object OBJECT_NAME {
 * 		CLASS_BODY
 * }
 * 
 * 
 * Access a singleton object
 * 
 * OBJECT_NAME.PROPERTY_NAME
 * 
 * -----------------------------
 * Declare objects as companion objects
 * You can define a singleton object inside another class using a companion object. 
 * A companion object allows you to access its properties and methods from inside the class, 
 * if the object's properties and methods belong to that class, allowing for more concise syntax.
 * 
 * companion object OBJECT_NAME {
 * 		CLASS_BODY
 * }
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

fun main() {
    
    //accessed with dot notation using only the name of the Quiz class ${Quiz.answered}
    
    println("${Quiz.StudentProgress.answered} of ${Quiz.total} answered.")
    //Output> 3 of 10 answered.
    
   
}