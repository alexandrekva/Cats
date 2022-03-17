package com.example.cats.feature_cats.domain.use_cases

import com.example.cats.core.util.Resource
import com.example.cats.feature_cats.data.remote.dto.GalleryRequestDTO
import com.example.cats.feature_cats.domain.repository.CatImagesRepository
import kotlinx.coroutines.flow.Flow

class GetCatImages(private val catImagesRepository: CatImagesRepository) {

    operator fun invoke(): Flow<Resource<GalleryRequestDTO>> {
        return catImagesRepository.getCatImages()
    }
}