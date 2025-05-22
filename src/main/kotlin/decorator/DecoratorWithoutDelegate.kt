
package decorator

/**
 *The Decorator Pattern attaches additional
 * responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to
 * subclassing for extending functionality.
 */
// 
interface OldFighter {
    val name: String
    fun fightWith(): String
}

class OldMeleeFighter(override val name: String): OldFighter {
    override fun fightWith(): String {
        return "fights with:"
    }
}

// this can be removed by Kotlins delegation pattern as seen in Decorator.kt
abstract class OldMeleeWeaponDecorator(protected val meleeFighter: OldFighter): OldFighter

class OldSwordDecorator(
    meleeFighter : OldFighter,
    override val name: String = meleeFighter.name
) : OldMeleeWeaponDecorator(meleeFighter) {

    override fun fightWith(): String {
        return meleeFighter.fightWith() + " Sword"
    }
}

class OldSpearDecorator(
    meleeFighter : OldFighter,
    override val name: String = meleeFighter.name
) : OldMeleeWeaponDecorator(meleeFighter) {

    override fun fightWith(): String {
        return meleeFighter.fightWith() + " Spear"
    }
}

class OldAxeDecorator(
    meleeFighter : OldFighter,
    override val name: String = meleeFighter.name
) : OldMeleeWeaponDecorator(meleeFighter) {

    override fun fightWith(): String {
        return meleeFighter.fightWith() + " Axe"
    }
}

fun main() {
    val conan = OldMeleeFighter(name = "Conan")
    val conanWithSword = OldSwordDecorator(conan)
    val conanWithSwordAndAxe = OldAxeDecorator(conanWithSword)
    val conanWithSwordAxeAndSpear = OldSpearDecorator(conanWithSwordAndAxe)

    println("${conan.name} ${conan.fightWith()}")
    println("${conanWithSword.name} ${conanWithSword.fightWith()}")
    println("${conanWithSwordAndAxe.name} ${conanWithSwordAndAxe.fightWith()}")
    println("${conanWithSwordAxeAndSpear.name} ${conanWithSwordAxeAndSpear.fightWith()}")
}
