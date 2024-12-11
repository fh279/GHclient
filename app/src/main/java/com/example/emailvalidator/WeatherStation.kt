package com.example.emailvalidator

import android.os.Handler
import java.util.*

class WeatherStation {
    private val people: MutableList<ManBehavoiur>  = LinkedList()
    var degrees = 0

    fun addMan(manBehavoiur: ManBehavoiur) {
        people.add(manBehavoiur)
    }

    fun removeMan(manBehavoiur: ManBehavoiur) {
        people.remove(manBehavoiur)
    }

    fun updateWeather() {
        degrees = Random().nextInt(400)
        people.forEach {
            it.getCloth(degrees = degrees)
        }
        val handler = Handler()
        handler.postDelayed({updateWeather()}, 2000)
    }



}



// для того что бы наблюдать за событиями, надо наследовать какой-то интерфейс.