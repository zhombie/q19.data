package kz.q19.data.api.geo

import kz.q19.domain.model.geo.Location

fun LocationResponse.toDomain(): Location {
    return Location(
        provider = provider,
        latitude = latitude,
        longitude = longitude,
        bearing = bearing,
        bearingAccuracyDegrees = bearingAccuracyDegrees,
        xAccuracyMeters = xAccuracyMeters,
        yAccuracyMeters = yAccuracyMeters,
        speed = speed,
        speedAccuracyMetersPerSecond = speedAccuracyMetersPerSecond,
        elapsedRealtimeNanos = elapsedRealtimeNanos,
        elapsedRealtimeUncertaintyNanos = elapsedRealtimeUncertaintyNanos
    )
}