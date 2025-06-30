package com.mokelab.demo.kmp.mokeralist.feature.mokera

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mokelab.demo.kmp.mokeralist.core.data.MokeraRepository
import com.mokelab.demo.kmp.mokeralist.core.model.Mokera
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MokeraListViewModel @Inject constructor(
    private val repository: MokeraRepository,
) : ViewModel() {
    sealed interface UiState {
        data object Initial : UiState
        data object Loading : UiState
        data class Success(val mokeras: List<Mokera>) : UiState
        data class Error(val message: String) : UiState
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Initial)
    val uiState = _uiState.asStateFlow()

    fun load() {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val mokeras = repository.getAll()
                _uiState.value = UiState.Success(mokeras)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}