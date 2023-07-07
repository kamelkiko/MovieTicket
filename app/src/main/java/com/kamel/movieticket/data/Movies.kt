package com.kamel.movieticket.data

import com.kamel.movieticket.R
import com.kamel.movieticket.domain.model.Movie

val movies = listOf(
    Movie(
        name = "Morbius",
        imageDrawable = R.drawable.movie_1,
        time = "1h 44m",
        description = "Determined to cure the disease that has plagued him his entire life, Morbius conducts a drastic experiment, which bears unforeseen consequences.",
        trailer = "https://www.youtube.com/watch?v=oZ6iiRrz1SY",
    ),
    Movie(
        name = "Fantastic Beats: The Secrets of Dumbledore",
        imageDrawable = R.drawable.movie_2,
        time = "2h 23m",
        description = "Doctor Strange teams up with a mysterious teenage girl from his dreams who can travel across multiverses, to battle multiple threats, including other-universe versions of himself, which threaten to wipe out millions across the multiverse.",
        trailer = "https://www.youtube.com/watch?v=aWzlQ2N6qqg",
    ),
    Movie(
        name = "Doctor Strange In The Multiverse Of Madness",
        imageDrawable = R.drawable.movie_3,
        time = "2h 6m",
        description = "Dumbledore assembles a team of wizards, witches and a Muggle baker to oppose the rise of Gellert Grindelwald. They hatch a plan to confuse Grindelwald and stop him from attaining political power.",
        trailer = "https://www.youtube.com/watch?v=Y9dr2zw-TXQ",
    ),
)