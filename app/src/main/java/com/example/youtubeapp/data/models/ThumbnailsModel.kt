package com.example.youtubeapp.data.models

import com.google.gson.annotations.SerializedName

data class ThumbnailsModel(

    @SerializedName("medium")
    val medium: ImageMedium
)

data class ImageMedium(
    @SerializedName("url")
    val url: String?
)
