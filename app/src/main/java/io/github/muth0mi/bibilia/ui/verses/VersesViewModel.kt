package io.github.muth0mi.bibilia.ui.verses

import androidx.lifecycle.ViewModel
import io.github.muth0mi.bibilia.data.Verse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VersesViewModel : ViewModel() {

    private val _state = MutableStateFlow(VersesViewState())
    val state: StateFlow<VersesViewState>
        get() = _state
}

data class VersesViewState(
    val verses: List<Verse> = emptyList()

)