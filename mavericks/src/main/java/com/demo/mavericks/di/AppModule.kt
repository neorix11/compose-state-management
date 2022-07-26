package com.demo.mavericks.di

import com.demo.data.GlobalMovieRepository
import com.demo.data.core.createHttpClient
import org.koin.dsl.module

val appModule = module {

    single { GlobalMovieRepository(createHttpClient())}

}