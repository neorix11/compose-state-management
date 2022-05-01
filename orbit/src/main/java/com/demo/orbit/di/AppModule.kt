package com.demo.orbit.di

import com.demo.data.MovieRepository
import com.demo.data.core.createHttpClient
import com.demo.orbit.MovieSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MovieSearchViewModel(get()) }

    single { MovieRepository(createHttpClient())}

}