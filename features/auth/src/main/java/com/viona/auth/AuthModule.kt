package com.viona.auth

import org.koin.dsl.module

object AuthModule {

    fun modules() = module {
        single { AuthWebServicesProvider.providedWebServices() }
    }
}