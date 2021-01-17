package kz.q19.data.api.upload

import kz.q19.domain.model.upload.Upload

fun UploadResponse.toDomain(): Upload {
    return Upload(hash = hash, title = title, url = url)
}