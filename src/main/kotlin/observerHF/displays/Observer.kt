package observerHF.displays

import observerHF.WeatherStation

interface Observer {
    var subject: WeatherStation?
    fun update()
}
