/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*

fun main() {

    /**
     * Note 01
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