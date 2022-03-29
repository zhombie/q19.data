package kz.q19.data.api.model.response.form

import com.google.gson.annotations.SerializedName
import kz.q19.data.api.model.response.form.field.info.extension.ExtensionResponse

data class FormResponse constructor(
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String?,

    @SerializedName("is_flex")
    val isFlex: Int?,

    @SerializedName("prompt")
    val prompt: String?,

    @SerializedName("fields")
    val fields: List<FieldResponse>?,

    @SerializedName("configs")
    val configs: ConfigsResponse?
) {

    companion object {
        const val IS_NOT_FLEXIBLE_FORM = 0
        const val IS_FLEXIBLE_FORM = 1
    }

    data class FieldResponse constructor(
        @SerializedName("id")
        val id: Long,

        @SerializedName("is_flex")
        val isFlex: Boolean?,

        @SerializedName("title")
        val title: String?,

        @SerializedName("prompt")
        val prompt: String?,

        @SerializedName("type")
        val type: TypeResponse?,

        @SerializedName("default")
        val default: String? = null,

        @SerializedName("form_id")
        val formId: Long,

        @SerializedName("info")
        val info: InfoResponse? = null,

        @SerializedName("configs")
        val configs: ConfigsResponse? = null,

        @SerializedName("level")
        val level: Int = 0,

        @SerializedName("value")
        val value: String? = null,

        @SerializedName("keyboard")
        val keyboard: KeyboardResponse? = null,

        @SerializedName("options")
        val options: List<OptionResponse>? = null,

        @SerializedName("required")
        val isRequired: Boolean? = null,

        @SerializedName("conditions")
        val conditions: ConditionsResponse? = null,

        @SerializedName("autofill")
        val autofill: AutofillResponse? = null
    ) {

        enum class TypeResponse constructor(val value: String) {
            @SerializedName("text")
            TEXT("text"),

            @SerializedName("select")
            SELECT("select"),

            @SerializedName("boolean")
            BOOLEAN("boolean"),

            @SerializedName("phone_number")
            PHONE_NUMBER("phone_number"),

            @SerializedName("image")
            IMAGE("image"),

            @SerializedName("audio")
            AUDIO("audio"),

            @SerializedName("video")
            VIDEO("video"),

            @SerializedName("document")
            DOCUMENT("document"),

            @SerializedName("file")
            FILE("file")
        }

        data class ConfigsResponse constructor(
            @SerializedName("multiple_selection")
            val isMultipleSelection: Boolean? = null,

            @SerializedName("max_selection_count")
            val maxSelectionCount: Int? = null,

            @SerializedName("key")
            val key: String? = null,

            @SerializedName("regexp")
            val regexp: String? = null,

            @SerializedName("regexp_explanation")
            val regexpExplanation: String? = null,

            @SerializedName("input_text_max_length")
            val inputTextMaxLength: Int? = null,

            @SerializedName("input_text_max_lines")
            val inputTextMaxLines: Int? = null
        )

        data class InfoResponse constructor(
            @SerializedName("extension")
            val extension: ExtensionResponse? = null,

            @SerializedName("width")
            val width: Int? = null,

            @SerializedName("height")
            val height: Int? = null,

            @SerializedName("duration")
            val duration: Long? = null,  // milliseconds

            @SerializedName("date_added")
            val dateAdded: Long? = null,  // milliseconds

            @SerializedName("date_modified")
            val dateModified: Long? = null,  // milliseconds

            @SerializedName("date_taken")
            val dateTaken: Long? = null,  // milliseconds

            @SerializedName("size")
            val size: Long? = null
        )

        data class KeyboardResponse constructor(
            @SerializedName("inline")
            val inline: Boolean?,

            @SerializedName("buttons")
            val buttons: List<List<ButtonResponse>>?
        ) {

            data class ButtonResponse constructor(
                @SerializedName("text")
                val text: String,

                @SerializedName("payload")
                val payload: String? = null
            )

        }

        data class OptionResponse constructor(
            @SerializedName("id")
            val id: Long,

            @SerializedName("title")
            val title: String,

            @SerializedName("parent_id")
            val parentId: Long? = null,

            @SerializedName("key")
            val key: String,

            @SerializedName("value")
            val value: String? = null
        )

        data class ConditionsResponse constructor(
            @SerializedName("keyboard")
            val keyboard: List<ConditionResponse>?,
        ) {

            data class ConditionResponse constructor(
                @SerializedName("payload")
                val payload: String? = null,

                @SerializedName("next_step")
                val nextStep: Int?,

                @SerializedName("show_steps")
                val showSteps: List<Int>?,

                @SerializedName("hide_steps")
                val hideSteps: List<Int>?
            )

        }

        data class AutofillResponse constructor(
            @SerializedName("qualifier")
            val qualifier: String?
        )

    }

    data class ConfigsResponse constructor(
        @SerializedName("assignee")
        val assignee: List<Long>?,

        @SerializedName("project_id")
        val projectId: Long?
    )

    fun isFlexibleForm(): Boolean = isFlex == IS_FLEXIBLE_FORM

}