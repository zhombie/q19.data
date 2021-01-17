package kz.q19.data.api.geo

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LocationResponse constructor(
    @SerializedName("provider")
    val provider: String? = null,

    @SerializedName("lat")
    val latitude: Double,

    @SerializedName("lon")
    val longitude: Double,

    @SerializedName("bearing")
    val bearing: Float? = null,

    @SerializedName("bearing_accuracy_degrees")
    val bearingAccuracyDegrees: Float? = null,

    @SerializedName("x_accuracy_meters")
    val xAccuracyMeters: Float? = null,

    @SerializedName("y_accuracy_meters")
    val yAccuracyMeters: Float? = null,

    @SerializedName("speed")
    val speed: Float? = null,

    @SerializedName("speed_accuracy_meters_per_second")
    val speedAccuracyMetersPerSecond: Float? = null,

    @SerializedName("elapsed_realtime_nanos")
    val elapsedRealtimeNanos: Long? = null,

    @SerializedName("elapsed_realtime_uncertainty_nanos")
    val elapsedRealtimeUncertaintyNanos: Double? = null
)