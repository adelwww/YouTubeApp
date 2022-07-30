package com.example.youtubeapp.data.repository

import com.example.youtubeapp.data.remote.apiservices.PopularVideosApiService
import com.example.youtubeapp.data.repository.base.BaseRepository
import javax.inject.Inject

class PopularVideosRepository @Inject constructor(
    private val apiService: PopularVideosApiService
) : BaseRepository() {

    fun fetchPopularVideos() = doRequest {
        apiService.fetchPopularVideos()
    }
}