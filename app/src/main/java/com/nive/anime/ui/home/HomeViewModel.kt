package com.nive.anime.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nive.anime.data.api.Anime
import com.nive.anime.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class HomeViewState {
    data object Loading : HomeViewState()
    data class Success(val animeList: List<Anime>) : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel()
{

    private val _viewState = MutableStateFlow<HomeViewState>(HomeViewState.Loading)
    val viewState: StateFlow<HomeViewState> = _viewState

    init {
        fetchTopAnime()
    }

    private fun fetchTopAnime() {
        viewModelScope.launch {
            _viewState.value = HomeViewState.Loading
            try {
                val response = animeRepository.getTopAnime()
                _viewState.value = HomeViewState.Success(response.data)
            } catch (e: Exception) {
                _viewState.value = HomeViewState.Error(e.message ?: "Failed to load anime list")
            }
        }
    }
}
