package com.nive.anime.data.api

data class AnimeResponse(
    val data: List<Anime>
)

data class Anime(
    val mal_id: Int,
    val title: String,
    val episodes: Int,
    val score: Float,
    val images: Images
)

data class Images(
    val jpg: ImageDetails
)

data class ImageDetails(
    val image_url: String
)