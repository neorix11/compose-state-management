package com.demo.orbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.orbit.ui.theme.ComposeStateManagementTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MovieSearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStateManagementTheme {
                // A surface container using the 'background' color from the theme
               SearchButton(buttonClick = {
                   viewModel.searchForMovie("batman")
               })
            }
        }
    }
}

@Composable
fun SearchButton(buttonClick: () -> Unit) {
    Button(onClick = { buttonClick() }) {
        Text(text = "CLICK ME")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStateManagementTheme {
        SearchButton(buttonClick = {})
    }
}