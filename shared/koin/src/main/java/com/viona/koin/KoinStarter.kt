package com.viona.koin

import android.content.Context
import com.viona.auth.AuthModule
import com.viona.core.CoreModules
import com.viona.network.NetworkModule
import com.viona.profile.CustomerProfileModule
import com.viona.search.CustomerSearchModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

object KoinStarter {

    fun onCreate(context: Context, featureModule: List<Module> = emptyList()) {
        val modules = listOf(
            CoreModules.modules(),
            NetworkModule.modules(),
            AuthModule.modules(),
            CustomerSearchModule.modules(),
            CustomerProfileModule.module()
        ) + featureModule
        startKoin {
            androidContext(context)
            modules(modules)
        }
    }
}