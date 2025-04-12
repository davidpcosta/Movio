package me.davidcosta.movio.core.utils

import me.davidcosta.movio.BuildConfig
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

const val VIDEO_KEY = "{VIDEO_KEY}"
val zone: ZoneId = ZoneId.of("America/Sao_Paulo")
val locale: Locale = Locale.forLanguageTag("pt-BR")

fun String?.formatLongDate() =
    this.takeUnless { it.isNullOrBlank() }
        ?.let {
            ZonedDateTime.parse(this)
                .withZoneSameInstant(zone)
                .toLocalDateTime()
                .format(
                    DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.LONG)
                        .withLocale(locale)
                )
        }

fun String?.formatYear(): String =
    this.takeUnless { it.isNullOrBlank() }
        ?.let { str ->
            LocalDate.parse(str).year.toString()
        } ?: "n/a"

val String?.fullPosterPath
    get() = this?.let { path ->
        BuildConfig.TMDB_POSTER_PATH + path
    }.orEmpty()

val String?.fullProfilePath
        get() = this?.let { path ->
            BuildConfig.TMDB_PROFILE_PATH + path
        }.orEmpty()

val String?.fullThumbPath
        get() = this?.let { key ->
            BuildConfig.TMDB_THUMB_PATH.replace(VIDEO_KEY, key)
        }.orEmpty()

val String?.fullVideoPath
    get() = this?.let { key ->
        BuildConfig.TMDB_VIDEO_PATH.replace(VIDEO_KEY, key)
    }.orEmpty()
