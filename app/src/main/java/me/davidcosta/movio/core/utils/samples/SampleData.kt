package me.davidcosta.movio.core.utils.samples

import me.davidcosta.movio.core.domain.Poster
import me.davidcosta.movio.core.domain.Title
import java.time.LocalDate

object SampleData

const val posterPrefix = "https://media.themoviedb.org/t/p/w220_and_h330_face"
const val highlightPrefix = "https://media.themoviedb.org/t/p/w533_and_h300_bestv2"

val SampleData.TitleList: List<Title>
    get() = listOf(
        Title(
            title = "Adolescense",
            posterPath = "$posterPrefix/3v8MSpNNk3hhadeU9XocQrQXbuk.jpg",
            thumbPath = "$highlightPrefix/9SUiZcIuDa8SxwrDsjtm1JEgjR4.jpg",
            releaseDate = LocalDate.parse("2025-03-13"),
            voteAverage = "7,9"
        ),
        Title(
            title = "Captain America: Brave New World",
            posterPath = "$posterPrefix/pzIddUEMWhWzfvLI3TwxUG2wGoi.jpg",
            thumbPath = "$highlightPrefix/eJLTpgUAFkx165LuUoQqQGyN5Wp.jpg",
            releaseDate = LocalDate.parse("2025-02-12"),
            voteAverage = "6,1"
        ),
        Title(
            title = "Snow White",
            posterPath = "$posterPrefix/xWWg47tTfparvjK0WJNX4xL8lW2.jpg",
            thumbPath = "$highlightPrefix/2siOHQYDG7gCQB6g69g2pTZiSia.jpg",
            releaseDate = LocalDate.parse("2025-03-19"),
            voteAverage = "5,5"
        )
    )

val SampleData.PosterList: List<Poster>
    get() = listOf(
        Poster(
            id = 1,
            title = "Adolescense",
            posterPath = "$posterPrefix/3v8MSpNNk3hhadeU9XocQrQXbuk.jpg",
            releaseDate = LocalDate.parse("2025-03-13"),
            voteAverage = "7,9"
        ),
        Poster(
            id = 1,
            title = "Captain America: Brave New World",
            posterPath = "$posterPrefix/pzIddUEMWhWzfvLI3TwxUG2wGoi.jpg",
            releaseDate = LocalDate.parse("2025-02-12"),
            voteAverage = "6,1"
        ),
        Poster(
            id = 1,
            title = "Snow White",
            posterPath = "$posterPrefix/xWWg47tTfparvjK0WJNX4xL8lW2.jpg",
            releaseDate = LocalDate.parse("2025-03-19"),
            voteAverage = "5,5"
        )
    )

val SampleData.Title: Title
    get() = TitleList.last()