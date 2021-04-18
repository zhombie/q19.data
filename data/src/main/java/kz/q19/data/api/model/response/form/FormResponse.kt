package kz.q19.data.api.model.response.form

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kz.q19.domain.model.file.Extension

@Keep
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

    @Keep
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
        val type: Type?,

        @SerializedName("default")
        val default: String? = null,

        @SerializedName("form_id")
        val formId: Long,

        @SerializedName("info")
        val info: Info? = null,

        @SerializedName("configs")
        val configs: Configs? = null,

        @SerializedName("level")
        val level: Int = 0,

        @SerializedName("value")
        val value: String? = null,

        @SerializedName("keyboard")
        val keyboard: Keyboard? = null,

        @SerializedName("required")
        val isRequired: Boolean? = null,

        @SerializedName("conditions")
        val conditions: Conditions? = null,

        @SerializedName("autofill")
        val autofill: Autofill? = null
    ) {

        @Keep
        enum class Type constructor(val value: String) {
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

        @Keep
        data class Configs constructor(
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

        @Keep
        data class Info constructor(
            @SerializedName("extension")
            val extension: Extension? = null,

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

        @Keep
        data class Keyboard constructor(
            @SerializedName("inline")
            val inline: Boolean?,

            @SerializedName("buttons")
            val buttons: List<List<Button>>?
        ) {

            @Keep
            data class Button constructor(
                @SerializedName("text")
                val text: String,

                @SerializedName("payload")
                val payload: String? = null
            )

        }

        @Keep
        data class Conditions constructor(
            @SerializedName("keyboard")
            val keyboard: List<Condition>?,
        ) {

            @Keep
            data class Condition constructor(
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

        @Keep
        data class Autofill constructor(
            @SerializedName("qualifier")
            val qualifier: String?
        )

    }

    @Keep
    data class ConfigsResponse constructor(
        @SerializedName("assignee")
        val assignee: List<Long>?,

        @SerializedName("project_id")
        val projectId: Long?
    )

    fun isFlexibleForm(): Boolean = isFlex == IS_FLEXIBLE_FORM

}