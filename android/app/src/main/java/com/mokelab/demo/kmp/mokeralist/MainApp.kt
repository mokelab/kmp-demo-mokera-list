package com.mokelab.demo.kmp.mokeralist

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.mokelab.demo.kmp.mokeralist.feature.mokera.MokeraListScreen
import com.mokelab.demo.kmp.mokeralist.feature.mokera.MokeraListViewModel
import kotlinx.serialization.Serializable

@Composable
fun MainApp() {
    val backStack = rememberNavBackStack(MokeraList)
    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = entryProvider {
            entry<MokeraList> {
                val viewModel: MokeraListViewModel = hiltViewModel()
                MokeraListScreen(
                    viewModel = viewModel,
                )
            }
        }
    )
}

@Serializable
data object MokeraList : NavKey