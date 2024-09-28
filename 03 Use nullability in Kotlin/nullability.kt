/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
	 nonNullableAndNullableVariables()
    
}

fun nullInKotlin(){
    val favoriteActor = null
    println(favoriteActor)
    
    //Print -> null
}


fun nonNullableError(){
    //Variable reassignments with null
    
//     var name: String = "Sandra Oh"
// 	name = null
//     println(name)
    
    //Print -> Null cannot be a value of a non-null type 'kotlin.String'.
}


fun nonNullableAndNullableVariables(){
    /* NOTE #01
     * Nullable types are variables that can hold null.
     * Non-null types are variables that can't hold null.
     * */

    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor)

    favoriteActor = null
    println(favoriteActor)
    
    //Print ->
    //Sandra Oh
	//null
    
     var number: Int? = 10
    println(number)
    
    number = null
    println(number)
    
    //Print ->
    //10
	//null
    
    
     /* SPECIAL Note: 
      * While you should use nullable variables for variables that can carry null,
      * you should use non-nullable variables for variables that can never carry null 
      * because the access of nullable variables requires more complex handling.
     * */ 
}

