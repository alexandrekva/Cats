package com.example.cats.feature_cats.data.remote.dto

data class Image(
    val description: String,
    val id: String,
    val link: String,
    val title: String?,
    val type: String,
)