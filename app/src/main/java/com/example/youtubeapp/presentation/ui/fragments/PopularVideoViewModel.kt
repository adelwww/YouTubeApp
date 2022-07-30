package com.example.youtubeapp.presentation.ui.fragments

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.youtubeapp.base.BaseViewModel
import com.example.youtubeapp.data.repository.PopularVideosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularVideoViewModel @Inject constructor(
    private val repository: PopularVideosRepository
) : BaseViewModel() {

    fun fetchPopularVideos() = repository.fetchPopularVideos().cachedIn(viewModelScope)
}