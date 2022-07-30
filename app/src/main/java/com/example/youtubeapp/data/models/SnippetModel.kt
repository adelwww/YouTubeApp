package com.example.youtubeapp.data.models

import com.google.gson.annotations.SerializedName

data class SnippetModel(

    @SerializedName("publishedAt")
    val publishedAt: String,

    @SerializedName("channelId")
    val channelId: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("thumbnails")
    val thumbnails: ThumbnailsModel,

    @SerializedName("channelTitle")
    val channelTitle: String,

    @SerializedName("categoryId")
    val categoryId: String?
)