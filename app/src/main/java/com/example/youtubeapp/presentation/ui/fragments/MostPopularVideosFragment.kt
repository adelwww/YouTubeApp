package com.example.youtubeapp.presentation.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtubeapp.R
import com.example.youtubeapp.base.BaseFragment
import com.example.youtubeapp.databinding.FragmentMostPopularVideosBinding
import com.example.youtubeapp.presentation.ui.adapters.PopularVideosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostPopularVideosFragment :
    BaseFragment<PopularVideoViewModel, FragmentMostPopularVideosBinding>(
        R.layout.fragment_most_popular_videos
    ) {

    override val viewModel: PopularVideoViewModel by viewModels()
    override val binding by viewBinding(FragmentMostPopularVideosBinding::bind)
    private val popularVideosAdapter = PopularVideosAdapter()

    override fun initialize() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recycler) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = popularVideosAdapter
    }

    override fun setupSubscribe() {
        subscribeToPopularVideos()
    }

    private fun subscribeToPopularVideos() {
        viewModel.fetchPopularVideos().observe(viewLifecycleOwner) {
            lifecycleScope.launchWhenStarted {
                popularVideosAdapter.submitData(it)
            }
        }
    }
}