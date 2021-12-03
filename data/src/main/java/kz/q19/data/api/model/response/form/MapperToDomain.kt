package kz.q19.data.api.model.response.form

import kz.garage.file.extension.Extension
import kz.q19.domain.model.form.Form
import kz.q19.domain.model.keyboard.Keyboard
import kz.q19.domain.model.keyboard.button.CallbackButton
import kz.q19.domain.model.keyboard.button.TextButton

fun ExtensionResponse.toDomain(): Extension? =
    Extension::class.java.enumConstants?.find { it.value == value }


fun FormResponse.FieldResponse.Info.toDomain(): Form.Field.Info {
    return Form.Field.Info(
        extension = extension?.toDomain(),
        width =  width,
        height = height,
        duration = duration,
        dateAdded = dateAdded,
        dateModified = dateModified,
        dateTaken = dateTaken,
        size = size
    )
}


fun FormResponse.FieldResponse.Type.toDomain(): Form.Field.Type {
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


fun FormResponse.FieldResponse.Configs.toDomain(): Form.Field.Configs {
    return Form.Field.Configs(
        isMultipleSelection = isMultipleSelection,
        maxSelectionCount = maxSelectionCount,
        key = key,
        regexp = regexp,
        regexpExplanation = regexpExplanation,
        inputTextMaxLength = inputTextMaxLength,
        inputTextMaxLines = inputTextMaxLines
    )
}


fun FormResponse.FieldResponse.Keyboard.toDomain(): Keyboard {
    return Keyboard(
        inline = inline,
        buttons = buttons?.map { buttons ->
            buttons.map { button ->
                if (!button.payload.isNullOrBlank()) {
                    CallbackButton(button.text, button.payload)
                } else {
                    TextButton(button.text)
                }
            }
        }
    )
}


fun FormResponse.FieldResponse.Conditions.toDomain(): Form.Field.Conditions {
    return Form.Field.Conditions(
        keyboard?.map {
            Form.Field.Conditions.Condition(
                payload = it.payload,
                nextStep = it.nextStep,
                showSteps = it.showSteps,
                hideSteps = it.hideSteps
            )
        }
    )
}


fun FormResponse.FieldResponse.Autofill.toDomain(): Form.Field.Autofill {
    return Form.Field.Autofill(
        qualifier = when (qualifier) {
            "user.first_name" -> Form.Field.Autofill.Qualifier.USER_FIRST_NAME
            "user.last_name" -> Form.Field.Autofill.Qualifier.USER_LAST_NAME
            "user.full_name" -> Form.Field.Autofill.Qualifier.USER_FULL_NAME
            "user.iin" -> Form.Field.Autofill.Qualifier.USER_IIN
            "user.email" -> Form.Field.Autofill.Qualifier.USER_EMAIL
            "user.phone_number" -> Form.Field.Autofill.Qualifier.USER_PHONE_NUMBER
            "user.geolocation" -> Form.Field.Autofill.Qualifier.USER_GEOLOCATION
            else -> Form.Field.Autofill.Qualifier.UNKNOWN
        }
    )
}


fun FormResponse.ConfigsResponse.toDomain(): Form.Configs {
    return Form.Configs(
        assignees = assignee,
        projectId = projectId ?: Form.Configs.NO_PROJECT_ID
    )
}


fun FormResponse.toDomain(): Form {
    val fields = mutableListOf<Form.Field>()

    if (!this.fields.isNullOrEmpty()) {
        for (it in this.fields) {
            // If the type is not supported, then skip it
            val type: Form.Field.Type = if (it.type == null) {
                continue
            } else {
                it.type.toDomain()
            }

            fields.add(
                Form.Field(
                    id = it.id,
                    isFlexible = it.isFlex == true,
                    title = it.title ?: "",
                    prompt = it.prompt,
                    type = type,
                    defaultValue = it.default,
                    info = if (it.info != null) it.info.toDomain() else null,
                    configs = if (it.configs != null) it.configs.toDomain() else null,
                    level = it.level,
                    keyboard = if (it.keyboard != null) it.keyboard.toDomain() else null,
                    isRequired = it.isRequired ?: false,
                    conditions = if (it.conditions != null) it.conditions.toDomain() else null,
                    autofill = if (it.autofill != null) it.autofill.toDomain() else null
                )
            )
        }
    }

    return Form(
        id = id,
        title = title ?: "",
        prompt = null,
        isFlexible = isFlexibleForm(),
        fields = fields,
        configs = configs?.toDomain()
    )
}