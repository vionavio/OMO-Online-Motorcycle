package com.viona.omo.maps

import android.app.Application
import com.viona.koin.KoinStarter

class MainCustomer : Application() {

    override fun onCreate() {
        super.onCreate()
        KoinStarter.onCreate(this, listOf(
            HomeModule.module()
        ))
    }
}