package com.tpakis.core.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.switchVisibility(shouldShow: Boolean) {
    if (shouldShow) visible() else invisible()
}

fun View.getDimen(@DimenRes dimenRes: Int): Float = context.resources.getDimension(dimenRes)

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun View.resolveColor(@ColorRes colorRes: Int) = context.resolveColor(colorRes)

fun View.resolveDrawable(@DrawableRes drawableRes: Int) = context.resolveDrawable(drawableRes)
