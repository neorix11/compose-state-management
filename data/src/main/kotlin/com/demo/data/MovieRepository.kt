package com.demo.data

import com.demo.data.models.Movie
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class MovieRepository(private val client: HttpClient) {

    private val baseUrl = "https://api.themoviedb.org/3"
    private val imageUrl = "https://image.tmdb.org/t/p"

    suspend fun fetchMovieSearch(queryString: String): List<Movie> {
       return client.use { client ->
           client.get("$baseUrl/search/movie") {
               parameter("query", queryString)
           }
       }.body()
    }

    suspend fun fetchRecommendedMovies(movieId: Int): List<Movie> {
        return client.use { client ->
            client.get("$baseUrl/movie/$movieId/recommendations")
        }.body()
    }

    suspend fun fetchSimilarMovies(movieId: Int): List<Movie> {
        return client.use { client ->
            client.get("$baseUrl/movie/$movieId/similar")
        }.body()
    }

    suspend fun fetchMovieDetail(movieId: Int): Movie {
        return client.use { client ->
            client.get("$baseUrl/movie/$movieId")
        }.body()
    }

    suspend fun fetchMovieImage(thumbnail: Boolean = false, imagePath: String) {

        val imageSize = if(thumbnail) "w500" else "original"

        return client.use { client ->
            client.get("$imageUrl/$imageSize/$imagePath")
        }.body()
    }
}