/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/* NOTE
 * A function is a data type, so you can use it like any other data type. You can even return functions from other functions.
 * */

fun main() {
    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
    
    treatFunction()
    trickFunction()
    /*Output ->
     * Have a treat!
     * No treats!
     * */
  
}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if(isTrick){
        return trick
        
    } else{
        return treat
    }
    
}


val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}