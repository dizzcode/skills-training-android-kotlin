/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal open class SmartDevice protected constructor(
    val name: String,
    val category: String
) {
    private var deviceStatus = "online"
    
    open val deviceType = "unknown"
   
    open fun turnOn(){
        deviceStatus = "on"
    }
    
    open fun turnOff(){
        deviceStatus = "off"
    }
    
    fun isDeviceTurnOn(): Boolean{
        return deviceStatus == "on"
    }
    
    fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }
}



// Smart TV IS-A smart device.
internal class SmartTvDevice (
    tvName: String, 
    tvCategory: String
) : SmartDevice (
	name = tvName,
    category = tvCategory
){
    
    private var speakerVolume  by RangeRegulator(initialValue = 10, minValue = 0, maxValue = 100)
    
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
    
    override val deviceType = "Smart TV"
    
    fun increaseSpeackerVolume(){
        speakerVolume++
        println("Speaker volume increaced to $speakerVolume")
    }
    
    fun decreaseVolume(){
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }
    
    internal fun nextChannel(){
        channelNumber++
        println("Channel number increased to $channelNumber")
    }
    
    fun previousChannel(){
        channelNumber--
        println("Channel number decreased to $channelNumber")
    }
    
    
    override fun turnOn(){
    	super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }
    
    override fun turnOff(){
       super.turnOff()
        println("$name turned off") 
    }

}


internal class SmartLightDevice(
	lightName: String, 
    lightCategory: String,
    
) : SmartDevice(
	name = lightName,
    category = lightCategory
){
    private var brightnessLevel by RangeRegulator(initialValue = 10, minValue = 0, maxValue = 100)
    
    override val deviceType = "Smart Light"
    
    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness is increased to $brightnessLevel")
    }
    
    fun decreaseBrightness(){
        brightnessLevel--
        println("Brightness is decreased to $brightnessLevel")
    }
    
    override fun turnOn(){
        super.turnOn()
        brightnessLevel = 5
        println("$name turned on, The brightness level is $brightnessLevel")
    }
    
    override fun turnOff(){
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off")
    }
}


// The SmartHome class HAS-A smart TV device and smart light.
internal class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
){
    
    var deviceTurnOnCount = 0
    private set
    
    fun turnOnTv(){
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    
    fun turnOffTv(){
        if(!smartTvDevice.isDeviceTurnOn()) return
        
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    
    fun incraseTvVolume(){
        if(!smartTvDevice.isDeviceTurnOn()) return
        
        smartTvDevice.increaseSpeackerVolume()
    }
    
    fun decreaseTvVolume(){
        if(!smartTvDevice.isDeviceTurnOn()) return
        
        smartTvDevice.decreaseVolume()
    }
    
    
    
    fun changeTvChannelToNext(){
        if(!smartTvDevice.isDeviceTurnOn()) return
        
        smartTvDevice.nextChannel()
    }
    
    fun changeTvChannelToPrevious(){
        if(!smartTvDevice.isDeviceTurnOn()) return
        
        smartTvDevice.previousChannel()
    }
    
    fun printSmartTvInfo(){
        smartTvDevice.printDeviceInfo()
    }
    
    
    fun turnOnLight(){
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    
    fun turnOffLight(){
        if(!smartLightDevice.isDeviceTurnOn()) return
        
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    
    fun increaseLightBrightness(){
        if(!smartLightDevice.isDeviceTurnOn()) return
        
        smartLightDevice.increaseBrightness()
    }
    
    fun decreaseLightBrightness(){
        if(!smartLightDevice.isDeviceTurnOn()) return
        
        smartLightDevice.decreaseBrightness()
    }
    
     fun printSmartLightInfo(){
        smartLightDevice.printDeviceInfo()
    }
    
    
    fun turnOffAllDevices(){
        if(smartTvDevice.isDeviceTurnOn()){
                turnOffTv() 
        }
        
         if(smartTvDevice.isDeviceTurnOn()){
                turnOnLight() 
        } 
    }
    
}



class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    
    var fieldData = initialValue
    
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int{
        return fieldData
    }

     override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int){
        if(value in minValue..maxValue){
            fieldData = value
        }
    }
}


fun main() {

    var smartDevice : SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    
    smartDevice.turnOn()
    smartDevice.printDeviceInfo()
    //print -> Android TV is turned on. Speaker volume is set to 10 and channel number is set to 1.
    
    smartDevice = SmartLightDevice(lightName = "Google Light", lightCategory = "Utility")
    smartDevice.turnOn()
    smartDevice.printDeviceInfo()
     //print -> Google Light turned on, The brightness level is 5
    
}

// Summary
// There are four main principles of OOP: encapsulation, abstraction, inheritance, and polymorphism.
// Classes are defined with the class keyword, and contain properties and methods.
// Properties are similar to variables except properties can have custom getters and setters.
// A constructor specifies how to instantiate objects of a class.
// You can omit the constructor keyword when you define a primary constructor.
// Inheritance makes it easier to reuse code.
// The IS-A relationship refers to inheritance.
// The HAS-A relationship refers to composition.
// Visibility modifiers play an important role in the achievement of encapsulation.
// Kotlin provides four visibility modifiers: the public, private, protected, and internal modifiers.
// A property delegate lets you reuse the getter and setter code in multiple classes.