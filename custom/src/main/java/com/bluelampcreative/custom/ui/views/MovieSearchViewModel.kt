package com.bluelampcreative.custom.ui.views

import androidx.lifecycle.viewModelScope
import com.bluelampcreative.custom.core.BaseViewModel
import com.bluelampcreative.custom.ui.state.reducer
import com.bluelampcreative.domain.models.Movie
import com.bluelampcreative.domain.models.Outcome
import com.bluelampcreative.domain.state.LoadingState
import com.bluelampcreative.domain.state.MovieSearchViewState
import com.bluelampcreative.domain.usecases.MovieSearchUC
import kotlinx.coroutines.launch

class MovieSearchViewModel(
    private val movieSearch: MovieSearchUC
): BaseViewModel<MovieSearchViewState>() {

    override val state = reducer(
        initialState = MovieSearchViewState(),
        reduceState = ::reduceState
    )

    override fun reduceState(currentState: MovieSearchViewState, action: Any): MovieSearchViewState {
        return when(action) {
            is MovieSearchViewAction.UpdateMovieSearchResults -> {
                currentState.copy(
                    loadingState = LoadingState.Loaded,
                    searchResults = action.results
                )
            }
            is MovieSearchViewAction.SetLoadingState -> {
                currentState.copy(loadingState = action.loadingState)
            }
            else -> currentState
        }
    }

    fun fetchData(queryString: String) {
        state.handleAction(MovieSearchViewAction.SetLoadingState(LoadingState.Loading))
        viewModelScope.launch {
            when(val response = movieSearch(queryString)) {
                is Outcome.Success -> {
                    state.handleAction(MovieSearchViewAction.UpdateMovieSearchResults(response.value.results))
                }
                is Outcome.Error -> {
                    println("THERE WAS AN ERROR")
                }
            }
        }
    }



    sealed class MovieSearchViewAction {
        class UpdateMovieSearchResults(val results: List<Movie>)
        class SetLoadingState(val loadingState: LoadingState)
    }
}