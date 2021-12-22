package kz.q19.data.api.model.response.form.configs

import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.domain.model.form.Form

fun FormResponse.ConfigsResponse.toFormConfigs(): Form.Configs {
    return Form.Configs(
        assignees = assignee,
        projectId = projectId ?: Form.Configs.NO_PROJECT_ID
    )
}