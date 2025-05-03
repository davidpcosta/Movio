package me.davidcosta.movio.core.components.core

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import me.davidcosta.movio.R
import me.davidcosta.movio.core.theme.DS
import me.davidcosta.movio.core.theme.color
import me.davidcosta.movio.core.theme.typography

@Composable
fun DSExpandableText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = DS.color.secondary,
    textStyle: TextStyle = DS.typography.bodyMedium,
    showMoreText: String = stringResource(R.string.expandable_text_label_show_more),
    showLessText: String = stringResource(R.string.expandable_text_label_show_less),
    collapsedMaxLine: Int = 3,
) {
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableIntStateOf(0) }

    val suffixStyle = DS.typography.headlineSmall.toSpanStyle().copy(
        color = DS.color.onBackground
    )
    val ellipsis = "..."

    Box(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
                .clickable(clickable) {
                    isExpanded = !isExpanded
                },
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        append(text)
                        append(" ")
                        withStyle(style = suffixStyle) { append(showLessText) }
                    } else {
                        // Display truncated text and "Show More" button when collapsed.
                        val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLast(showMoreText.length)
                            .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                        append(adjustText)
                        append(ellipsis)
                        append(" ")
                        withStyle(style = suffixStyle) { append(showMoreText) }
                    }
                } else {
                    append(text)
                }
            },
            // Set max lines based on the expanded state.
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            // Callback to determine visual overflow and enable click ability.
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = textLayoutResult.getLineEnd(collapsedMaxLine - 1)
                }
            },
            style = textStyle,
            color = textColor
        )
    }
}