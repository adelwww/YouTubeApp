package com.example.youtubeapp.data.models

import com.google.gson.annotations.SerializedName

data class PopularVideosItem(

    @SerializedName("kind")
    val kind: String,

    @SerializedName("etag")
    val etag: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("snippet")
    val snippet: SnippetModel
)