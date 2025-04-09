package me.davidcosta.movio.core.utils

import java.text.DecimalFormat

val Float.formattedVoteAverage: String
    get() = DecimalFormat("0.0").format(this)

val Int.formattedRuntime: String
    get() = "${this.div(60)}h ${this.rem(60)}m"