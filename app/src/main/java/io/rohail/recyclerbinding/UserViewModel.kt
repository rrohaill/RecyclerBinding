package io.rohail.recyclerbinding

import android.os.Handler
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlin.random.Random
import java.lang.Runnable as Runnable1

class UserViewModel : BaseObservable() {

    @get:Bindable
    var userIds: List<Long> = emptyList()
        private set(value) {
            field = value
            notifyPropertyChanged(BR.userIds)
        }

    private val updateInterval = 1000L
    private val updateHandler = Handler()
    private val random = Random

    private var updateRunnable: Runnable1 = object : Runnable1 {
        override fun run() {
            updateList()
            updateHandler.postDelayed(this, updateInterval)
        }
    }

    private fun updateList() {
        userIds = List(30) {
            random.nextLong()
        }
    }

    fun startUpdates() {
        updateHandler.postDelayed(updateRunnable, updateInterval)
    }

    fun stopUpdates() {
        updateHandler.removeCallbacks(updateRunnable)
    }
}