package com.viona.omo

import android.app.Application
import com.viona.omo.di.OmoModule
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module


class OmoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(OmoModule().module)
        }
    }
}