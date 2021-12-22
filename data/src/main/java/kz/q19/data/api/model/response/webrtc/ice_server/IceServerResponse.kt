package kz.q19.data.api.model.response.webrtc.ice_server

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class IceServerResponse constructor(
    @SerializedName("url")
    val url: String?,

    @SerializedName("urls")
    val urls: String?,

    @SerializedName("username")
    val username: String? = null,

    @SerializedName("credential")
    val credential: String? = null
)