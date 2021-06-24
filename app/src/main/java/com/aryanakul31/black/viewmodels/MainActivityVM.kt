package com.aryanakul31.black.viewmodels

import android.app.AlertDialog
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.aryanakul31.black.R
import com.aryanakul31.black.views.MainActivity.Companion.context
import kotlin.random.Random


class MainActivityVM : ViewModel() {

    var score: ObservableField<Int> = ObservableField(0)

    /** Tracks Score of the user*/
    var greyButtonPos: ObservableField<Buttons> = ObservableField(Buttons.NONE)

    /** Tracks current location of Grey Button*/

    private var pointGiven = false

    init {
        timer()
    }

    /**
     * Handles Click on Buttons
     **/
    fun onClick(view: View) {
        when (view.id) {
            R.id.btRed -> choiceAction(greyButtonPos.get() == Buttons.RED)

            R.id.btBlue -> choiceAction(greyButtonPos.get() == Buttons.BLUE)

            R.id.btYellow -> choiceAction(greyButtonPos.get() == Buttons.YELLOW)

            R.id.btGreen -> choiceAction(greyButtonPos.get() == Buttons.GREEN)
        }
    }

    /**
     * Handles consequences of the choice made
     **/
    private fun choiceAction(correctClick: Boolean) {
        if (correctClick && !pointGiven) {
            pointGiven = true
            score.set((score.get() ?: 0) + 1)
        } else if (!correctClick)
            gameFinishedAlert()
    }


    /**
     * Displays Game Over Dialog
     **/
    private fun gameFinishedAlert() {
        val alertDialog = AlertDialog.Builder(context.get())
        alertDialog.create()
        alertDialog.setTitle("Game Over. Your score is: ${score.get()}")
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton(
            "Restart"
        ) { dialog, _ ->
            score.set(0)
            greyButtonPos.set(Buttons.NONE)
            dialog.dismiss()
        }

        alertDialog.show()
    }


    /**
     * Changes Grey Button After 1 sec
     **/
    private fun timer() {
        Handler(Looper.getMainLooper()).postDelayed({
            when (Random.nextInt(1, 5)) {
                1 -> greyButtonPos.set(Buttons.RED)
                2 -> greyButtonPos.set(Buttons.BLUE)
                3 -> greyButtonPos.set(Buttons.YELLOW)
                4 -> greyButtonPos.set(Buttons.GREEN)
            }
            pointGiven = false
            timer()
        }, 1000)
    }
}


enum class Buttons {
    NONE,
    RED,
    BLUE,
    YELLOW,
    GREEN
}