package observer


/**
 * The Observer Pattern defines a one-to-many
 * dependency between objects so that when one
 * object changes state, all of its dependents are
 * notified and updated automatically.
 */
interface Magazine {
    val name: String

    fun shipMagazine()
    fun addSubscriber(magazineSubscriber: MagazineSubscriber, subscription: Subscription)
    fun removeSubscriber(magazineSubscriber: MagazineSubscriber)
    fun chargeSubscribers()
}

class AmazingNews(
    override val name: String,
    val subscribers: MutableList<Pair<MagazineSubscriber, Subscription>>
) : Magazine {
    override fun addSubscriber(magazineSubscriber: MagazineSubscriber, subscription: Subscription) {
        if (subscribers.add(Pair(magazineSubscriber, subscription))) {
            println("${magazineSubscriber.name} added!")
        }
    }

    override fun removeSubscriber(magazineSubscriber: MagazineSubscriber) {
        if(subscribers.removeIf { (subscriberToRemove, _) -> subscriberToRemove == magazineSubscriber }) {
            println("${magazineSubscriber.name} removed!")
        }
    }

    override fun chargeSubscribers() = subscribers.forEach { (_, subscription) -> subscription.charge() }

    override fun shipMagazine() {
        println("Shipping AmazingNews")
        subscribers.forEach { (it, _) -> it.update(this) }
    }
}

interface Subscription {
    fun charge()
}

object MonthlySubscription : Subscription {
    override fun charge() {
        println("Charge monthly subscribers if applicable")
    }
}

object AnnualSubscription : Subscription {
    override fun charge() {
        println("Charge annual subscribers if applicable")
    }
}


fun main() {
    val aMagazineSubscriber = MagazineSubscriber(
        name = "Freddy Mercury",
    )

    val anotherMagazineSubscriber = MagazineSubscriber(
        name = "Brian May",
    )

    val magazine = AmazingNews(
        name = "AmazingNews",
        subscribers = mutableListOf()
    )
    
    magazine.addSubscriber(aMagazineSubscriber, MonthlySubscription)
    magazine.addSubscriber(anotherMagazineSubscriber, AnnualSubscription)
    magazine.chargeSubscribers()
    magazine.shipMagazine()
    magazine.removeSubscriber(aMagazineSubscriber)
}
