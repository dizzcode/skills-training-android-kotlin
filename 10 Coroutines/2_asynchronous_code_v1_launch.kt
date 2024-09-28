/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*
import kotlin.system.*

    

fun main() {

    /**
     * Note 01
     * -------
     * launch() 
     * 
     * Use the launch() function from the coroutines library to launch a new coroutine. 
     * To execute tasks concurrently, add multiple launch() functions to your code so that
     *  multiple coroutines can be in progress at the same time.
     * -----------------------------------------------------------------------------------
     * 
     * By using launch(), multiple tasks can run concurrently in your code, 
     * which is a powerful capability to use in the Android apps you develop.
     */
    
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            
            launch {
                printForecast()
            }
            
            launch {
                printTemperature()
            }
            
            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
    
    
    /**
     * OUTPUT
     * -------
     * Weather forecast
     * Have a good day!
     * Sunny
     * 30°C
     * Execution time: 1.117 seconds
     */
}

suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}
