package com.example.youtubeapp.di

import com.example.youtubeapp.data.remote.retrofite.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providePopularVideosApiService(
        networkClient: NetworkClient
    ) = networkClient.providePopularVideosApiService()

}