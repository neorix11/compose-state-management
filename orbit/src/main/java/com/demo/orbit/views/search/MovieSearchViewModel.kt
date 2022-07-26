package com.demo.orbit.views.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.data.GlobalMovieRepository
import com.demo.data.core.LoadingState
import com.demo.data.core.Outcome
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MovieSearchViewModel(
    private val globalMovieRepository: GlobalMovieRepository,
    private val savedStateHandle: SavedStateHandle
): ContainerHost<MovieViewState, MovieViewSideEffect>, ViewModel() {

    override val container = container<MovieViewState, MovieViewSideEffect>(
        initialState = MovieViewState(),
        savedStateHandle = savedStateHandle
    )

    fun performMovieSearch(query: String) = intent {
        reduce { state.copy(loadingState = LoadingState.LOADING) }
        viewModelScope.launch {
            when(val outcome = globalMovieRepository.fetchMovieSearch(query)) {
                is Outcome.Success -> {
                    reduce { state.copy(
                        movies = outcome.value.results,
                        loadingState = LoadingState.LOADED,
                        error = ""
                        ) }
                }
                is Outcome.Error -> {
                    reduce { state.copy(
                        movies = emptyList(),
                        loadingState = LoadingState.ERROR,
                        error = outcome.error.toString()
                    ) }
                }
            }
        }
    }
}