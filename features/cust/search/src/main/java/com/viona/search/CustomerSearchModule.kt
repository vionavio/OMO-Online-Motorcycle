package com.viona.search

import com.viona.locationapi.LocationWebServices
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CustomerSearchModule {

    fun modules() = module {
        single { LocationWebServices.build() }
        viewModel { SearchLocationViewModel(get()) }
    }
}