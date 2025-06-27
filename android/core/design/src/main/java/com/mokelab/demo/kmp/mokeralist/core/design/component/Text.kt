package com.mokelab.demo.kmp.mokeralist.core.design.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MediumText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
) {
    androidx.compose.material3.Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
    )
}