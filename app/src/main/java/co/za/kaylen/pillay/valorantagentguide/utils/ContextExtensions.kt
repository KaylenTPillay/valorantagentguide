package co.za.kaylen.pillay.valorantagentguide.utils

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics

fun Context.getDisplayDimension(): Point {
    val displayMetric = DisplayMetrics()
    if (this is Activity) {
        windowManager.defaultDisplay.getMetrics(displayMetric)
    }

    return Point(displayMetric.widthPixels, displayMetric.heightPixels)
}