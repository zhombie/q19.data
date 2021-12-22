package kz.q19.data.api.model.response.form.field.type

import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.domain.model.form.Form

fun FormResponse.FieldResponse.Type.toFormFieldType(): Form.Field.Type {
    return when (this) {
        FormResponse.FieldResponse.Type.TEXT -> Form.Field.Type.TEXT

        FormResponse.FieldResponse.Type.SELECT -> Form.Field.Type.SELECT

        FormResponse.FieldResponse.Type.BOOLEAN -> Form.Field.Type.BOOLEAN

        FormResponse.FieldResponse.Type.PHONE_NUMBER -> Form.Field.Type.PHONE_NUMBER

        FormResponse.FieldResponse.Type.IMAGE -> Form.Field.Type.IMAGE
        FormResponse.FieldResponse.Type.AUDIO -> Form.Field.Type.AUDIO
        FormResponse.FieldResponse.Type.VIDEO -> Form.Field.Type.VIDEO
        FormResponse.FieldResponse.Type.DOCUMENT -> Form.Field.Type.DOCUMENT
        FormResponse.FieldResponse.Type.FILE -> Form.Field.Type.FILE
    }
}