package kz.q19.data.api.model.response.configs.booleans

import kz.q19.data.api.model.response.configs.ConfigsResponse
import kz.q19.domain.model.configs.Configs

fun ConfigsResponse.BooleansResponse.toPreferences(): Configs.Preferences {
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