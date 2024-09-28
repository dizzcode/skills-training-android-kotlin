/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/* Data class 
 * 
 * class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: Difficulty
	)
    
 * Classes like the Question class, on the other hand, only contain data. 
 * They don't have any methods that perform an action. 
 * These can be defined as a data class. Defining a class as a data class allows the Kotlin compiler 
 * to make certain assumptions, and to automatically implement some methods. 
 * For example, toString() is called behind the scenes by the println() function. 
 * When you use a data class, toString() and other methods are implemented automatically 
 * based on the class's properties.
 * 
 * 
 * When a class is defined as a data class, the following methods are implemented.

	equals()
    hashCode(): you'll see this method when working with certain collection types.
    toString()
    componentN(): component1(), component2(), etc.
    copy()
 * 
 * 
 * Note: 
 * A data class needs to have at least one parameter in its constructor, 
 * and all constructor parameters must be marked with val or var. 
 * A data class also cannot be abstract, open, sealed, or inner.
 */

enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

fun main() {
    
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    
    println(question1.toString())
    
    
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    
    println(question2.toString())
    
   
   val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    
   println(question3.toString())
   
}