package kz.q19.data.api.model.response.form.field.type

import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.domain.model.form.Form

fun FormResponse.FieldResponse.TypeResponse.toFormFieldType(): Form.Field.Type {
    return when (this) {
        FormResponse.FieldResponse.TypeResponse.TEXT -> Form.Field.Type.TEXT

        FormResponse.FieldResponse.TypeResponse.SELECT -> Form.Field.Type.SELECT

        FormResponse.FieldResponse.TypeResponse.BOOLEAN -> Form.Field.Type.BOOLEAN

        FormResponse.FieldResponse.TypeResponse.PHONE_NUMBER -> Form.Field.Type.PHONE_NUMBER

        FormResponse.FieldResponse.TypeResponse.IMAGE -> Form.Field.Type.IMAGE
        FormResponse.FieldResponse.TypeResponse.AUDIO -> Form.Field.Type.AUDIO
        FormResponse.FieldResponse.TypeResponse.VIDEO -> Form.Field.Type.VIDEO
        FormResponse.FieldResponse.TypeResponse.DOCUMENT -> Form.Field.Type.DOCUMENT
        FormResponse.FieldResponse.TypeResponse.FILE -> Form.Field.Type.FILE
    }
}