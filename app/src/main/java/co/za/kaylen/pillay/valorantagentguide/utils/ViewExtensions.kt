package co.za.kaylen.pillay.valorantagentguide.utils

import android.view.View
import android.widget.ImageView
import co.za.kaylen.pillay.valorantagentguide.utils.imageload.ImageLoader
import co.za.kaylen.pillay.valorantagentguide.utils.imageload.impl.GlideImageLoaderImpl

fun View.setVisibility(show: Boolean, hiddenType: Int = View.GONE) {
    visibility = if (show) {
        View.VISIBLE
    } else {
        hiddenType
    }
}

fun ImageView.load(url: String, onSuccessfulLoad: () -> Unit = {}, onFailedLoad: () -> Unit = {}) {
    val imageLoader: ImageLoader = GlideImageLoaderImpl()
    imageLoader.load(
        imageView = this,
        url = url,
        onSuccessfulLoad = onSuccessfulLoad,
        onFailedLoad = onFailedLoad
    )
}