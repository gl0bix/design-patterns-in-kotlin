package factory

interface Tea {
    val name: String
    fun steep()
}

private class GreenTea(override val name: String) : Tea {
    override fun steep() {
        println("Steep at 60°C")
    }
}

private class BlackTea(override val name: String) : Tea {
    override fun steep() {
        println("Steep at 100°C")
    }
}

abstract class TeaFarm(
    val name: String,
    val country: String
) {
    abstract val teas: MutableList<Tea>

    abstract fun produceTea(teaName: String): Tea
    open fun serveSample(tea: Tea) {
        if (teas.contains(tea)) {
            tea.steep()
            println("Sample of ${tea.name} served from $name tea farm in $country:")
            println("Serving hot ${tea.name}")
        } else {
            println("${tea.name} is not produced here")
        }
    }
}

class GreenTeaFarm(name: String, country: String) : TeaFarm(name, country) {
    override val teas: MutableList<Tea> = mutableListOf()
    override fun produceTea(teaName: String): Tea = GreenTea(name = teaName).also { tea -> teas.add(tea) }
}

class BlackTeaFarm(name: String, country: String) : TeaFarm(name, country) {
    override val teas: MutableList<Tea> = mutableListOf()
    override fun produceTea(teaName: String): Tea = BlackTea(name = teaName).also { tea -> teas.add(tea) }
}

fun main() {
    val gtf = GreenTeaFarm(
        name = "Steamy heaven",
        country = "China"
    )

    val btf = BlackTeaFarm(
        name = "Home of Assam",
        country = "India"
    )

    gtf.produceTea("LongJing")
    btf.produceTea("Assam")

    gtf.teas.forEach { gtf.serveSample(it) }
    btf.teas.forEach { gtf.serveSample(it) }
}
