package me.davidcosta.movio.core.utils

import java.text.DecimalFormat

val Float.formattedVoteAverage: String
    get() = DecimalFormat("0.0").format(this)

val Int.formattedRuntime: String
    get() = when(this) {
        in 0 .. 59 -> "${this}m"
        else  -> "${this.div(60)}h ${this.rem(60)}m"
    }