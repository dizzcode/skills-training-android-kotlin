/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/* Enum class 
 * An enum class is used to create types with a limited set of possible values. 
 * In the real world, for example, the four cardinal directions—north, south, east, and west—could be represented 
 * by an enum class. There's no need, and the code shouldn't allow, for the use of any additional directions. 
 * The syntax for an enum class is shown below.
 * 
 * enum class ENUM_NAME{
 * 		Case1, Case2, Case3
 * }
 * 
 * 
 * Note: You refer to enum constants using the dot operator.
 * 
 * ENUM_NAME.CASE_NAME
 */

enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

fun main() {
    
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    
    println("Question 1 \n" +
            "| Question Text : ${question1.questionText} \n" +
            "| Answer : ${question1.answer} \n" +
            "| Difficulty : ${question1.difficulty} \n\n")
    
    
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    
    println("Question 2 \n" +
            "| Question Text : ${question2.questionText} \n" +
            "| Answer : ${question2.answer} \n" +
            "| Difficulty : ${question2.difficulty} \n\n")
    
   
   val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    
    println("Question 3 \n" +
            "| Question Text : ${question3.questionText} \n" +
            "| Answer : ${question3.answer} \n" +
            "| Difficulty : ${question3.difficulty} \n\n")
   
}