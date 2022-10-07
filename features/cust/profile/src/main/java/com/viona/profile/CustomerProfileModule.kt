package com.viona.profile

import com.viona.navigation.ProfileFragmentConnector

object CustomerProfileModule {
    fun module() = org.koin.dsl.module {
        single<ProfileFragmentConnector> { ProfileFragmentConnectorProvider() }
    }
}