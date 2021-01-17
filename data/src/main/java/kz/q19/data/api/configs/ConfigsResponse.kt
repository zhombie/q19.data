package kz.q19.data.api.configs

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kz.q19.data.api.i18n.I18NStringResponse

@Keep
data class ConfigsResponse constructor(
    @SerializedName("configs")
    val configs: InnerConfigsResponse?,

    @SerializedName("booleans")
    val booleans: BooleansResponse?,

    @SerializedName("call_scopes")
    val callScopes: List<CallScopeResponse>?
) {

    @Keep
    data class InnerConfigsResponse constructor(
        @SerializedName("title")
        val title: String?,

        @SerializedName("image")
        val image: String?,

        @SerializedName("default_operator")
        val defaultOperator: String?,

        @SerializedName("type")
        val type: Int?
    )

    @Keep
    data class BooleansResponse constructor(
        @SerializedName("chatbot_enabled")
        val isChatBotEnabled: Boolean? = false,

        @SerializedName("phones_list_shown")
        val isPhonesListShown: Boolean? = false,

        @SerializedName("contact_sections_shown")
        val isContactSectionsShown: Boolean? = false,

        @SerializedName("video_call_enabled")
        val isVideoCallEnabled: Boolean? = false,

        @SerializedName("audio_call_enabled")
        val isAudioCallEnabled: Boolean? = false,

        @SerializedName("services_enabled")
        val isServicesEnabled: Boolean? = false,

        @SerializedName("operators_scoped")
        val isOperatorsScoped: Boolean? = false
    )

    @Keep
    data class CallScopeResponse constructor(
        @SerializedName("id")
        val id: Long,

        @SerializedName("type")
        val type: TypeResponse?,

        @SerializedName("scope")
        val scope: String?,

        @SerializedName("title")
        val title: I18NStringResponse,

        @SerializedName("parent_id")
        val parentId: Long? = NO_PARENT_ID,

        @SerializedName("chat_type")
        val chatType: ChatTypeResponse?,

        @SerializedName("action")
        val action: ActionResponse?,

        @SerializedName("details")
        val details: DetailsResponse?
    ) {

        companion object {
            const val NO_PARENT_ID = 0L
        }

        @Keep
        enum class TypeResponse constructor(val value: String) {
            @SerializedName("folder")
            FOLDER("folder"),

            @SerializedName("link")
            LINK("link")
        }

        @Keep
        enum class ActionResponse constructor(val value: String) {
            @SerializedName("audio_call")
            AUDIO_CALL("audio_call"),

            @SerializedName("video_call")
            VIDEO_CALL("video_call")
        }

        @Keep
        enum class ChatTypeResponse constructor(val value: String) {
            @SerializedName("audio")
            AUDIO("audio"),

            @SerializedName("video")
            VIDEO("video"),

            @SerializedName("external")
            EXTERNAL("external"),

            @SerializedName("form")
            FORM("form")
        }

        @Keep
        data class DetailsResponse constructor(
            @SerializedName("order")
            val order: Int?,

            @SerializedName("standard")
            val standard: Boolean?,

            @SerializedName("style")
            val style: String?,

            @SerializedName("subtitle")
            val subtitle: String?,

            @SerializedName("form_id")
            val formId: Long?,

            @SerializedName("external_id")
            val externalId: Long?
        )

    }

}