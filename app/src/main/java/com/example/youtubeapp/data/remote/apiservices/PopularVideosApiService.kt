package com.example.youtubeapp.data.remote.apiservices

import com.example.youtubeapp.data.models.PopularVideosItem
import com.example.youtubeapp.data.models.PopularVideosModelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularVideosApiService {

    @GET("videos")
    suspend fun fetchPopularVideos(
        @Query("pageToken") pageToken: String,
        @Query("part") part: String = "snippet,contentDetails,statistics",
        @Query("chart") chart: String = "mostPopular",
        @Query("key") key: String = "AIzaSyDtoMVBhzMG0Pthdd1l8ue5hLhh_ktsjDs"
    ): PopularVideosModelResponse<PopularVideosItem>
}