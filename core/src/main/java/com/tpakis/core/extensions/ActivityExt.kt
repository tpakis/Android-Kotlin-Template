package com.tpakis.core.extensions

import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

private val AppCompatActivity.root get() = this.findViewById<View>(android.R.id.content)

fun AppCompatActivity.showMessage(message: String) {
    root?.let {
        Snackbar.make(it, message, Snackbar.LENGTH_LONG).show()
    }
}

fun AppCompatActivity.showMessage(@StringRes messageRes: Int) {
    root?.let {
        Snackbar.make(it, messageRes, Snackbar.LENGTH_LONG).show()
    }
}
