package decorator

/**
 *The Decorator Pattern attaches additional
 * responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to
 * subclassing for extending functionality.
 */
// 
interface Fighter {
    fun fightWith(): String
}

open class MeleeFighter(
    val name: String,
): Fighter {
    override fun fightWith(): String {
        return "fights with:" 
    }
}

abstract class MeleeWeaponDecorator(val fighter: MeleeFighter): MeleeFighter(fighter.name) {
    override fun fightWith(): String {
        return fighter.fightWith()
    }
}

class SwordDecorator(meleeFighter:  MeleeFighter): MeleeWeaponDecorator(meleeFighter) {
    override fun fightWith(): String {
        return super.fightWith() + " Sword"
    }    
}

class SpearDecorator(meleeFighter: MeleeFighter): MeleeWeaponDecorator(meleeFighter) {
    override fun fightWith(): String {
        return super.fightWith() + " Spear"
    }
}

class AxeDecorator(meleeFighter: MeleeFighter): MeleeWeaponDecorator(meleeFighter) {
    override fun fightWith(): String {
        return super.fightWith() + " Axe"
    }
}

fun main() {
    val conan = MeleeFighter(name = "Conan")
    
    val conanWithSword = SwordDecorator(conan)
    val conanWithSwordAndSpear = AxeDecorator(conanWithSword)

    println("${conan.name} ${conan.fightWith()}")
    println("${conanWithSword.name} ${conanWithSword.fightWith()}")
    println("${conanWithSwordAndSpear.name} ${conanWithSwordAndSpear.fightWith()}")
}
