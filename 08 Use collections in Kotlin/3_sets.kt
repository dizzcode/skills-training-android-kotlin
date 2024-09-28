/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 ** Sets
 * A set is a collection that does not have a specific order and does not allow duplicate values.
 * How is a collection like this possible? The secret is a hash code. 
 * 
 * 
 * Hash code
 * A hash code is an Int produced by the hashCode() method of any Kotlin class. 
 * It can be thought of as a semi-unique identifier for a Kotlin object. 
 * A small change to the object, such as adding one character to a String, 
 * results in a vastly different hash value. 
 * While it's possible for two objects to have the same hash code (called a hash collision), 
 * the hashCode() function ensures some degree of uniqueness, 
 * where most of the time, two different values each have a unique hash code.
 * 
 * Note: 
 * A set uses hash codes as array indices. 
 * Of course, there can be about 4 billion different hash codes, so a Set isn't just one giant array. 
 * Instead, you can think of a Set as an array of lists.
 * 
 * Since hash collisions are relatively uncommon, even when the potential indices are limited, 
 * the inner lists at each array index will only have one or two items each, 
 * unless tens or hundreds of thousands of elements are added.
 * 
 */

/**
 * Sets have two important properties:
 * 
 * 1: Searching for a specific element in a set is fast—compared with lists—especially 
 * for large collections. 
 * While the indexOf() of a List requires checking each element from the beginning 
 * until a match is found, on average, it takes the same amount of time to check 
 * if an element is in a set, whether it's the first element or the hundred thousandth.
 *  
 * 2: Sets tend to use more memory than lists for the same amount of data, 
 * since more array indices are often needed than the data in the set.
 * 
 * The benefit of sets is ensuring uniqueness. 
 * If you were writing a program to keep track of newly discovered planets, 
 * a set provides a simple way to check if a planet has already been discovered. 
 * With large amounts of data, this is often preferable to checking if an 
 * element exists in a list, which requires iterating over all the elements.
 */


fun main() {
    
    println("--------------------------------MutableSet------------------------------")
    println("MutableSet implements Set, so any class implementing MutableSet needs to implement both.")
    
    // mutableListOf() function
    val planets = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    
    //size property
    println(planets.size)
    
    //add() function
    planets.add("Pluto")
    println(planets.size)
    println()
    
    for((index,value) in planets.withIndex()){
        println("$index | $value")
    }
     println()
    
    

    //Elements are removed using the remove()method.
    planets.remove("Future Moon")
    
    //contains() - returns a Boolean if an element exists in a list
    println(planets.contains("Pluto")) // True
    
    //Use the in operator to check if solarSystem contains "Future Moon"
    println("Future Moon" in planets) // False
    
}