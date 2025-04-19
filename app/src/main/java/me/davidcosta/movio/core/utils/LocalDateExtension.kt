package me.davidcosta.movio.core.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

fun LocalDateTime?.formatLongDate(): String? =
    this?.toLocalDate().formatLongDate()

fun LocalDate?.formatLongDate(): String? =
    this.takeUnless { it == null}
        ?.format(
            DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG)
                .withLocale(locale)
        )

fun LocalDateTime?.formatMediumDate(): String? =
    this?.toLocalDate().formatMediumDate()

fun LocalDate?.formatMediumDate(): String? =
    this.takeUnless { it == null }
        ?.format(
            DateTimeFormatter
                .ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(locale)
        )

fun LocalDate?.formatYear(): String? =
    this?.year?.toString()

