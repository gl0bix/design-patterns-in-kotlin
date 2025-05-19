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
        return "fight with: " 
    }
}

abstract class MeleeWeaponDecorator(val meleeFighter: MeleeFighter): MeleeFighter(meleeFighter.name) {
    override fun fightWith(): String {
        return meleeFighter.fightWith()
    }
}

class SwordDecorator(meleeFighter: MeleeFighter): MeleeWeaponDecorator(meleeFighter) {
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
    val conan: MeleeFighter = MeleeFighter(name = "Conan")
    
    val conanWithSword = SwordDecorator(conan)
    val conanWithSwordAndSpearDecorator = AxeDecorator(conanWithSword)

    println(conan.fightWith())
    println(conanWithSword.fightWith())
    println(conanWithSwordAndSpearDecorator.fightWith())
}
