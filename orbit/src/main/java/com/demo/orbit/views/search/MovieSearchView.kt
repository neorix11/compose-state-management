package com.demo.orbit.views.search

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.demo.composables.components.MovieDisplayList
import com.demo.composables.components.MovieListItem
import com.demo.composables.components.MovieSearchBar
import com.demo.data.core.LoadingState
import com.demo.data.models.Movie
import org.koin.androidx.compose.viewModel

@Composable
fun MovieSearchView(
    movieSelected: (movie: Movie) -> Unit
) {

    val context = LocalContext.current

    val viewModel by viewModel<MovieSearchViewModel>()
    val state = viewModel.container.stateFlow.collectAsState().value

    Column {
        MovieSearchBar{ searchTerm ->
            viewModel.performMovieSearch(searchTerm)
        }
        if(state.loadingState == LoadingState.ERROR) {
            Toast.makeText(
                context,
                "There was an error: ${state.error}",
                Toast.LENGTH_SHORT)
                .show()
        } else {
//            MovieDisplayList(state.movies) { movie ->
//                movieSelected(movie)
//            }
        }
    }

}