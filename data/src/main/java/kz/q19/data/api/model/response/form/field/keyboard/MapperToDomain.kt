package kz.q19.data.api.model.response.form.field.keyboard

import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.domain.model.keyboard.Keyboard
import kz.q19.domain.model.keyboard.button.CallbackButton
import kz.q19.domain.model.keyboard.button.TextButton

fun FormResponse.FieldResponse.Keyboard.toKeyboard(): Keyboard {
    return Keyboard(
        inline = inline,
        buttons = buttons?.map { buttons ->
            buttons.map { button ->
                if (!button.payload.isNullOrBlank()) {
                    CallbackButton(button.text, button.payload)
                } else {
                    TextButton(button.text)
                }
            }
        }
    )
}