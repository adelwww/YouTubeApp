package com.example.youtubeapp.data.models

import com.google.gson.annotations.SerializedName

data class PopularVideosModelResponse<T>(

    @SerializedName("kind")
    val kind: String,

    @SerializedName("etag")
    val etag: String,

    @SerializedName("nextPageToken")
    val nextPageToken: String?,

    @SerializedName("prefPageToken")
    val prefPageToken: String,

    @SerializedName("items")
    val items: List<T>
)