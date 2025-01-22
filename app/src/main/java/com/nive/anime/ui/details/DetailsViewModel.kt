package com.nive.anime.ui.details


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nive.anime.data.api.AnimeDetails
import com.nive.anime.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class DetailsState {
    data object Loading : DetailsState()
    data class Success(val anime: AnimeDetails) : DetailsState()
    data class Error(val message: String) : DetailsState()
}

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: AnimeRepository
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsState>(DetailsState.Loading)
    val state: StateFlow<DetailsState> = _state

    fun fetchAnimeDetails(animeId: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getAnimeDetails(animeId)
                _state.value = DetailsState.Success(response.data)
            } catch (e: Exception) {
                _state.value = DetailsState.Error(e.message ?: "An unexpected error occurred")
            }
        }
    }
}
