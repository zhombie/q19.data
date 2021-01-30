package kz.q19.data.api.model.response.configs

import kz.q19.data.api.model.response.i18n.toDomain
import kz.q19.domain.model.call.CallType
import kz.q19.domain.model.configs.Configs


fun ConfigsResponse.BooleansResponse.toDomain(): Configs.Preferences {
    return Configs.Preferences(
        isChatBotEnabled = isChatBotEnabled == true,
        isPhonesListShown = isPhonesListShown == true,
        isContactSectionsShown = isContactSectionsShown == true,
        isAudioCallEnabled = isAudioCallEnabled == true,
        isVideoCallEnabled = isVideoCallEnabled == true,
        isServicesEnabled = isServicesEnabled == true,
        isCallAgentsScoped = isOperatorsScoped == true
    )
}


fun ConfigsResponse.CallScopeResponse.TypeResponse.toDomain(): Configs.Nestable.Type {
    return when (this) {
        ConfigsResponse.CallScopeResponse.TypeResponse.FOLDER -> Configs.Nestable.Type.FOLDER
        ConfigsResponse.CallScopeResponse.TypeResponse.LINK -> Configs.Nestable.Type.LINK
    }
}


fun ConfigsResponse.CallScopeResponse.DetailsResponse.BehaviorResponse.toDomain(): Configs.Nestable.Extra.Behavior {
    return when (this) {
        ConfigsResponse.CallScopeResponse.DetailsResponse.BehaviorResponse.UNKNOWN ->
            Configs.Nestable.Extra.Behavior.UNKNOWN
        ConfigsResponse.CallScopeResponse.DetailsResponse.BehaviorResponse.REGULAR ->
            Configs.Nestable.Extra.Behavior.REGULAR
        ConfigsResponse.CallScopeResponse.DetailsResponse.BehaviorResponse.REQUEST_LOCATION ->
            Configs.Nestable.Extra.Behavior.REQUEST_LOCATION
    }
}


fun ConfigsResponse.toDomain(): Configs {
    val bot = Configs.Bot(
        image = configs?.image,
        title = configs?.title
    )

    val callAgent = Configs.CallAgent(
        defaultName = configs?.defaultOperator,
    )

    val preferences = booleans?.toDomain() ?: Configs.Preferences()

    val calls = mutableListOf<Configs.Call>()
    val services = mutableListOf<Configs.Service>()
    val forms = mutableListOf<Configs.Form>()

    if (!callScopes.isNullOrEmpty()) {
        for (it in callScopes) {
            val parentId = it.parentId ?: ConfigsResponse.CallScopeResponse.NO_PARENT_ID

            val type = it.type?.toDomain()

            val title = it.title.toDomain()

            val extra = Configs.Nestable.Extra(
                order = it.details?.order,
                behavior = it.details?.behavior?.toDomain()
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
                    if (it.details?.formId != null) {
                        forms.add(
                            Configs.Form(
                                id = it.id,
                                parentId = parentId,
                                type = type,
                                formId = it.details.formId,
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