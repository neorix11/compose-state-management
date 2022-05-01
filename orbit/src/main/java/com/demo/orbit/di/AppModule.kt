package com.demo.orbit.di

import com.demo.data.MovieRepository
import com.demo.data.createHttpClient
import org.koin.dsl.module

val appModule = module {

    single { MovieRepository(createHttpClient())}
}