package com.demo.orbit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.data.MovieRepository
import com.demo.data.core.Outcome
import kotlinx.coroutines.launch
import java.lang.Error

class MovieSearchViewModel(private val movieRepository: MovieRepository): ViewModel() {

    fun searchForMovie(queryString: String) {
        viewModelScope.launch {
            when(val outcome = movieRepository.fetchMovieSearch(queryString)) {
                is Outcome.Success -> {
                    println("List of movies: ${outcome.value}")
                }
                is Outcome.Error -> {
                    println("There was an error ${outcome.error}")
                }
            }
        }
    }

}