package kz.q19.data.api.model.response.form.field.conditions

import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.domain.model.form.Form

fun FormResponse.FieldResponse.ConditionsResponse.toFormFieldConditions(): Form.Field.Conditions {
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