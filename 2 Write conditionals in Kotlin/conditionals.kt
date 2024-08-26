/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
    //ifStatement_ComparisonOperators_I()
    //ifStatement_ComparisonOperators_II()

    //whenStatement()
    //whenStatement_CommaForMultipleConditions()
    //whenStatement_InKeywordForRangeOfConditions()
    //whenStatement_IsKeyword()
    
    //ConvertAnIfStatementToAnExpression()
    ConvertWhenStatementToAnExpression()
    
}


fun ifStatement_ComparisonOperators_I(){
    /* Note #01 
     * 1 == 1
     * The == comparison operator compares the values to each other.
     * Besides the == comparison operator, there are additional comparison operators that you can use to create boolean expressions:
     * 
     * Less than: <
     * Greater than: >
     * Less than or equal to: <=
     * Greater than or equal to: >=
     * Not equal to: !=
     * 
     * * println(1 == 1) |Print as|--> true
     * 
     * */
    
      println(1 == 1)
}



fun ifStatement_ComparisonOperators_II(){
    /* Note #01 
     * 
     * */
    
    val trafficLightColor = "Black"
    
    if (trafficLightColor == "Red"){
        println("Stop")
    } else if(trafficLightColor == "Yellow"){
        println("Slow")
    } else if(trafficLightColor == "Green"){
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
}



fun whenStatement(){
    /* Note #01 
     * In Kotlin, when you deal with multiple branches, you can use the when statement instead of the if/else statement 
     * because it improves readability, 
     * which refers to how easy it is for human readers, typically developers, to read the code.
     * */
    val trafficLightColor = "Black"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> {
            println("Invalid traffic-light color")
            println("=========================>>")
        }
    }
}



fun whenStatement_CommaForMultipleConditions(){
    /* Note #01 : Use a comma (,) for multiple conditions

     when (x) {
        2 -> println("x is a prime number between 1 and 10.")
        3 -> println("x is a prime number between 1 and 10.")
        5 -> println("x is a prime number between 1 and 10.")
        7 -> println("x is a prime number between 1 and 10.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
     * 
     * */
    val x = 3

    when (x) {
        2 , 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}



fun whenStatement_InKeywordForRangeOfConditions(){
    /* Note #01 : Use the in keyword for a range of conditions
     * 
     * Ex:
     * 3    -> "x is a prime number between 1 and 10."
     * 1-10 -> "x is a number between 1 and 10, but not a prime number."
     * 11   -> "x isn't a prime number between 1 and 10."
     * */
    val x = 0

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}



fun whenStatement_IsKeyword(){
    /* Note #01 : 'is' keyword
     * 
     * Modify x to be of type Any. This is to indicate that x can be of value other than Int type.
     * */
    val x: Any = 20

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        is Int -> println("x is an integer number, but not between 1 and 10.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}



fun ConvertAnIfStatementToAnExpression(){
    /* Note #01 : Convert an if statement to an expression
     * 
     * if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
     * */
    val trafficLightColor = "Black"

    val message = 
    if (trafficLightColor == "Red") "Stop"
    else if (trafficLightColor == "Yellow") "Slow"
    else if (trafficLightColor == "Green") "Go"
    else "Invalid traffic-light color"
    
    println(message)
}




fun ConvertWhenStatementToAnExpression(){
    /* Note #01 : Convert a when statement to an expression
     * 
     * when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow", "Amber" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
     * */
    val trafficLightColor = "Black"

    val message = when (trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    
    println(message)
}



/*
 * Note: 
 * A when statement doesn't need the else branch to be defined. 
 * However, in most cases, a when expression requires the else branch because the when expression needs to return a value. 
 * As such, the Kotlin compiler checks whether all the branches are exhaustive. 
 * An else branch ensures that there won't be a scenario in which the variable doesn't get assigned a value.
 * */
 
 /*
  * Summary
  * In Kotlin, branching can be achieved with if/else or when conditionals.
  * 
  * The body of an if branch in an if/else conditional is only executed when the boolean expression inside the if branch condition returns a true value.
  * 
  * Subsequent else if branches in an if/else conditional get executed only when previous if or else if branches return false values.
  * 
  * The final else branch in an if/else conditional only gets executed when all previous if or else if branches return false values.
  * 
  * It's recommended to use the when conditional to replace an if/else conditional when there are more than two branches.
  * 
  * You can write more complex conditions in when conditionals with the comma (,), in ranges, and the is keyword.
  * 
  * if/else and when conditionals can work as either statements or expressions.
  * */
