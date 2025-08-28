package observerHF.displays

import observerHF.WeatherStation

class StatisticsDisplay(
    override var subject: WeatherStation? = null
) : Observer, Display {
    
    override fun update() {
        display()
    }
    
    override fun display() {
        val temperatures = subject?.measurements?.map { it.temperature }
        val humidities = subject?.measurements?.map { it.humidity }
        val pressures = subject?.measurements?.map { it.pressure }
        
        temperatures?.let {
            println("Avg temperature: ${it.average()} Max: ${it.max()} Min: ${it.min()}")
        }
        humidities?.let {
            println("Avg humidity: ${it.average()} Max: ${it.max()} Min: ${it.min()}")
        }
        pressures?.let {
            println("Avg pressure: ${it.average()} Max: ${it.max()} Min: ${it.min()}")
        }
        
    }
}
