/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*
import kotlin.system.*

    /**
     * Note 01
     * -------
     * Coroutine 
     * 
     * The "co-" in coroutine means cooperative. 
     * The code cooperates to share the underlying event loop when it suspends 
     * to wait for something, which allows other work to be run in the meantime. 
     * (The "-routine" part in "coroutine" means a set of instructions like a function.) 
     * In the case of this example, the coroutine suspends when it reaches the delay() call.
     */

fun main() {

    /**
     * Note 02
     * --------
     * runBlocking() 
     * function from the coroutines library. 
     * 
     * runBlocking() runs an event loop, which can handle multiple tasks at once 
     * by continuing each task where it left off when it's ready to be resumed.
     * ----------------------------------------------------------------------------
     * 
     * delay()
     * That means it will wait for the work in the delay() 
     * call to complete (until one second elapses), 
     * and then continue with executing the Sunny print statement.
     */
       val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            printForecast()
            printTemperature()
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

 /**
     * Note 03
     * --------
     * Suspending functions
     * 
     * A suspending function is like a regular function, but it can be suspended 
     * and resumed again later. To do this, suspend functions can only be called 
     * from other suspend functions that make this capability available.
     * 
     * A suspending function may contain zero or more suspension points.
     * ----------------------------------------------------------------------------
     * A suspension point is the place within the function where execution of the 
     * function can suspend. Once execution resumes, it picks up where it last left 
     * off in the code and proceeds with the rest of the function.
     * 
     */
suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}
