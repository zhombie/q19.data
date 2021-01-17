package kz.q19.data.api.i18n

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class I18NStringResponse constructor(
    @SerializedName("kk")
    val kk: String? = null,

    @SerializedName("kz")
    val kz: String? = null,

    @SerializedName("ru")
    val ru: String? = null,

    @SerializedName("en")
    val en: String? = null
)