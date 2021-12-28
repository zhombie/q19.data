package kz.q19.data.api.model.response.webrtc.ice_server

import kz.q19.domain.model.webrtc.IceServer

fun IceServerResponse.toIceServer(): IceServer =
    IceServer(
        url = url ?: "",
        urls = urls ?: "",
        username = username,
        credential = credential
    )


fun IceServersResponse.toIceServers(): List<IceServer>? =
    iceServers?.map { it.toIceServer() }