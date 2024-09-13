/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 * sortedBy()
 * sortedBy() lets you specify a lambda that returns the property 
 * you'd like to sort by. 
 * 
 * For example, if you'd like to sort by price, the lambda would return it.price. 
 * So long as the data type of the value has a natural sort order—strings are 
 * sorted alphabetically, numeric values are sorted in ascending order—it will be 
 * sorted just like a collection of that type.
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
    
    val alphabeticalMenu = cookies.sortedBy{
        it.name
    }

    println("---------- Alphabetical Menu ---------- ")
    
    alphabeticalMenu.forEach{
        println(it.name)
    }
    

/** OUTPUT
 * >>

---------- Alphabetical Menu ---------- 
Banana Walnut
Blueberry Tart
Chocolate Chip
Chocolate Peanut Butter
Snickerdoodle
Sugar and Sprinkles
Vanilla Creme
 */
   
   
/**
 * Note: 
 * Kotlin collections also have a sort() function if the data type has a natural sort order.
 */
    
}