package com.viona.auth

object AuthWebServicesProvider {

    fun providedWebServices(): AuthWebServices {
        return AuthWebServices.build()
    }
}