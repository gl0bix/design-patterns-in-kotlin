package observerHF.displays

import observerHF.WeatherStation

class CurrentConditionDisplay(
    override var subject: WeatherStation? = null
) : Observer, Display {
    override fun update() {
        display() 
    }
    
    override fun display() {
        subject?.measurements?.first()?.run {
            println(this.temperature)
            println(this.humidity)
            println(this.pressure)
        }
    }
}
