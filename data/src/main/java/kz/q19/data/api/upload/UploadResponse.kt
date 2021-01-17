package kz.q19.data.api.upload

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UploadResponse constructor(
    @SerializedName("hash")
    val hash: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String
)