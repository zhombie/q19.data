package kz.q19.data.api.model.response.geo

import kz.q19.domain.model.geo.Location

fun LocationResponse.toLocation(): Location =
    Location(
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
