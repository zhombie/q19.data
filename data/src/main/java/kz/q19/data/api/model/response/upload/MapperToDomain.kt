package kz.q19.data.api.model.response.upload

import kz.q19.domain.model.upload.UploadResult

fun UploadResponse.toUploadResult(): UploadResult =
    UploadResult(hash = hash, title = title, url = url)
