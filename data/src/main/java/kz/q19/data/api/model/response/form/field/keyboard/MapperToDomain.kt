package kz.q19.data.api.model.response.form.field.keyboard

import kz.garage.chat.model.reply_markup.InlineReplyMarkup
import kz.garage.chat.model.reply_markup.Keyboard
import kz.garage.chat.model.reply_markup.ReplyMarkup
import kz.garage.chat.model.reply_markup.button.CallbackButton
import kz.garage.chat.model.reply_markup.button.TextButton
import kz.q19.data.api.model.response.form.FormResponse

fun FormResponse.FieldResponse.KeyboardResponse.toReplyMarkup(): ReplyMarkup? {
    if (buttons.isNullOrEmpty()) return null
    val rows = buttons.map { buttons ->
        ReplyMarkup.Row(
            buttons.map { button ->
                if (!button.payload.isNullOrBlank()) {
                    CallbackButton(button.text, button.payload)
                } else {
                    TextButton(button.text)
                }
            }
        )
    }
    return if (inline == null || inline) {
        InlineReplyMarkup(rows)
    } else {
        Keyboard(rows)
    }
}