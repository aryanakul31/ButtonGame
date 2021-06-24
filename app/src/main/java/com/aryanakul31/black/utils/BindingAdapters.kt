package com.aryanakul31.black.utils

import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.aryanakul31.black.R

object BindingAdapters {

    @BindingAdapter(value = ["customBackground"], requireAll = false)
    @JvmStatic
    fun customBackground(
        appCompatButton: AppCompatButton,
        boolean: Boolean
    ) {
        if (boolean)
            appCompatButton.background =
                ContextCompat.getDrawable(appCompatButton.context, R.color._grey)
        else
            when (appCompatButton.id) {
                R.id.btRed -> appCompatButton.background =
                    ContextCompat.getDrawable(appCompatButton.context, R.color._red)
                R.id.btGreen -> appCompatButton.background =
                    ContextCompat.getDrawable(appCompatButton.context, R.color._green)
                R.id.btYellow -> appCompatButton.background =
                    ContextCompat.getDrawable(appCompatButton.context, R.color._yellow)
                R.id.btBlue -> appCompatButton.background =
                    ContextCompat.getDrawable(appCompatButton.context, R.color._blue)
            }
    }
}