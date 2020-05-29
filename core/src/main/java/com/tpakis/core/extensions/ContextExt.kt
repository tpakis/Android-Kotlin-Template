package com.tpakis.core.extensions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.resolveColor(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)

fun Context.resolveDrawable(@DrawableRes drawableRes: Int) = ContextCompat.getDrawable(this, drawableRes)
