/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*
import kotlin.system.*

    /**
     * Note 01
     * ------------------------
     *  Cancellation
     * ------------------------
     * 
     * A similar topic to exceptions is cancellation of coroutines. 
     * This scenario is typically user-driven when an event has caused the app to 
     * cancel work that it had previously started.
     * 
     * For example, say that the user has selected a preference in the app 
     * that they no longer want to see temperature values in the app. 
     * They only want to know the weather forecast (e.g. Sunny), but not the exact temperature. 
     * Hence, cancel the coroutine that is currently getting the temperature data.
     * -------------------------------------------------------------------------
     * 
     */
    
fun main() {
    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    
    delay(200)
    temperature.cancel()

    "${forecast.await()}"
}

 /**
  * OUTPUT
  * ------------------------
  * Weather forecast
  * Sunny
  * Have a good day!
  */

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}

  
