/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 * map()
 * 
 * The map() function lets you transform a collection into a new collection 
 * with the same number of elements
 * 
 * example, 
 * map() could transform a List<Cookie> into a 
 * List<String> only containing the cookie's name, provided you tell the 
 * map() function how to create a String from each Cookie item.
 */

class Cookie(
	val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut", 
        softBaked = true, 
        hasFilling = false, 
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    
    val fullMenu = cookies.map{
        "${it.name} - $${it.price}"
    }

    println("------- Full Menu ----------")
    
    fullMenu.forEach{ item ->
        println(item)
    }


/** OUTPUT
 * >>
 * 
------- Full Menu ----------
Chocolate Chip - $1.69
Banana Walnut - $1.49
Vanilla Creme - $1.59
Chocolate Peanut Butter - $1.49
Snickerdoodle - $1.39
Blueberry Tart - $1.79
Sugar and Sprinkles - $1.39

 */
   
    
}