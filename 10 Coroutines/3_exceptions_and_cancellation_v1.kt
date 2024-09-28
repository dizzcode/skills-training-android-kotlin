/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*
import kotlin.system.*

    /**
     * Note 01
     * ------------------------
     *  Exceptions
     * ------------------------
     * 
     * An exception is an unexpected event that happens during execution of your code. 
     * You should implement appropriate ways of handling these exceptions, to prevent 
     * your app from crashing and impacting the user experience negatively.
     * -------------------------------------------------------------------------
     * 
     */
    

fun main() {

   /**
     * Note 02
     * --------
     * 
     * You can still use a try-catch expression to catch and handle 
     * exceptions in coroutines. The reason is because with structured concurrency, 
     * the sequential code is still synchronous code so the try-catch block will 
     * still work in the same expected way.
     */
     runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
     
    /**
     * OUTPUT
     * -------
     * Weather forecast
     * Caught exception java.lang.AssertionError: Temperature is invalid
     * Sunny { No temperature found }
     * Have a good day!
     */
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async {
        try {
            getTemperature()
        } catch (e: AssertionError) {
            println("Caught exception $e")
            "{ No temperature found }"
        }
    }

    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

    /**
     * Note 03
     * --------
     * 
     * throw
     * --------
     * the throw keyword in Kotlin followed by a new instance of an 
     * exception which extends from Throwable
     * 
     * AssertionError 
     * --------------
     * Throwing this exception ("Temperature is invalid") stops further execution 
     * of the getTemperature() function.
     * 
     * OUTPUT
     * ------
     * Exception in thread "main" java.lang.AssertionError: Temperature is invalid
     */
suspend fun getTemperature(): String {
    delay(500)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}

  
