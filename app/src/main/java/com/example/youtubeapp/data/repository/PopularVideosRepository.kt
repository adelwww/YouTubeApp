package com.example.youtubeapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.youtubeapp.data.models.PopularVideosItem
import com.example.youtubeapp.data.pagingsource.PopularVideoPagingSource
import com.example.youtubeapp.data.remote.apiservices.PopularVideosApiService
import com.example.youtubeapp.data.repository.base.BaseRepository
import javax.inject.Inject

class PopularVideosRepository @Inject constructor(
    private val apiService: PopularVideosApiService
) : BaseRepository() {

    fun fetchPopularVideos() : LiveData<PagingData<PopularVideosItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                PopularVideoPagingSource(apiService)
            }
        ).liveData
    }

}