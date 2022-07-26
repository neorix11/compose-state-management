package com.bluelampcreative.domain.state

import com.bluelampcreative.domain.models.Movie

data class MovieSearchViewState(
    val queryString: String = "",
    val searchResults: List<Movie> = emptyList(),
    val loadingState: LoadingState = LoadingState.Idle,
    val error: String = ""
)