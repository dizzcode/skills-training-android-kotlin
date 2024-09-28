/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 * 
 * 
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
 
/**
 * Loop over a list with forEach()
 * 
 * forEach(action: (T) -> Unit)
 * 
 * forEach() takes a single action parameter—a function of type (T) -> Unit.
 */
    
        println("----------- forEach()")
        
        cookies.forEach{
            println("Menu Item : ${it.name}")
        }
        
        
/**
 * Embed expressions in strings
 * 
 * dollar symbol ($) could be used with a variable name to insert it into a string. 
 * However, this doesn't work as expected when combined with the 
 * dot operator (.) to access properties.
 * 
 * println("Menu item: $it.name")
 * >>Menu item: Cookie@5a10411.name
 * 
 * println("Menu item: ${it.name}")
 * >> Menu item: Chocolate Chip
 */
   
    
}