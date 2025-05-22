package decorator

/**
 *The Decorator Pattern attaches additional
 * responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to
 * subclassing for extending functionality.
 */
// 
interface Fighter {
    val name: String 
    fun fightWith(): String
}

class MeleeFighter(override val name: String): Fighter {
    override fun fightWith(): String {
        return "fights with:" 
    }
}

class SwordDecorator(
    private val meleeFighter : Fighter, 
) : Fighter by meleeFighter {
    
    override fun fightWith(): String {
        return meleeFighter.fightWith() + " Sword"    
    }
}

class SpearDecorator(
    private val meleeFighter : Fighter,
) : Fighter by meleeFighter {
    
    override fun fightWith(): String {
        return meleeFighter.fightWith() + " Spear" 
    }
}

class AxeDecorator(
    private val meleeFighter : Fighter,
) : Fighter by meleeFighter {

    override fun fightWith(): String {
        return meleeFighter.fightWith() + " Axe" 
    }
}

fun main() {
    val conan = MeleeFighter(name = "Conan")
    val conanWithSword = SwordDecorator(conan)
    val conanWithSwordAndAxe = AxeDecorator(conanWithSword)
    val conanWithSwordAxeAndSpear = SpearDecorator(conanWithSwordAndAxe)
    
    println("${conan.name} ${conan.fightWith()}")
    println("${conanWithSword.name} ${conanWithSword.fightWith()}")
    println("${conanWithSwordAndAxe.name} ${conanWithSwordAndAxe.fightWith()}")
    println("${conanWithSwordAxeAndSpear.name} ${conanWithSwordAxeAndSpear.fightWith()}")
}
