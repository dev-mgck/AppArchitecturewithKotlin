package dev.mgck.apparchitecturewithkotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dev.mgck.apparchitecturewithkotlin.LOG_TAG
import dev.mgck.apparchitecturewithkotlin.R
import dev.mgck.apparchitecturewithkotlin.util.DiceHelper

class DiceViewModel(app: Application) : AndroidViewModel(app) {

    val headline = MutableLiveData<String>()
    val dice = MutableLiveData<IntArray>()
    private val context = app


    init {
        Log.i(LOG_TAG, "View model created")
        headline.value = context.getString(R.string.welcome)
        dice.value = intArrayOf(6, 6, 6, 6, 6)
    }

    fun rollDice() {
        dice.value = DiceHelper.rollDice()
        headline.value = DiceHelper.evaluateDice(context, dice.value)
    }
}