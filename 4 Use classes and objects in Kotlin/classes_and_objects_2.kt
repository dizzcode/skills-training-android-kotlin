/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

//class starts with the private, protected, or internal modifiers followed by the syntax that defines a class.
//The modifier is specified after the class name, but before the constructor keyword.
internal open class SmartDevice protected constructor(
    val name: String,
    val category: String
) {
    
    //property starts with the private, protected, or internal modifier followed by the syntax
    //protected modifier to the set() function
    private var deviceStatus = "online"
    get() = field
    //protected set
    
    open val deviceType = "unknown"
   

//In the body of the SmartDevice superclass before the fun keyword of each method, add an open keyword:
    open fun turnOn(){
        deviceStatus = "on"
    }
    
    open fun turnOff(){
        deviceStatus = "off"
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
    
    private var speakerVolume = 10
    get() = field
    set(value) {
      if (value in 0..100) {
            field = value
        }
    }
    
    private var channelNumber: Int = 1
    get() = field
    set(value){
        if(value in 0..200){
            field = value
        }
    }
    
    override val deviceType = "Smart TV"
    
    fun increaseSpeackerVolume(){
        speakerVolume++
        println("Speaker volume increaced to $speakerVolume")
    }
    
    //method starts with the private, protected, or internal modifiers followed by the syntax that defines a method.
    internal fun nextChannel(){
        channelNumber++
        println("Channel number increased to $channelNumber")
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
    private var brightnessLevel: Int = 10
    set(value){
        if(value in 0..100)
        field = value
    }
    
    override val deviceType = "Smart Light"
    
    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness is increased to $brightnessLevel")
    }
    
    
    //In the SmartLightDevice subclass before the fun keyword of the turnOn() and turnOff() methods, add the override keyword:
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
//In the SmartHome class constructor, use the val keyword to create a smartTvDevice property of SmartTvDevice type:
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
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    
    fun incraseTvVolume(){
        smartTvDevice.increaseSpeackerVolume()
    }
    
    fun chnageTvChannelToNext(){
        smartTvDevice.nextChannel()
    }
    
    
    fun turnOnLight(){
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    
    fun turnOffLight(){
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    
    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }
    
    
    fun turnOffAllDevices(){
        turnOffTv()
        turnOnLight()
    }
    
}


fun main() {
   
    
    var smartDevice : SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    
    smartDevice.turnOn()
    //print -> Android TV is turned on. Speaker volume is set to 10 and channel number is set to 1.
    
    smartDevice = SmartLightDevice(lightName = "Google Light", lightCategory = "Utility")
    smartDevice.turnOn()
     //print -> Google Light turned on, The brightness level is 5
    
}

/*Special Note:
 * 
 * */