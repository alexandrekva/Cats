package com.example.cats.feature_cats.data.remote

import com.example.cats.feature_cats.data.remote.dto.GalleryRequestDTO
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImgurApi {

    @Headers("Authorization: Client-ID $CLIENT_ID")
    @GET("/3/gallery/search/?q=cats")
    suspend fun getCatImages(): GalleryRequestDTO

    companion object ApiKeys{
        const val BASE_URL = "https://api.imgur.com/"
        const val CLIENT_ID = "1ceddedc03a5d71"
    }
}
