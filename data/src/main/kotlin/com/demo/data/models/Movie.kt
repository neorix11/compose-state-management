package com.demo.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie (
    val id: Int,
    val title: String,
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("post_path")
    val posterPath: String,
    val genres: List<Genre>,
    val homepage: String,
    val budget: Int,
    @SerialName("belongs_to_collection")
    val belongsToCollections: List<Collection>,
    @SerialName("original_language")
    val originalLanguage: String,
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("vote_count")
    val voteCount: Int
)

@Serializable
data class Genre(val id: Int, val name: String)

@Serializable
data class Collection(
    val id: Int,
    val name: String,
    @SerialName("post_path")
    val posterPath: String,
    @SerialName("backdrop_path")
    val backdropPath: String
)