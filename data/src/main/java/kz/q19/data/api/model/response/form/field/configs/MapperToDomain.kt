package kz.q19.data.api.model.response.form.field.configs

import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.domain.model.form.Form

fun FormResponse.FieldResponse.ConfigsResponse.toFormFieldConfigs(): Form.Field.Configs {
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