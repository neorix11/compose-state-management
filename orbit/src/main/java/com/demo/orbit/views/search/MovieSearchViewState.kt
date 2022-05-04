package com.demo.orbit.views.search

import android.os.Parcelable
import com.demo.data.core.LoadingState
import com.demo.data.models.Movie
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class MovieViewState(
    val movies: List<Movie> = emptyList(),
    val loadingState: LoadingState = LoadingState.IDLE,
    val error: String = ""
): Parcelable

sealed class MovieViewSideEffect {
}

