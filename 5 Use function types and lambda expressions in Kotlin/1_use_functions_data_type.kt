/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    //to refer to a function as a value, you need to use the function reference operator (::)
    //val trickFunction = ::trick
    
    val trickFunction = trick

    trick()
    trickFunction()
    /*Output ->
     * No treats!
     * No treats!
     * */
     
     treat()
}


val trick = {
    println("No treats!")
}


/*
 * The data type of the trick variable that you declared earlier would be () -> Unit. 
 * The parentheses are empty because the function doesn't have any parameters. 
 * The return type is Unit because the function doesn't return anything. 
 * If you had a function that took two Int parameters and returned an Int, its data type would be (Int, Int) -> Int.
 * */
val treat: () -> Unit = {
    println("Have a treat!")
}

