package com.example.cats.feature_cats.data.remote.dto

data class Data(
    val id: String,
    val account_url: String,
    val images: List<Image>?,
    val images_count: Int,
    val title: String,
)