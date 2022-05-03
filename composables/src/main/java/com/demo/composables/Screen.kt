package com.demo.composables

sealed class Screen(val title: String) {
    object MovieSearch: Screen("MovieSearch")
    object WatchList: Screen("WatchList")
}