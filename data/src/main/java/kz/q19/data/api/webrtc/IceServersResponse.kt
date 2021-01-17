package kz.q19.data.api.webrtc

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class IceServersResponse constructor(
    @SerializedName("ice_servers")
    val iceServers: List<IceServerResponse>?
)