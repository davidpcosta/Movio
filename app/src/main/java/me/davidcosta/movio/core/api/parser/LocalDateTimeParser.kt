package me.davidcosta.movio.core.api.parser

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import me.davidcosta.movio.core.utils.zone
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.ZonedDateTime

class LocalDateTimeParser : JsonDeserializer<LocalDateTime> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalDateTime? =
        json?.asString.takeUnless { it.isNullOrBlank() }
            ?.let { str ->
                ZonedDateTime.parse(str)
                    .withZoneSameInstant(zone)
                    .toLocalDateTime()
            }
}