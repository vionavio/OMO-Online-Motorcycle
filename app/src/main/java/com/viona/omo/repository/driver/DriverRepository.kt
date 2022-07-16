package com.viona.omo.repository.driver

import com.viona.omo.data.entity.driver.getdriver.Driver
import com.viona.omo.data.entity.driver.login.LoginDriver
import com.viona.omo.data.entity.driver.login.LoginDriverRequest
import com.viona.omo.data.entity.driver.register.RegisterDriverRequest
import com.viona.omo.event.StateEventManager

interface DriverRepository {

    val driverStateManager: StateEventManager<LoginDriver>
    val registDriver: StateEventManager<Boolean>
    val getDriver: StateEventManager<Driver>

    suspend fun loginDriver(request: LoginDriverRequest)

    suspend fun registerDriver(request: RegisterDriverRequest)

    suspend fun getDriver()
}