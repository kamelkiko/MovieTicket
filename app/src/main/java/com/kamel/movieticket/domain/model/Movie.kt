package com.kamel.movieticket.domain.model

data class Movie(
    val id: Int? = 0,
    val name: String? = "",
    val imageDrawable: Int? = 0,
    val trailer: String? = "",
    val time: String? = "",
    val description: String? = "",
)
