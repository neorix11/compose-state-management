package com.demo.mavericks.views.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.MavericksViewInternalViewModel
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.Success
import com.demo.data.MovieRepository
import com.demo.data.core.LoadingState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MovieSearchViewModel(
    movieViewState: MovieViewState
): MavericksViewModel<MovieViewState>(movieViewState), KoinComponent {

    private val repository: MovieRepository by inject()

    fun performMovieSearch(query: String) = withState { state ->
        if(state.loadingState == LoadingState.LOADING) return@withState

        suspend {
            repository.fetchMavericksMovieSearch(query)
        }.execute {
            when(it) {
                is Success -> {
                    copy(
                        request = it,
                        movies = it().results,
                        loadingState = LoadingState.LOADED,
                    )
                }
                is Fail -> {
                    copy(
                        loadingState = LoadingState.ERROR,
                        error = it.toString()
                    )
                }
                else -> {
                    state
                }
            }
        }
    }

}