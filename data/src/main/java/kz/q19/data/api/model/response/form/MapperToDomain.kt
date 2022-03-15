package kz.q19.data.api.model.response.form

import kz.q19.data.api.model.response.form.configs.toFormConfigs
import kz.q19.data.api.model.response.form.field.autofill.toFormFieldAutofill
import kz.q19.data.api.model.response.form.field.conditions.toFormFieldConditions
import kz.q19.data.api.model.response.form.field.configs.toFormFieldConfigs
import kz.q19.data.api.model.response.form.field.info.toFormFieldInfo
import kz.q19.data.api.model.response.form.field.keyboard.toKeyboard
import kz.q19.data.api.model.response.form.field.option.toOption
import kz.q19.data.api.model.response.form.field.type.toFormFieldType
import kz.q19.domain.model.form.Form

fun FormResponse.toForm(): Form {
    val fields = mutableListOf<Form.Field>()

    if (!this.fields.isNullOrEmpty()) {
        for (it in this.fields) {
            // If the type is not supported, then skip it
            val type: Form.Field.Type = if (it.type == null) {
                continue
            } else {
                it.type.toFormFieldType()
            }

            fields.add(
                Form.Field(
                    id = it.id,
                    isFlexible = it.isFlex == true,
                    title = it.title ?: "",
                    prompt = it.prompt,
                    type = type,
                    defaultValue = it.default,
                    info = if (it.info == null) null
                    else it.info.toFormFieldInfo(),
                    configs = if (it.configs == null) null
                    else it.configs.toFormFieldConfigs(),
                    level = it.level,
                    keyboard = if (it.keyboard == null) null
                    else it.keyboard.toKeyboard(),
                    options = if (it.options.isNullOrEmpty()) {
                        null
                    } else {
                        it.options.map { it.toOption() }
                    },
                    isRequired = it.isRequired ?: false,
                    conditions = if (it.conditions == null) null
                    else it.conditions.toFormFieldConditions(),
                    autofill = if (it.autofill == null) null
                    else it.autofill.toFormFieldAutofill()
                )
            )
        }
    }

    return Form(
        id = id,
        title = title ?: "",
        prompt = prompt,
        isFlexible = isFlexibleForm(),
        fields = fields,
        configs = configs?.toFormConfigs()
    )
}