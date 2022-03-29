package kz.q19.data.api.model.request.upload

import com.google.gson.annotations.SerializedName

data class UploadParams constructor(
    val type: Type
) {

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