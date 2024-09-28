/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

enum class Daypart{
    MORNING, AFTERNOON, EVENING
}

data class Event(
	val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

val Event.durationOfEvent: String
get()= (
    if(durationInMinutes < 60) {
         "short"
    } else {
         "long"
    }
)



fun main() {
    
    val studyEvent = Event(
        title="Study Kotlin", 
        description="Commit to studying Kotlin at least 15 minutes per day.",
    	daypart= Daypart.EVENING,
        durationInMinutes = 15
    )
    
    println(studyEvent.toString())

    println()
    println("---------------------------------")
    println()
    
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    val eventList = mutableListOf<Event>(
        event1,
        event2,
        event3,
        event4,
        event5,
        event6, 
    )
    println("Total Events : ${eventList.size}")
    
    println()
    println("---------------------------------")
    println()
    
    val shortEvents = eventList.filter{
        it.durationInMinutes < 60
    }
    println("You have ${shortEvents.size} short events.")
    
    println()
    println("---------------------------------")
    println()
    
    val eventsByDaypart = eventList.groupBy{
        it.daypart
    }
    
    eventsByDaypart.forEach{ (daypart, event) ->
        println("${daypart}: ${event.size} events")
    }
    
//     val moriningCount = eventsByDaypart[Daypart.MORNING] ?: emptyList()
//     val afternoonCount = eventsByDaypart[Daypart.AFTERNOON] ?: emptyList()
//     val eveningCount = eventsByDaypart[Daypart.EVENING] ?: emptyList()

//     println("Morning: ${moriningCount.size} events")
//     println("Afternoon: ${afternoonCount.size} events")
//     println("Evening: ${eveningCount.size} events")
    
    
    
    println()
    println("---------------------------------")
    println()

    
    println("Last event of the day: ${(eventList.last()).title}")
    
    println()
    println("---------------------------------")
    println()
    
    println("Duration of first event of the day: ${eventList[0].durationOfEvent}")

    
}