package kz.q19.data.api.model.response.configs

import kz.q19.data.api.model.response.configs.booleans.toPreferences
import kz.q19.data.api.model.response.configs.call.scope.details.behavior.toNestableBehavior
import kz.q19.data.api.model.response.configs.call.scope.type.toNestableType
import kz.q19.data.api.model.response.i18n.toI18NString
import kz.q19.domain.model.call.type.CallType
import kz.q19.domain.model.configs.Configs
import kz.q19.domain.model.i18n.I18NId

fun ConfigsResponse.toDomain(): Configs {
    val bot = Configs.Bot(
        image = configs?.image,
        title = configs?.title
    )

    val callAgent = Configs.CallAgent(
        defaultName = configs?.defaultOperator,
    )

    val preferences = booleans?.toPreferences() ?: Configs.Preferences()

    val calls = mutableListOf<Configs.Call>()
    val services = mutableListOf<Configs.Service>()
    val forms = mutableListOf<Configs.Form>()

    if (!callScopes.isNullOrEmpty()) {
        for (it in callScopes) {
            val parentId = it.parentId ?: ConfigsResponse.CallScopeResponse.NO_PARENT_ID

            val type = it.type?.toNestableType()

            val title = it.title.toI18NString()

            val extra = Configs.Nestable.Extra(
                order = it.details?.order,
                behavior = it.details?.behavior?.toNestableBehavior()
            )

            when (it.chatType) {
                ConfigsResponse.CallScopeResponse.ChatTypeResponse.AUDIO,
                ConfigsResponse.CallScopeResponse.ChatTypeResponse.VIDEO -> {
                    val callType = when (it.action) {
                        ConfigsResponse.CallScopeResponse.ActionResponse.AUDIO_CALL ->
                            CallType.AUDIO
                        ConfigsResponse.CallScopeResponse.ActionResponse.VIDEO_CALL ->
                            CallType.VIDEO
                        else -> null
                    }
                    calls.add(
                        Configs.Call(
                            id = it.id,
                            parentId = parentId,
                            type = type,
                            callType = callType,
                            title = title,
                            scope = it.scope,
                            extra = extra
                        )
                    )
                }
                ConfigsResponse.CallScopeResponse.ChatTypeResponse.FORM,
                ConfigsResponse.CallScopeResponse.ChatTypeResponse.EXTERNAL -> {
                    if (it.details?.form != null) {
                        forms.add(
                            Configs.Form(
                                id = it.id,
                                parentId = parentId,
                                type = type,
                                formId = I18NId(
                                    kk = it.details.form.kk,
                                    ru = it.details.form.ru,
                                    en = it.details.form.en
                                ),
                                title = title,
                                extra = extra
                            )
                        )
                    } else if (it.details?.externalId != null) {
                        services.add(
                            Configs.Service(
                                id = it.id,
                                parentId = parentId,
                                type = type,
                                serviceId = it.details.externalId,
                                title = title,
                                extra = extra
                            )
                        )
                    }
                }
                else -> {}
            }
        }
    }

    return Configs(
        bot = bot,
        callAgent = callAgent,
        preferences = preferences,
        calls = calls,
        forms = forms,
        services = services
    )
}