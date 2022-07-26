package com.bluelampcreative.custom.di

import com.bluelampcreative.custom.ui.views.MovieSearchViewModel
import com.bluelampcreative.domain.repositories.IMovieRepository
import com.bluelampcreative.domain.usecases.MovieSearchUC
import com.demo.data.core.createHttpClient
import com.demo.data.repositories.MovieRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

val appModule = module {

    //Repositories
    single<IMovieRepository> {  MovieRepository(createHttpClient()) }

    //Use Cases
    single { MovieSearchUC(get())}

    //View Models
    viewModel { MovieSearchViewModel(get()) }
}