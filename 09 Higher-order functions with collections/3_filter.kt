/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 * filter()
 * 
 * The filter() function lets you create a subset of a collection. 
 * For example, if you had a list of numbers, you could use filter() 
 * to create a new list that only contains numbers divisible by 2.
 * 
 * For each item in the collection:
 ** If the result of the lambda expression is true, then the item is included in the new collection.
 ** If the result is false, the item is not included in the new collection.
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
    
    val softBackedMenu = cookies.filter{
        it.softBaked
    }

    println("------- Soft Cookies ----------")
    
    softBackedMenu.forEach{ item ->
        println("${item.name} - $${item.price} ")
    }


/** OUTPUT
 * >>
 * 
------- Soft Cookies ----------
Banana Walnut - $1.49 
Snickerdoodle - $1.39 
Blueberry Tart - $1.79 

 */
   
    
}