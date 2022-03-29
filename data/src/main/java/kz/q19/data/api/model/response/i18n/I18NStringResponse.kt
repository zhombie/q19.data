package kz.q19.data.api.model.response.i18n

import com.google.gson.annotations.SerializedName

data class I18NStringResponse constructor(
    @SerializedName("kk")
    val kk: String?,

    @SerializedName("kz")
    val kz: String?,

    @SerializedName("ru")
    val ru: String?,

    @SerializedName("en")
    val en: String?
)