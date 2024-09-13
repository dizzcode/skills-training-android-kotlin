/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 * groupBy()
 * 
 * The groupBy() function can be used to turn a list into a map, based on a function. 
 * Each unique return value of the function becomes a key in the resulting map. 
 * The values for each key are all the items in the collection that produced that unique return value.
 * 
 * The data type of the keys is the same as the return type of the function passed into groupBy(). 
 * The data type of the values is a list of items from the original list.
 * 
 * Note: 
 * The value doesn't have to be the same type of the list. 
 * There's another version of groupBy() that can transform the values into a different type.
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
    
    val groupedMenu = cookies.groupBy{
        it.softBaked
    }
    
    val softBakedMenu = groupedMenu[true] ?: listOf() 
    val crunchyMenu = groupedMenu[false] ?: emptyList()
    // listOf() == emptyList() | emptyList() -> more readable.

    println("------- Soft Cookies ----------")
    
    softBakedMenu.forEach{ item ->
        println("${item.name} - $${item.price} ")
    }
    
    println()
    println("------- Crunchy Cookies ----------")
    
    crunchyMenu.forEach{ item ->
        println("${item.name} - $${item.price} ")
    }
    
    //**Note: If you only need to split a list in two, an alternative is the partition() function.


/** OUTPUT
 * >>
 * 
------- Soft Cookies ----------
Banana Walnut - $1.49 
Snickerdoodle - $1.39 
Blueberry Tart - $1.79 

------- Crunchy Cookies ----------
Chocolate Chip - $1.69 
Vanilla Creme - $1.59 
Chocolate Peanut Butter - $1.49 
Sugar and Sprinkles - $1.39 

 */
   
    
}