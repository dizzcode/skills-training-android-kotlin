/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 * Lists
 * A list is an ordered, resizable collection, typically implemented as a resizable array. 
 * When the array is filled to capacity and you try to insert a new element, 
 * the array is copied to a new bigger array.
 * 
 */

/**
 * List and MutableList
 ** List is an interface that defines properties and methods related to a read-only ordered collection of items.
 ** MutableList extends the List interface by defining methods to modify a list, such as adding and removing elements.
 * 
 */


fun main() {
    println("--------------------------------List------------------------------")
    // listOf() function
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    println()
    
   //Access elements from a list
   println(solarSystem[2])
   println(solarSystem.get(3))
   println()
   
    //indexOf()
    println(solarSystem.indexOf("Mars")) // 3
    println(solarSystem.indexOf("Sun"))  // -1
    println()
    
    //Iterate over list elements using a for loop
    for(planet in solarSystem){
        println(planet)
    }
    
    println("--------------------------------MutableList------------------------------")
    
    // mutableListOf() function
    val planets = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    
    //add() functions
    planets.add("Pluto")
    planets.add(3, "Big Moon")
    
    for((index,value) in planets.withIndex()){
        println("$index | $value")
    }
     println()
    
    
    //Update elements at a specific index
    planets[3] = "Future Moon"
    println(planets.get(3))
    println()
    
    //Remove elements from a list
    //Elements are removed using the remove() or removeAt() method.
    planets.removeAt(9)
    planets.remove("Future Moon")
    
    //contains() - returns a Boolean if an element exists in a list
    println(planets.contains("Pluto")) // False
    
    //Use the in operator to check if solarSystem contains "Future Moon"
    println("Future Moon" in planets) // False
    

}