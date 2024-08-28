/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

/* Answer
	printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
        printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
        printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
 * */

fun main() {
    
    val celsiusToFahrenheit: (Double) -> Double ={celsius ->
        ((celsius *9) / 5 ) + 32.0
    }
    printFinalTemperature(27.0, "Celsius", "Fahrenheit", celsiusToFahrenheit)
    
    
    val kelvinToCelsius: (Double) -> Double ={kelvin ->
        kelvin - 273.15
    }
    printFinalTemperature(350.0, "Kelvin", "Celsius", kelvinToCelsius)
    
    
    val fahrenheitToKelvin: (Double) -> Double ={fahrenheit ->
        ((5 * (fahrenheit - 32)) /9) + 273.15
    }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", fahrenheitToKelvin)
    
}


fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}