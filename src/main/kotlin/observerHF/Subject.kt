package observerHF

import observerHF.displays.Observer

interface Subject {
    fun addObserver(observer: Observer): Boolean
    fun removeObserver(observer: Observer): Boolean
    fun notifyObservers()
}
