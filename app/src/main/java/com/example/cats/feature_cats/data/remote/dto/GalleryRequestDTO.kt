package com.example.cats.feature_cats.data.remote.dto

data class GalleryRequestDTO(
    val `data`: List<Data>,
    val status: Int,
    val success: Boolean
)