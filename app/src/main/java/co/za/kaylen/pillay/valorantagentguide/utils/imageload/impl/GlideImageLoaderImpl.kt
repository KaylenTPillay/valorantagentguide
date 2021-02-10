package co.za.kaylen.pillay.valorantagentguide.utils.imageload.impl

import android.graphics.drawable.Drawable
import android.widget.ImageView
import co.za.kaylen.pillay.valorantagentguide.utils.imageload.ImageLoader
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class GlideImageLoaderImpl : ImageLoader {

    override fun load(
        imageView: ImageView,
        url: String,
        onSuccessfulLoad: () -> Unit,
        onFailedLoad: () -> Unit
    ) {
        Glide.with(imageView.context)
            .load(url)
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    onFailedLoad.invoke()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    onSuccessfulLoad.invoke()
                    return false
                }
            })
            .into(imageView)
    }
}