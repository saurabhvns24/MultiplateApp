package com.example.imageproject

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val repository: ImageRepository) : ViewModel() {

    private val _images = MutableLiveData<List<String>>()
    val images: LiveData<List<String>> = _images

    fun loadImages(json: String) {
        val imageList = Gson().fromJson(json, Array<ImageData>::class.java).map {
            "${it.thumbnail.domain}/${it.thumbnail.basePath}/0/${it.thumbnail.key}"
        }
        _images.value = imageList
//        prefetchImages(context, imageList)
    }

    fun getBitmap(url: String): LiveData<Bitmap?> {
        val result = MutableLiveData<Bitmap?>()
        viewModelScope.launch {
            result.postValue(repository.getImage(url))
        }
        return result
    }
}
