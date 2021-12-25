package com.example.presentation.app

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Base64
import android.util.Patterns
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.presentation.R
import timber.log.Timber

@BindingAdapter(value = ["loadImage", "imageLoader"], requireAll = false)
fun bindLoadImage(imageView: ImageView, obj: Any?, progressBar: ProgressBar?) {
    obj?.let {
        when (it) {
            is Int -> imageView.setImageResource(it)
            is Drawable -> imageView.setImageDrawable(it)
            is Bitmap -> imageView.setImageBitmap(it)
            is Uri -> imageView.setImageURI(it)
            is String -> when {
                it.isValidUrl() -> imageView.loadImageFromURL(it, progressBar)
                it.length >= 200 -> {
                    Timber.e("image is encoded")
                    val decodedString: ByteArray = Base64.decode(obj.toString(), Base64.DEFAULT)
                    Glide.with(imageView.context).asBitmap()
                        .load(decodedString)
                        .error(R.drawable.ic_broken_image)
                        .into(imageView)
                }
                else -> {
                    Timber.e("image string isn't valid")
                    imageView.loadImageFromURL("")
                }
            }
            else -> {
                Timber.e("image url isn't valid")
                imageView.loadImageFromURL("")
            }
        }
    } ?: imageView.loadImageFromURL("")
}

fun String.isValidUrl(): Boolean {
    return try {
        URLUtil.isValidUrl(this) && Patterns.WEB_URL.matcher(this).matches()
    } catch (e: Exception) {
        Timber.e(e)
        false
    }
}


fun ImageView.loadImageFromURL(url: String, progressBar: ProgressBar? = null) {
    Glide.with(this).load(url)
        .error(R.drawable.ic_broken_image)
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                Timber.e("$e")
                setImageResource(R.drawable.ic_broken_image)
//                setPadding(200, 50, 200, 50)
                return true
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                setImageDrawable(resource)
                return true
            }

        })
        .into(this)
}
