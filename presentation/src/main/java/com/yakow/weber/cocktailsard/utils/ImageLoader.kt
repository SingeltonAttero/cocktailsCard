package com.yakow.weber.cocktailsard.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created on 02.04.19
 * @author YWeber */

object ImageLoader {
    fun loadImage(view: View, url: String, targetImageView: ImageView) {
        Glide.with(view)
            .load(url)
            .into(targetImageView)
    }
}