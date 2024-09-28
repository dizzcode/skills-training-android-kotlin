/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
class SmartDevice(
    val name: String,
    val category: String
) {
    
    var deviceStatus = "online"
    get() = field
    set(value) {
      field = value  
    }
    
    var speakerVolume = 0
    get() = (field + 1)
    
    set(value) {
      if (value in 0..100) {
            field = value
        }
    }
    
    constructor(name: String, category: String, statusCode: Int) : this (name, category){
        deviceStatus = when (statusCode){
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
    
    
    fun turnOn(){
        println("Smart device is turned on.")
    }
    
    fun turnOff(){
        println("Smart device is turned off.")
        
    }
}

fun main() {
    /* When you define the variable with the val keyword to reference the object, 
     * the variable itself is read-only, but the class object remains mutable. 
     * This means that you can't reassign another object to the variable, 
     * but you can change the object's state when you update its properties' values.
     * */
    val smartTvDevice = SmartDevice(name = "Android TV", category = "Entertainment", statusCode = 2)
    
    println("Device name is : ${smartTvDevice.name}")
    println("Device current volume is : ${smartTvDevice.speakerVolume}")
    smartTvDevice.speakerVolume = 20
    println("Device current volume is : ${smartTvDevice.speakerVolume}")
     println("Device status is : ${smartTvDevice.deviceStatus}")
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
    
}

/*Special Note:
 * Variable ->
 * You use the val keyword to create an immutable variable and the var keyword for a mutable variable. 
 * The val or var keyword is followed by the name of the variable, then an = assignment operator, then the 
 * instantiation of the class object.
 * 
 * Functions ->
 * When you define a function in the class body, it's referred to as a member function or a method, 
 * and it represents the behavior of the class.
 * */