package observer

interface Subscriber<in T> {
    fun update(subscribable: T)
}

class MagazineSubscriber (val name: String): Subscriber<Magazine> {
    override fun update(subscribable: Magazine) = println("Yeah! $name just got new ${subscribable.name}") 
}

