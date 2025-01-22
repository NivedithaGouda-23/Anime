package com.nive.anime.data.api

data class AnimeDetailsResponse(
    val data: AnimeDetails
)

data class AnimeDetails(
    val title: String,
    val synopsis: String,
    val episodes: Int,
    val score: Float,
    val genres: List<Genre>,
    val trailer: Trailer?,
    val characters: List<Character>,
    val images: Images
)

data class Genre(val name: String)
data class Trailer(val url: String?)
data class Character(val name: String)
