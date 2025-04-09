package me.davidcosta.movio.core.utils

import me.davidcosta.movio.BuildConfig
import java.time.LocalDate

fun String.toLocalDate(): LocalDate =
    LocalDate.parse(this)

val String.fullPosterPath
    get() = BuildConfig.TMDB_POSTER_PATH + this

val String.fullProfilePath
        get() = BuildConfig.TMDB_PROFILE_PATH + this