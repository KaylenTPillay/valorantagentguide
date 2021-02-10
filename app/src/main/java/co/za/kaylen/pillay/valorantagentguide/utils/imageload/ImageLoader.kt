package co.za.kaylen.pillay.valorantagentguide.utils.imageload

import android.widget.ImageView

interface ImageLoader {
    fun load(
        imageView: ImageView,
        url: String,
        onSuccessfulLoad: () -> Unit = {},
        onFailedLoad: () -> Unit = {}
    )
}