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
import com.demo.composables.components.MovieListItem
import org.koin.androidx.compose.viewModel

@Composable
fun MovieSearchView() {
    
    val viewModel by viewModel<MovieSearchViewModel>()
    val state = viewModel.container.stateFlow.collectAsState()

    val context = LocalContext.current

    Column {
        Button(onClick = { viewModel.performMovieSearch("batman") }) {
            Text(text = "SEARCH")
        }

        LazyColumn(content = {
            items(items = state.value.movies) { item ->
                MovieListItem(movieData = item) {
                    Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}