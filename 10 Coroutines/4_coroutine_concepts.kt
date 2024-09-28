/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlinx.coroutines.*
import kotlin.system.*

    /**
     * Note 01
     * ------------------------
     *  Coroutine concepts
     * ------------------------
     * 
     * Coroutines follow the principle of structured concurrency, 
     * which enforces you to answer these questions when you use coroutines 
     * in your code using a combination of mechanisms.
     * -------------------------------------------------------------------------
     * 
     * Job
     * ---
     * When you launch a coroutine with the launch() function, 
     * it returns an instance of Job. The Job holds a handle, or reference, 
     * to the coroutine, so you can manage its lifecycle.
     * 
     * Note: The Deferred object that is returned from a coroutine started with the async() 
     * function is a Job as well, and it holds the future result of the coroutine.
     * 
     */

    /**
     * Note 02
     * ------------------------
     *  CoroutineScope
     * ------------------------
     * 
     * Coroutines are typically launched into a CoroutineScope. 
     * This ensures that we don't have coroutines that are unmanaged and get lost, 
     * which could waste resources.
     * 
     * launch() and async() are extension functions on CoroutineScope. 
     * 
     * Android provides coroutine scope support in entities that have a 
     * well-defined lifecycle, such as Activity 
     ** (lifecycleScope) and ViewModel (viewModelScope). 
     * Coroutines that are started within these scopes will adhere 
     * to the lifecycle of the corresponding entity, such as Activity or ViewModel.
     * -------------------------------------------------------------------------
     * 
     */


    /**
     * Note 02
     * ------------------------
     *  CoroutineContext
     * ------------------------
     * 
     * Ex contained in a context:
     * 
     * name - name of the coroutine to uniquely identify it
     * job - controls the lifecycle of the coroutine
     * dispatcher - dispatches the work to the appropriate thread
     * exception handler - handles exceptions thrown by the code executed in the coroutine
     * -------------------------------------------------------------------------
     * 
     * ------------------------
     *  Dispatcher
     * ------------------------
     * Coroutines use dispatchers to determine the thread to use for its execution. 
     * A thread can be started, does some work (executes some code), 
     * and then terminates when there's no more work to be done.
     * 
     * built-in dispatchers that Kotlin provides:
     * 
     * Dispatchers.Main: 
     * Use this dispatcher to run a coroutine on the main Android thread. 
     * This dispatcher is used primarily for handling UI updates and interactions, 
     * and performing quick work.
     * 
     * Dispatchers.IO: 
     * This dispatcher is optimized to perform disk or network I/O outside of the main thread. 
     * For example, read from or write to files, and execute any network operations.
     * 
     * Dispatchers.Default: 
     * This is a default dispatcher used when calling launch() and async(), 
     * when no dispatcher is specified in their context. You can use this dispatcher 
     * to perform computationally-intensive work outside of the main thread. 
     * For example, processing a bitmap image file.
     * 
     * Note: There's also Executor.asCoroutineDispatcher() and Handler.asCoroutineDispatcher() 
     * extensions, if you need to make a CoroutineDispatcher from a Handler or Executor 
     * that you already have available.
     */
    
fun main() {
    
    runBlocking {
        
        println("${Thread.currentThread().name} - runBlocking function")
        
        launch {
            
            println("${Thread.currentThread().name} - launch function")
            
            withContext(Dispatchers.Default) {
                
                println("${Thread.currentThread().name} - withContext function")
                
                delay(1000)
                
                println("10 results found.")
            }
            
            println("${Thread.currentThread().name} - end of launch function")
        }
        
        println("Loading...")
    }
    
    /**
     * OUTPUT:
     * -------
     * main @coroutine#1 - runBlocking function
     * Loading...
     * main @coroutine#2 - launch function
     * DefaultDispatcher-worker-2 @coroutine#2 - withContext function
     * 10 results found.
     * main @coroutine#2 - end of launch function
     * 
     */
}


  
