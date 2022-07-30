package com.example.youtubeapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapp.data.models.PopularVideosItem
import com.example.youtubeapp.databinding.ItemVideosBinding
import com.example.youtubeapp.extensions.loadImage

class PopularVideosAdapter
    : PagingDataAdapter<PopularVideosItem, PopularVideosAdapter.PopularVideoViewHolder>(
    PopularVideosDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularVideoViewHolder {
        return PopularVideoViewHolder(
            ItemVideosBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularVideoViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class PopularVideoViewHolder(
        private val binding: ItemVideosBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: PopularVideosItem) = with(binding) {
            tvNameVideos.text = model.snippet.title
            model.snippet.thumbnails.medium.url?.let { imVideo.loadImage(it) }
        }
    }

}

object PopularVideosDiffCallBack : DiffUtil.ItemCallback<PopularVideosItem>() {
    override fun areItemsTheSame(
        oldItem: PopularVideosItem,
        newItem: PopularVideosItem
    )
            : Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PopularVideosItem,
        newItem: PopularVideosItem
    ): Boolean {
        return oldItem == newItem
    }
}