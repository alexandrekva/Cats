package com.example.cats.feature_cats.di

import com.example.cats.feature_cats.data.remote.ImgurApi
import com.example.cats.feature_cats.data.repository.ImgurApiImpl
import com.example.cats.feature_cats.domain.repository.CatImagesRepository
import com.example.cats.feature_cats.domain.use_cases.GetCatImages
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CatImagesModule {

    @Provides
    @Singleton
    fun provideGetCatImagesUseCase(repository: CatImagesRepository): GetCatImages {
        return GetCatImages(repository)
    }

    @Provides
    @Singleton
    fun provideImgurRepository(api: ImgurApi
    ): CatImagesRepository {
        return ImgurApiImpl(api)
    }

    @Provides
    @Singleton
    fun provideImgurApi(): ImgurApi {
        return Retrofit.Builder()
            .baseUrl(ImgurApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImgurApi::class.java)
    }
}