package strategy

/**
 * The Strategy Pattern defines a family of algorithms,
 * encapsulates each one, and makes them interchangeable.
 * Strategy lets the algorithm vary independently from
 * clients that use it.
 */

interface Commute {
    fun route(start: Int, end: Int)
}

class BikeCommute: Commute{
    override fun route(start: Int, end: Int) {
        TODO("Calculate route for bike")
    }
}

class CarCommute: Commute {
    override fun route(start: Int, end: Int) {
        TODO("Calculate route for car")
    }
}

class TrainCommute: Commute {
    override fun route(start: Int, end: Int) {
        TODO("Calculate route for train")
    }
}

class Router(
    val start: Int,
    val end: Int,
) {
    fun route(commute: Commute) {
        commute.route(start, end)
    }
}

fun main() {
    val bikeCommute = BikeCommute()
    val carCommute = CarCommute()
    val trainCommute = TrainCommute()

    /**
     * Router can now be initialized with a given start end endpoint and 
     * calculate the route based on the commute parameter.
     * New Commutes can be added, like plain or ship without interfering with present implementations 
     */
    val myRouter = Router(1, 6)
    
    myRouter.route(bikeCommute)
    myRouter.route(carCommute)
    myRouter.route(trainCommute)
}
