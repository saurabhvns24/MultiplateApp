package com.example.imageproject

data class ImageData(
    val id: String,
    val thumbnail: Thumbnail
)

data class Thumbnail(
    val domain: String,
    val basePath: String,
    val key: String
)
