package com.mokelab.demo.kmp.mokeralist.core.design.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListItem(
    headlineContent: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    supportingContent: @Composable (() -> Unit)? = null,
) {
    androidx.compose.material3.ListItem(
        headlineContent = headlineContent,
        modifier = modifier,
        supportingContent = supportingContent,
    )
}

