package kz.q19.data.api.model.response.upload

import com.google.gson.annotations.SerializedName

data class UploadResponse constructor(
    @SerializedName("hash")
    val hash: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String
)