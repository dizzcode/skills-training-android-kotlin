/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*

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
        runBlocking {
        println("Weather forecast")
        delay(1000)
        println("Sunny")
    }
}