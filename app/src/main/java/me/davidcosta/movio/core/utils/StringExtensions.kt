package me.davidcosta.movio.core.utils

import me.davidcosta.movio.BuildConfig
import java.time.ZoneId
import java.util.Locale

const val VIDEO_KEY = "{VIDEO_KEY}"
val zone: ZoneId = ZoneId.of("America/Sao_Paulo")
val locale: Locale = Locale.forLanguageTag("pt-BR")

fun String?.orDefault(defaultStr: String): String =
    this.takeUnless { it.isNullOrBlank() } ?: defaultStr

fun String?.validate(): String? =
    this.takeUnless { it.isNullOrBlank() }

val String?.fullStillPath
    get() = this?.let { path ->
        BuildConfig.TMDB_STILL_PATH + path
    }.orEmpty()

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
