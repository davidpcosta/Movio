package me.davidcosta.movio.core.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object DS

val DS.spacing: CustomSpacing
    @Composable @ReadOnlyComposable get() = LocalSpacing.current

val DS.typography: Typography
    @Composable @ReadOnlyComposable get() = MaterialTheme.typography

val DS.color: ColorScheme
    @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme

val DS.shapes: Shapes
    @Composable @ReadOnlyComposable get() = MaterialTheme.shapes
