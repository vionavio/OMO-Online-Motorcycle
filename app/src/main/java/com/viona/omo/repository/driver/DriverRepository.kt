package com.viona.omo.repository.driver

import com.viona.omo.data.entity.driver.login.LoginDriver
import com.viona.omo.data.entity.driver.login.LoginDriverRequest
import com.viona.omo.event.StateEventManager

interface DriverRepository {

    val driverStateManager: StateEventManager<LoginDriver>

    suspend fun loginDriver(request: LoginDriverRequest)
}