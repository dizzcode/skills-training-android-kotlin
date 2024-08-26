/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    val hello = "hello"
    val birthdayGreeting : String = birthdayGreeting(name = "Shavinda", age = 29)
   println(birthdayGreeting) 
}

fun birthdayGreeting(name : String, age : Int, sign : String = "Good") : String {
    val msg1 = "Happy Birthday, $name!"
   val msg2 ="You are now $age years old! |$sign|"
    return "$msg1\n$msg2"
}