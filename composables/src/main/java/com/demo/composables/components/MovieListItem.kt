package com.demo.composables.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.demo.composables.R
import com.demo.data.models.Movie

@Composable
fun MovieListItem(
    movieData: Movie,
    onClick: (movieId: Int) -> Unit
){
    Card(
        Modifier
            .padding(4.dp)
            .fillMaxWidth(),
    elevation = 4.dp) {
        Row(Modifier.clickable {
            onClick(movieData.id)
        }) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://image.tmdb.org/t/p/w500${movieData.posterPath}")
                    .crossfade(true)
                    .build(),
                contentDescription = "Movie Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(2.dp))
            )

            Column { Text(movieData.title) }
        }
    }
}