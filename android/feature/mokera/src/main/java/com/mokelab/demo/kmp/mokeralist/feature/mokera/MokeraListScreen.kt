package com.mokelab.demo.kmp.mokeralist.feature.mokera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mokelab.demo.kmp.mokeralist.core.design.component.HorizontalDivider
import com.mokelab.demo.kmp.mokeralist.core.design.component.ListItem
import com.mokelab.demo.kmp.mokeralist.core.design.component.Loading
import com.mokelab.demo.kmp.mokeralist.core.design.component.MediumText
import com.mokelab.demo.kmp.mokeralist.core.design.component.Screen
import com.mokelab.demo.kmp.mokeralist.core.model.Mokera

@Composable
fun MokeraListScreen(
    viewModel: MokeraListViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MokeraListScreen(
        uiState = uiState,
        load = { viewModel.load() },
    )
}

@Composable
private fun MokeraListScreen(
    uiState: MokeraListViewModel.UiState,
    load: () -> Unit,
) {
    Screen { innerPadding ->
        when (uiState) {
            MokeraListViewModel.UiState.Initial,
            MokeraListViewModel.UiState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    Loading()
                }
            }

            is MokeraListViewModel.UiState.Success -> {
                MokeraListContent(
                    mokeras = uiState.mokeras,
                    contentPadding = innerPadding,
                )
            }

            is MokeraListViewModel.UiState.Error -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    MediumText(uiState.message)
                }
            }
        }
    }
    LaunchedEffect(uiState) {
        when (uiState) {
            is MokeraListViewModel.UiState.Initial -> {
                load()
            }

            is MokeraListViewModel.UiState.Loading -> Unit
            is MokeraListViewModel.UiState.Success -> Unit
            is MokeraListViewModel.UiState.Error -> Unit
        }
    }
}

@Composable
private fun MokeraListContent(
    mokeras: List<Mokera>,
    contentPadding: PaddingValues,
) {
    LazyColumn(
        contentPadding = contentPadding,
    ) {
        items(mokeras) { mokera ->
            ListItem(
                headlineContent = {
                    MediumText(text = mokera.name)
                },
                supportingContent = {
                    MediumText(text = "ID: ${mokera.id.value}")
                }
            )
            HorizontalDivider()
        }
    }
}