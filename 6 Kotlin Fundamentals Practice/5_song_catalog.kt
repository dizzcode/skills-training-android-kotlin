/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

class Song(
    val songId: Int,
	val title: String, 
    val artist: String, 
    val yearPublished: Int, 
    val playCount: Int
){
    val isPopular: Boolean 
    get() = playCount >= 1000
    
    val description: String = "${title}, performed by ${artist}, was released in ${yearPublished}."
    
    fun printDescription() {
        println(description)
    } 
    
}

fun main() {
    
    val song = Song(1, "Don Jin Jin", "Shavinda", 2024, 200)
    
    println(song.isPopular)
    song.printDescription() 
 
}

