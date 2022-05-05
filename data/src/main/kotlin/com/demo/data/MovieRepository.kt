package com.demo.data

import com.demo.data.core.Outcome
import com.demo.data.models.Movie
import com.demo.data.models.MovieSearchResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class MovieRepository(private val client: HttpClient) {

    private val baseUrl = "https://api.themoviedb.org/3"
    private val imageUrl = "https://image.tmdb.org/t/p"

    suspend fun fetchMovieSearch(queryString: String): Outcome<MovieSearchResponse> {
       return Outcome.tryBlock {
               client.get("$baseUrl/search/movie") {
                   parameter("query", queryString)
                   parameter("api_key", "392769cae8cb43b9e9b953eb0cec86bf")
           }.body()
       }
    }

    suspend fun fetchMavericksMovieSearch(queryString: String): MovieSearchResponse {

        return client.get("$baseUrl/search/movie") {
                parameter("query", queryString)
                parameter("api_key", "392769cae8cb43b9e9b953eb0cec86bf")
            }.body()
    }

    suspend fun fetchRecommendedMovies(movieId: Int): Outcome<List<Movie>> {
        return Outcome.tryBlock {
            client.use { client ->
                client.get("$baseUrl/movie/$movieId/recommendations"){
                    parameter("api_key", "392769cae8cb43b9e9b953eb0cec86bf")
                }
            }.body()
        }
    }

    suspend fun fetchSimilarMovies(movieId: Int): Outcome<List<Movie>> {
        return Outcome.tryBlock {
            client.use { client ->
                client.get("$baseUrl/movie/$movieId/similar") {
                    parameter("api_key", "392769cae8cb43b9e9b953eb0cec86bf")
                }
            }.body()
        }
    }

    suspend fun fetchMovieDetail(movieId: Int): Outcome<Movie> {
        return Outcome.tryBlock {
            client.use { client ->
                client.get("$baseUrl/movie/$movieId") {
                    parameter("api_key", "392769cae8cb43b9e9b953eb0cec86bf")
                }
            }.body()
        }
    }
}