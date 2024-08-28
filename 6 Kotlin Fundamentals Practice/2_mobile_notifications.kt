Solutions
Docs
Community
Teach
Play

2.0.20
JVM
Program arguments
Copy link
Share code
Run
/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
​
fun main() {
    val morningNotification = 51
    val eveningNotification = 135
    
    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
    
//      OUTPUT
//      You have 51 notifications.
//      Your phone is blowing up! You have 99+ notifications.
  
}
​
fun printNotificationSummary(numberOfMessages: Int) {
  
  if(numberOfMessages < 100){
     println("You have ${numberOfMessages} notifications.")
  } else {
     println("Your phone is blowing up! You have 99+ notifications.")
  }
}
​
​
