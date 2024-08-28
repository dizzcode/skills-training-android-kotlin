/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {    
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        
       val hobbyData: String = if(hobby == null) "" else "Likes to ${hobby}. "
        
       val referrerData: String = if(referrer == null){
           "Doesn't have a referrer."
       } else {
           "Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}."
       }
        
       println("Name: $name")
       println("Age: $age")
       println("${hobbyData}${referrerData}\n")
    }
}

