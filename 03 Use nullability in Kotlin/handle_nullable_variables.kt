/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
	 useElvisOperator()
    
}


fun intro(){
    /* NOTE #01
     * to use the dot (.) operator to access methods and properties of non-nullable variables.
     * */

     var favoriteActor: String = "Sandra Oh"
    println(favoriteActor.length)
    
    //Print ->
    //9
}


fun AccessPropertyOfNullableVariable(){
//     var favoriteActor: String? = "Sandra Oh"
//     println(favoriteActor.length)
    
     //Print ->
    //Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type 'kotlin.String?'.
}


fun safeCallOperator(){
    /* NOTE #01
     * To use the ?. safe call operator to access a method or property, add a ? 
     * symbol after the variable name and access the method or property with the . notation.
     * 
     * The ?. safe call operator allows safer access to nullable variables because the 
     * Kotlin compiler stops any attempt of member access to null references and returns null for the member accessed.
     * */
    
	var favoriteActorOne: String? = "Sandra Oh"
    println(favoriteActorOne?.length)
     //Print ->
    //9
    
    var favoriteActorTwo: String? = null
    println(favoriteActorTwo?.length)
     //Print ->
    //null
    
    /* SPECIAL NOTE: 
      * You can also use the ?. safe call operators on non-nullable variables to access a method or property. 
      * While the Kotlin compiler won't give any error for this, it's unnecessary 
      * because the access of methods or properties for non-nullable variables is always safe.
     * */ 
}


fun notNullAssertionOperator(){
    /* NOTE #01
     * You can also use the !! not-null assertion operator to access methods or properties of nullable variables.
     * 
     * As the name suggests, if you use the !! not-null assertion, it means that you assert that the value of the variable 
     * isn't null, regardless of whether it is or isn't.
     * */
    
       /* SPECIAL NOTE: 
      * Unlike ?. safe-call operators, the use of a !! not-null assertion operator 
      * may result in a NullPointerException error 
      * being thrown if the nullable variable is indeed null.
      * 
      * When not handled, exceptions cause runtime errors.
     * */ 
    
    
     var favoriteActorOne: String? = "Sandra Oh"
    println(favoriteActorOne!!.length)
    //Print ->
    //9
    
    var favoriteActorTwo: String? = null
   // println(favoriteActorTwo!!.length)
    /*Exception in thread "main" java.lang.NullPointerException
	 at FileKt.notNullAssertionOperator (File.kt:84) 
	 at FileKt.main (File.kt:7) 
 	 at FileKt.main (File.kt:-1) 
     * */  
}



fun useTheIfElseConditionals(){
    /* NOTE #01
     * if/else statements
     * An if/else statement can be used together with a null check as follows:
     * nullableVariable != null expression
     * */
    
    var favoriteActorOne: String? = "Sandra Oh"

    if (favoriteActorOne != null) {
      println("The number of characters in your favorite actor's name is ${favoriteActorOne.length}.")
    }
    
    //Print -> The number of characters in your favorite actor's name is 9.
    
    
    var favoriteActorTwo: String? = null

    if(favoriteActorTwo != null) {
      println("The number of characters in your favorite actor's name is ${favoriteActorTwo.length}.")
    } else {
      println("You didn't input a name.")
    }
    //Print -> You didn't input a name.
    
    
    /*NOTE
     * Notice that you can access the name's length method directly with the . operator 
     * because you access the length method inside the if branch after the null check. 
     * As such, the Kotlin compiler knows that there's no possibility that the 
     * favoriteActorTwo variable is null, so the compiler allows direct access to the property.
     * */
}


fun useIfElseExpressions(){
    /* NOTE #01
     * You can also combine the null check with an if/else expression to convert a nullable variable to a non-nullable variable.
     * */
    
    var favoriteActor: String? = "Sandra Oh"

    val charactersLength = if (favoriteActor != null) {
      favoriteActor.length
    } else {
      0
    }
    
    println("The number of characters in your favorite actor's name is $charactersLength.")
    
    //Print -> The number of characters in your favorite actor's name is 9.
}



fun useElvisOperator(){
    /* NOTE #01
     * The ?: Elvis operator is an operator that you can use together with the ?. safe-call operator. 
     * 
     * With the ?: Elvis operator, you can add a default value when the ?.
     * 
     * safe-call operator returns null. It's similar to an if/else expression, but in a more idiomatic way.
     * */
    
    
    /* NOTE #02
     * If the variable isn't null, the expression before the ?: Elvis operator executes. 
     * If the variable is null, the expression after the ?: Elvis operator executes.
     * */
    
    var favoriteActor: String? = "Sandra Oh"

    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")

    
    //Print -> The number of characters in your favorite actor's name is 9.
    
    /* NOTE #03
     * The ?: Elvis operator is named after Elvis Presley, the rock star, 
     * because it resembles an emoticon (emotion icon) of his quiff(The quiff is a hairstyle that combines the 1950s) when you view it sideways.
     * */
     
     var emojiName : String? = "Sad"
     val charLength = emojiName?.length ?: 0
    println("Emoji name\'s character length is $charLength")
    
}










//Summary
// A variable can be set to null to indicate that it holds no value.
// Non-nullable variables cannot be assigned null.
// Nullable variables can be assigned null.
// To access methods or properties of nullable variables, you need to use ?. safe-call operators or !! not-null assertion operators.
// You can use if/else statements with null checks to access nullable variables in non-nullable contexts.
// You can convert a nullable variable to a non-nullable type with if/else expressions.
// You can provide a default value for when a nullable variable is null with the if/else expression or the ?: Elvis operator.