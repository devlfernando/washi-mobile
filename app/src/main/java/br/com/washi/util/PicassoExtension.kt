package br.com.washi.util

import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

fun Picasso.loadImageFromNetwork(path: String, imageView: ImageView) {
    Picasso.get().load(path)
        .memoryPolicy(MemoryPolicy.NO_CACHE)
        .networkPolicy(NetworkPolicy.NO_CACHE)
        .into(imageView)
}

fun Picasso.loadImageFromMemory(path: String, callback: Callback) {
    Picasso
        .get()
        .load(path)
        .fetch(callback)
}