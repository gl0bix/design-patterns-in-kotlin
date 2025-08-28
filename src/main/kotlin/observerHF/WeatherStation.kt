package observerHF

import observerHF.displays.CurrentConditionDisplay
import observerHF.displays.Measurement
import observerHF.displays.Observer
import observerHF.displays.StatisticsDisplay

class WeatherStation(
    val observers: MutableList<Observer> = mutableListOf(),
    val measurements: ArrayDeque<Measurement> = ArrayDeque()
): Subject {
    override fun addObserver(observer: Observer): Boolean = observers.add(observer).also { observer.subject = this }
    
    override fun removeObserver(observer: Observer): Boolean = observers.remove(observer).also { observer.subject = null }
    override fun notifyObservers() = observers.forEach{ it.update() }
    
    fun measurementChanged() {
        measurements.add(
            Measurement(
                temperature = getTemperature(),
                humidity = getHumidity(),
                pressure = getPressure(),
            )
        )
        
        notifyObservers()
    }
    
    private fun getTemperature(): Int = (-30..50).random()
    private fun getHumidity(): Float = (0..100).random() / 100f
    private fun getPressure(): Float = (8700..10840).random() / 10f
}


fun main() {
    val weatherStation= WeatherStation()
    
    val currentConditionDisplay = CurrentConditionDisplay()
    val statisticsDisplay = StatisticsDisplay()
    
    weatherStation.addObserver(currentConditionDisplay)
    weatherStation.addObserver(statisticsDisplay)
    
    repeat(10) {
        weatherStation.measurementChanged()
    }
    
}
