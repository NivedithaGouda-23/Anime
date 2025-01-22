package com.nive.anime.data.repository


import com.nive.anime.data.api.AnimeDetailsResponse
import com.nive.anime.data.api.AnimeResponse
import com.nive.anime.data.api.ApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getTopAnime(): AnimeResponse {
        return apiService.getTopAnime()
    }

    suspend fun getAnimeDetails(animeId: Int): AnimeDetailsResponse {
        return apiService.getAnimeDetails(animeId)
    }
}
