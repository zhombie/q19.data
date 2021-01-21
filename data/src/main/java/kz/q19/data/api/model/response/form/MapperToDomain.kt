package kz.q19.data.api.model.response.form

import kz.q19.domain.model.form.Form
import kz.q19.domain.model.keyboard.Keyboard
import kz.q19.domain.model.keyboard.button.CallbackButton
import kz.q19.domain.model.keyboard.button.TextButton

fun FormResponse.FieldResponse.Info.toDomain(): Form.Field.Info {
    return Form.Field.Info(
        extension = extension,
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
        FormResponse.FieldResponse.Type.FILE -> Form.Field.Type.FILE
    }
}


fun FormResponse.FieldResponse.Configs.toDomain(): Form.Field.Configs {
    return Form.Field.Configs(
        isMultipleSelection = isMultipleSelection == true,
        maxSelectionCount = maxSelectionCount ?: 0,
        key = key,
        regexp = regexp,
        regexpExplanation = regexpExplanation
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
            fields.add(
                Form.Field(
                    id = it.id,
                    isFlexible = it.isFlex == true,
                    title = it.title ?: "",
                    prompt = it.prompt,
                    type = it.type?.toDomain() ?: continue,  // If the type is not supported, then skip it
                    defaultValue = it.default,
                    info = it.info?.toDomain(),
                    configs = it.configs?.toDomain(),
                    level = it.level,
                    keyboard = it.keyboard?.toDomain(),
                    isRequired = it.isRequired ?: false,
                    conditions = it.conditions?.toDomain(),
                    autofill = it.autofill?.toDomain()
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