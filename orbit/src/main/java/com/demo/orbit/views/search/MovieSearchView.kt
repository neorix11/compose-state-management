package com.demo.orbit.views.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.koin.androidx.compose.viewModel

@Composable
fun MovieSearchView() {
    
    val viewModel by viewModel<MovieSearchViewModel>()
    val state = viewModel.container.stateFlow.collectAsState()

    Column {
        Button(onClick = { viewModel.performMovieSearch("batman") }) {
            Text(text = "SEARCH")
        }

        LazyColumn(content = {
            items(items = state.value.movies) { item ->
                Text(text = "This is a movie ${item.title}")
            }
        })
    }

}