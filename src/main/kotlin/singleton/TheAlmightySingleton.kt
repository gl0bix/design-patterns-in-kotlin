package singleton

/**
 * The Singleton Pattern ensures a class has only one
 * instance, and provides a global point of access to it.
 */
object TheAlmightySingleton {
    fun doSomething(someOrdinaryInput: TheInput) {
        println("The almighty Singleton just did something with $someOrdinaryInput! All hail the one and only Singleton")
    }
}

class TheInput

interface SomeBehavoir {
    fun applyBehavior()
}

class Client: SomeBehavoir {
    override fun applyBehavior() {
        val someInput = TheInput()
        TheAlmightySingleton.doSomething(someOrdinaryInput = someInput)
    } 
}

fun main() {
    val client = Client()
    
    client.applyBehavior()
}
