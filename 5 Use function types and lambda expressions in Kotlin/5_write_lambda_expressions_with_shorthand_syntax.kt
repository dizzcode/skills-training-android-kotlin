/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/* NOTE
 * 
 * Omit parameter name
 * When a function has a single parameter and you don't provide a name, Kotlin implicitly assigns it the (it) name, 
 * so you can omit the parameter name and -> symbol, which makes your lambda expressions more concise.
 * 
 * Pass a lambda expression directly into a function
 * trickOrTreat(false, coins) |->| trickOrTreat(false, { "$it quarters" })
 * 
 * Use trailing lambda syntax
 * You can use another shorthand option to write lambdas when a function type is the last parameter of a function.
 * trickOrTreat(false, { "$it quarters" })  |->| trickOrTreat(false) { "$it quarters" }
 * 
 * Note: 
 * The composable functions that you used to declare your UI take functions as parameters and are typically called 
 * using trailing lambda syntax.
 * */

fun main() {
    
//     val coins: (Int) -> String = { 
//         "$it rupees"
//     }
    
    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }
    
    val treatFunction = trickOrTreat(false) {"$it rupees"}
    val trickFunction = trickOrTreat(true, null)
    
    treatFunction()
    trickFunction()
    /*Output ->
     * 5 rupees
     * Have a treat!
     * No treats!
     * */
  
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?) : () -> Unit {
    if(isTrick){
        return trick
        
    } else{
        if(extraTreat != null){
             println(extraTreat(5))
        }
        return treat
    }
    
}


val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}