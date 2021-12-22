package kz.q19.data.api.model.response.form.field.info.extension

import kz.garage.file.extension.Extension

fun ExtensionResponse.toExtension(): Extension? =
    Extension::class.java.enumConstants?.find { it.value == value }