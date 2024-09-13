/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 ** Map collection
 * A Map is a collection consisting of keys and values. 
 * It's called a map because unique keys are mapped to other values. 
 * A key and its accompanying value are often called a key-value pair.
 * 
 * Note: 
 * A map's keys are unique. A map's values, however, are not. 
 * Two different keys could map to the same value. 
 * For example, "Mercury" has 0 moons, and "Venus" has 0 moons.
 * 
 * 
 * Accessing a value from a map by its key is generally faster 
 * than searching through a large list, such as with indexOf()
 * 
 * Maps can be declared using the mapOf() or mutableMapOf() function. 
 * Maps require two generic types separated by a comma—one for the keys and another for the values.
 * 
 * EX: mutableMapOf<KEY_TYPE, VALUE_TYPE>()
 */


fun main() {
    
    println("--------------------------------MutableMap------------------------------")
    
    //To populate a map with initial values, each key value pair consists of the key, 
    //followed by the [to] operator, followed by the value. 
    //Each pair is separated by a comma.

    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    
    //size property
    println(solarSystem.size)
    println()
    
    //Add Value
    solarSystem["Pluto"] = 5
    
    println(solarSystem.size)
    println()
    
    //Get
    println(solarSystem["Pluto"]) //5
    println(solarSystem.get("Jupiter")) //79
    println(solarSystem.get("Theia")) //null
    println()
    
    //Remove Value
    solarSystem.remove("Pluto")
    
    println(solarSystem.size)
    println()
    
    
    //modify a value for a key that already exists.package
    solarSystem["Jupiter"] = 78
	println(solarSystem["Jupiter"])

    
}