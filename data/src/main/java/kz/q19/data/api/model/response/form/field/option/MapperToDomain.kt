package kz.q19.data.api.model.response.form.field.option

import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.domain.model.form.Form

fun FormResponse.FieldResponse.OptionResponse.toOption(): Form.Field.Option =
    Form.Field.Option(
        id = id,
        title = title,
        parentId = parentId,
        key = key,
        value = value
    )
