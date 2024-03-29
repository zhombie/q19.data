package kz.q19.data.api.model.response.configs

import com.google.gson.annotations.SerializedName
import kz.q19.data.api.model.response.i18n.I18NStringResponse

data class ConfigsResponse constructor(
    @SerializedName("configs")
    val configs: InnerConfigsResponse?,

    @SerializedName("booleans")
    val booleans: BooleansResponse?,

    @SerializedName("call_scopes")
    val callScopes: List<CallScopeResponse>?
) {

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

        enum class TypeResponse constructor(val value: String) {
            @SerializedName("folder")
            FOLDER("folder"),

            @SerializedName("link")
            LINK("link")
        }

        enum class ActionResponse constructor(val value: String) {
            @SerializedName("audio_call")
            AUDIO_CALL("audio_call"),

            @SerializedName("video_call")
            VIDEO_CALL("video_call")
        }

        enum class ChatTypeResponse constructor(val value: String) {
            @SerializedName("audio")
            AUDIO("audio"),

            @SerializedName("video")
            VIDEO("video"),

            @SerializedName("external")
            EXTERNAL("external"),

            @SerializedName("form")
            FORM("form"),

            @SerializedName("website")
            WEBSITE("website")
        }

        data class DetailsResponse constructor(
            @SerializedName("order")
            val order: Int?,

            @SerializedName("standard")
            val standard: Boolean?,

            @SerializedName("style")
            val style: String?,

            @SerializedName("subtitle")
            val subtitle: String?,

            @Deprecated("Use form.[language] value")
            @SerializedName("form_id")
            val formId: Long?,

            @SerializedName("form")
            val form: FormResponse?,

            @SerializedName("external_id")
            val externalId: Long?,

            @SerializedName("behavior")
            val behavior: BehaviorResponse?,

            @SerializedName("url")
            val url: String?
        ) {

            data class FormResponse constructor(
                @SerializedName("kk")
                val kk: Long?,

                @SerializedName("ru")
                val ru: Long?,

                @SerializedName("en")
                val en: Long?
            )

            enum class BehaviorResponse {
                @SerializedName("unknown")
                UNKNOWN,

                @SerializedName("regular")
                REGULAR,

                @SerializedName("request_location")
                REQUEST_LOCATION
            }

        }

    }

}