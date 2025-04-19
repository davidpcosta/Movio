package me.davidcosta.movio.core.api.parser

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.time.LocalDate

class LocalDateParser : JsonDeserializer<LocalDate> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalDate? =
        json?.asString.takeUnless { it.isNullOrBlank() }
            ?.let { str ->
                LocalDate.parse(str)
            }
}