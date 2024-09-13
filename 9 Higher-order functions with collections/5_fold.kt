/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/**
 * fold()
 * 
 * The fold() function is used to generate a single value from a collection. 
 * This is most commonly used for things like calculating a total of prices, 
 * or summing all the elements in a list to find an average.
 * 
 * 
 * The fold() function takes two parameters:
 * 
 ** An initial value. The data type is inferred when calling the function 
 * (that is, an initial value of 0 is inferred to be an Int).
 * 
 ** A lambda expression that returns a value with the same type as the initial value.
 * 
 * 
 * 
 * he lambda expression additionally has two parameters:
 * 
 ** The first is known as the accumulator. It has the same data type as the initial value. 
 * Think of this as a running total. Each time the lambda expression is called, 
 * the accumulator is equal to the return value from the previous time the lambda was called.
 * 
 ** The second is the same type as each element in the collection.
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
    
    //'0.0' for the initial value -> Double
    //'total' for the accumulator
    //'cookie' for the collection element
    val totalPrice = cookies.fold(0.0){ total, cookie ->
        total + cookie.price
    }

    println("Total price: $${totalPrice}")
    

/** OUTPUT
 * >>

Total price: $10.83
 */
   
   
/**
 * Note: 
 * fold() is sometimes called reduce(). 
 * The fold() function in Kotlin works the same as the reduce() function 
 * found in JavaScript, Swift, Python, etc. 
 * 
 * 
 * Note: 
 * Kotlin collections also have a sum() function for numeric types, 
 * as well as a higher-order sumOf() function.
 */
    
}