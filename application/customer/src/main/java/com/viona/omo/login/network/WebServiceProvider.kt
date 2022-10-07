package com.viona.omo.login.network

import org.koin.core.annotation.Single

@Single
class WebServiceProvider {

    fun get(): WebServices {
        return RemoteService.build()
    }
}