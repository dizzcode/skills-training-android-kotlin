/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/* NOTE
 * 
 * */

fun main() {
    
    val coins: (Int) -> String = { quantity ->
        "$quantity rupees"
    }
    
    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }
    
    val treatFunction = trickOrTreat(false, coins)
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