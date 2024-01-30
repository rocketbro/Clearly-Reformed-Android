package com.asherpope.clearlyreformed.domain

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ScriptMessageState(
    val body: String? = null
)
// probably none of this is necessary...
class ScriptMessageViewModel: ViewModel() {
    // Expose screen UI state
    private val _uiState = MutableStateFlow(ScriptMessageState())
    val uiState: StateFlow<ScriptMessageState> = _uiState.asStateFlow()
}
