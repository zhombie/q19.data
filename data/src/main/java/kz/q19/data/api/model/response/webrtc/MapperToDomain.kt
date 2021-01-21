package kz.q19.data.api.model.response.webrtc

import kz.q19.domain.model.webrtc.IceServer


fun IceServerResponse.toDomain(): IceServer {
    return IceServer(
        url = url ?: "",
        urls = urls ?: "",
        username = username,
        credential = credential
    )
}


fun IceServersResponse.toDomain(): List<IceServer> {
    return iceServers?.map { it.toDomain() } ?: emptyList()
}