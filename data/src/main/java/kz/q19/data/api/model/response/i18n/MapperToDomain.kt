package kz.q19.data.api.model.response.i18n

import kz.q19.domain.model.i18n.I18NString

fun I18NStringResponse.toI18NString(): I18NString {
    val kk = if (!kk.isNullOrBlank()) kk else kz
    return I18NString(kk = kk, ru = ru, en = en)
}