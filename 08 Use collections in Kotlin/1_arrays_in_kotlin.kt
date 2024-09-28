Solutions
Docs
Community
Teach
Play

2.0.20
JVM
Program arguments
Copy link
Share code
Run
/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
​
/**
 * What is an array?
 * An array is the simplest way to group an arbitrary number of values in your programs. 
 * 
 ** An array contains multiple values called elements, or sometimes, items.
 ** The elements in an array are ordered and are accessed with an index.
 * 
 */
​
/**
 * What's an index?
 * An index is a whole number that corresponds to an element in the array. 
 * An index tells the distance of an item from the starting element in an array. 
 * This is called zero-indexing. 
 * The first element of the array is at index 0, 
 * the second element is at index 1, 
 * because it's one place from the first element, and so on.
 * 
 */
​
/**
 * Accessing an array element by its index is fast. 
 * You can access any random element of an array by its index and expect it to 
 * take about the same amount of time to access any other random element. 
 * This is why it's said that arrays have random access.
 * 
 * 
 * An array has a fixed size. 
 * This means that you can't add elements to an array beyond this size. 
 * Trying to access the element at index 100 in a 100 element array will 
 * throw an exception because the highest index is 99 (remember that the first index is 0, not 1). 
 * You can, however, modify the values at indexes in the array.
 */
​
​
fun main() {
    
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    
    val gasPlanets = arrayOf<String>("Jupiter", "Saturn", "Uranus", "Neptune")
    
    val solarSystem = rockPlanets + gasPlanets
    
    
    /**
 * Access an element in an array
 ** The name of the array.
 ** An opening ([) and closing (]) square bracket.
 ** The index of the array element in the square brackets.
 * 
 */
​
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])
    println(solarSystem[7])
    println()
​
    //set the value of an array element by its index.
    solarSystem[3] = "Little Earth"
​
    println(solarSystem[3])
    println()
    
    
    //solarSystem[8] = "Pluto"
    //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
    
    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
    
    println(newSolarSystem[8])
​
}
