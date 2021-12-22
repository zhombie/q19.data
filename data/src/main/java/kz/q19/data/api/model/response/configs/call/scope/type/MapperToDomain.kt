package kz.q19.data.api.model.response.configs.call.scope.type

import kz.q19.data.api.model.response.configs.ConfigsResponse
import kz.q19.domain.model.configs.Configs

fun ConfigsResponse.CallScopeResponse.TypeResponse.toNestableType(): Configs.Nestable.Type =
    when (this) {
        ConfigsResponse.CallScopeResponse.TypeResponse.FOLDER -> Configs.Nestable.Type.FOLDER
        ConfigsResponse.CallScopeResponse.TypeResponse.LINK -> Configs.Nestable.Type.LINK
    }
