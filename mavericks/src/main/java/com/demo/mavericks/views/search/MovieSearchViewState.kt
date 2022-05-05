package com.demo.mavericks.views.search

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.demo.data.core.LoadingState
import com.demo.data.models.Movie
import com.demo.data.models.MovieSearchResponse

data class MovieViewState(
    val request: Async<MovieSearchResponse> = Uninitialized,
    val movies: List<Movie> = emptyList(),
    val loadingState: LoadingState = LoadingState.IDLE,
    val error: String = ""
): MavericksState

sealed class MovieViewSideEffect {
}

