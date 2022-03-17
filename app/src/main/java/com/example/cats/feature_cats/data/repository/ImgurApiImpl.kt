package com.example.cats.feature_cats.data.repository

import com.example.cats.core.util.Resource
import com.example.cats.feature_cats.data.remote.ImgurApi
import com.example.cats.feature_cats.data.remote.dto.GalleryRequestDTO
import com.example.cats.feature_cats.domain.repository.CatImagesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ImgurApiImpl(private val api: ImgurApi): CatImagesRepository {


    override fun getCatImages(): Flow<Resource<GalleryRequestDTO>> = flow {
        emit(Resource.Loading())

        var galleryRequestDTO: GalleryRequestDTO? = null

        try {
            galleryRequestDTO = api.getCatImages()
            emit(Resource.Success(galleryRequestDTO))
        } catch (e: HttpException) {
            emit(Resource.Error(data = galleryRequestDTO, message = "Algo deu errado: ${e.message}"))
        } catch (e: IOException) {
            emit(Resource.Error(data = galleryRequestDTO, message = "Algo deu errado: ${e.message}"))
        }

    }
}