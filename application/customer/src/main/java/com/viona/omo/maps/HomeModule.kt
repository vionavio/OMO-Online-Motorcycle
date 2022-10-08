package com.viona.omo.maps

import org.koin.androidx.viewmodel.dsl.viewModel

object HomeModule {
    fun module() = org.koin.dsl.module {
        single<HomeRepository> { HomeRepositoryImpl(get()) }

        viewModel { HomeViewModel(get()) }
    }
}