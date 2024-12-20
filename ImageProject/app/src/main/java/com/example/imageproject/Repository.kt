package com.example.imageproject

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL

class ImageRepository(context: Context) {

    private val memoryCache = LruCache<String, Bitmap>(20)
    private val diskCacheDir = File(context.cacheDir, "images")

    init {
        if (!diskCacheDir.exists()) diskCacheDir.mkdirs()
    }

    suspend fun getImage(url: String): Bitmap? {
        memoryCache.get(url)?.let { return it }

        val cachedFile = File(diskCacheDir, url.hashCode().toString())
        if (cachedFile.exists()) {
            return BitmapFactory.decodeFile(cachedFile.absolutePath)?.also {
                memoryCache.put(url, it)
            }
        }

        return loadFromNetwork(url)?.also { bitmap ->
            memoryCache.put(url, bitmap)
            saveToDisk(cachedFile, bitmap)
        }
    }

    private suspend fun loadFromNetwork(url: String): Bitmap? {
        return withContext(Dispatchers.IO) {
            try {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.inputStream.use { BitmapFactory.decodeStream(it) }
            } catch (e: Exception) {
                null
            }
        }
    }

    private fun saveToDisk(file: File, bitmap: Bitmap) {
        FileOutputStream(file).use {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, it)
        }
    }
}
