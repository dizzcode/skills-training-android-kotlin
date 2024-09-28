/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*
import kotlin.system.*

    

fun main() {

    /**
     * Note 01
     * ------------------------
     *  Parallel Decomposition
     * ------------------------
     * 
     * Use the async() function from the coroutines library if you care about 
     * when the coroutine finishes and need a return value from it.
     * -------------------------------------------------------------------------
     * 
     * The async() function returns an object of type Deferred, which is 
     * like a promise that the result will be in there when it's ready. 
     * You can access the result on the Deferred object using await().
     */

    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")

            println(getWeatherReport())

            println("Have a good day!")
        }
    }
    println()
    println("Execution time: ${time / 1000.0} seconds")
    
    
    /**
     * OUTPUT
     * -------
     * Weather forecast
     * Sunny 30°C
     * Have a good day!
     * 
     * Execution time: 1.116 seconds
     */
}


 /**
  * Note 02
  * ------------------------
  *  coroutineScope{}
  * ------------------------
  * 
  * coroutineScope{} creates a local scope for this weather report task. 
  * The coroutines launched within this scope are grouped together within this scope, 
  * which has implications for cancellation and exceptions that you'll learn about soon.
  * -------------------------------------------------------------------------
  * 
  * The async() function returns an object of type Deferred, which is 
  * like a promise that the result will be in there when it's ready. 
  * You can access the result on the Deferred object using await().
  * 
  *-------------------------------------------------------------------------
  * coroutineScope() will only return once all its work, including any coroutines 
  * it launched, have completed.
  * 
  */
  
suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}
