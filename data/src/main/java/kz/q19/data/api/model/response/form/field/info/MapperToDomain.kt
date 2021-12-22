package kz.q19.data.api.model.response.form.field.info

import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.data.api.model.response.form.field.info.extension.toExtension
import kz.q19.domain.model.form.Form

fun FormResponse.FieldResponse.Info.toFormFieldInfo(): Form.Field.Info {
    return Form.Field.Info(
        extension = extension?.toExtension(),
        width =  width,
        height = height,
        duration = duration,
        dateAdded = dateAdded,
        dateModified = dateModified,
        dateTaken = dateTaken,
        size = size
    )
}