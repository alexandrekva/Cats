package com.example.cats.feature_cats.domain.repository

import com.example.cats.core.util.Resource
import com.example.cats.feature_cats.data.remote.dto.GalleryRequestDTO
import kotlinx.coroutines.flow.Flow

interface CatImagesRepository {
    fun getCatImages(): Flow<Resource<GalleryRequestDTO>>
}