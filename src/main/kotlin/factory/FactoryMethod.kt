package factory


abstract class Tea{
    abstract val name: String
    abstract val variant: String
    abstract val temp: Int
}

data class GreenTea(
    override val name : String,
    override val variant: String, 
    override val temp: Int
): Tea()
data class BlackTea(
    override val name : String,
    override val variant: String, 
    override val temp: Int
): Tea()



interface TeaHouse { 
    
    fun steamTea(name: String): Tea

    fun serveTea(name: String) {
        val tea = steamTea(name)
        
        println("Served ${tea.name} of the ${tea.variant} variant.")
    }
}

class GreenTeaSteamer(): TeaHouse {
    override fun steamTea(name: String): Tea {
        return GreenTea(
            name = name,
            variant = "Dragonwell",
            temp = 70,
        ) 
    }
}

class BlackTeaSteamer(): TeaHouse {
    override fun steamTea(name: String): Tea {
        return BlackTea(
            name = name,
            variant = "Assam",
            temp = 70,
        )
    }
}

fun main() {
    val greenTeaSteamer = GreenTeaSteamer()
    val blackTeaSteamer = BlackTeaSteamer()
    
    greenTeaSteamer.serveTea("Green tea of the week")
    blackTeaSteamer.serveTea("Black tea of the week")
    
}
