package kz.q19.data.api.model.request.upload

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UploadParams constructor(
    val type: Type
) {

    @Keep
    enum class Type constructor(val value: String) {
        @SerializedName("image")
        IMAGE("image"),

        @SerializedName("video")
        VIDEO("video"),

        @SerializedName("audio")
        AUDIO("audio"),

        @SerializedName("document")
        DOCUMENT("document"),

        @SerializedName("file")
        FILE("file")
    }

}