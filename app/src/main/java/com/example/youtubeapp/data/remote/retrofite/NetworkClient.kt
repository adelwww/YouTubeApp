package com.example.youtubeapp.data.remote.retrofite

import com.example.youtubeapp.data.remote.apiservices.PopularVideosApiService
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun providePopularVideosApiService(): PopularVideosApiService = provideRetrofit.create()

    inline fun <reified T : Any> Retrofit.create(): T {
        return create(T::class.java)
    }
}