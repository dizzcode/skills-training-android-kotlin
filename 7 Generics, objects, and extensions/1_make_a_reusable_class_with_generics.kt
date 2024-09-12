/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/** Take a look at the code you wrote. Do you notice the repetition?
class FillInTheBlankQuestion(
	val questionText: String,
    val answer: String,
    val  defficulty: String
)

class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)

class NumericQuestion(
	val questionText: String,
    val answer: Int,
    val difficulty: String
)
*/

/* What is a generic data type?
 * Generic types, or generics for short, allow a data type, such as a class, 
 * to specify an unknown placeholder data type that can be used with its properties and methods.
 * 
 * class CLASS_NAME <GENERIC_DATA_TYPE>(
 * 		val PROPERTY_NAME : GENERIC_DATA_TYPE
 * )
 * 
 * 
 * Note: You'll often see a generic type named T (short for type), or other capital letters 
 * if the class has multiple generic types. However, there is definitely not a rule and 
 * you're welcome to use a more descriptive name for generic types.
 */

class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main() {
    
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    
    println("Question 1 \n" +
            "| Question Text : ${question1.questionText} \n" +
            "| Answer : ${question1.answer} \n" +
            "| Difficulty : ${question1.difficulty} \n\n")
    
    
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    
    println("Question 2 \n" +
            "| Question Text : ${question2.questionText} \n" +
            "| Answer : ${question2.answer} \n" +
            "| Difficulty : ${question2.difficulty} \n\n")
    
   
   val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
    
    println("Question 3 \n" +
            "| Question Text : ${question3.questionText} \n" +
            "| Answer : ${question3.answer} \n" +
            "| Difficulty : ${question3.difficulty} \n\n")
   
}