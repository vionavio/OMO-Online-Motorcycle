package com.viona.omo.network

import org.koin.core.annotation.Single

@Single
class WebServiceProvider {

    fun get(): WebServices {
        return RemoteService.build()
    }
}