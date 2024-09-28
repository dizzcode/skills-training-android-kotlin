/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/* NOTE
 * 
 * When a function returns a function or takes a function as an argument, it's called a higher-order function.
 * 
 * 
 * The repeat() function is one such higher-order function. 
 * The repeat() function is a concise way to express a for loop with functions.
 * 
 * repeat(times: Int, action: (Int) -> Unit)
 * 
 * 
 * */

fun main() {

    val treatFunction = trickOrTreat(false) {"$it rupees"}
    val trickFunction = trickOrTreat(true, null)
    
    
    repeat(4){
        treatFunction()
    }
    trickFunction()
    
    /*Output ->
     * 5 quarters
     * Have a treat!
     * Have a treat!
     * Have a treat!
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