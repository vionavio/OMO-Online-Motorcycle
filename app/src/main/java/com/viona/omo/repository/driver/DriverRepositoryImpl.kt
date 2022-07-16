package com.viona.omo.repository.driver

import com.viona.omo.data.entity.driver.login.LoginDriver
import com.viona.omo.data.entity.driver.login.LoginDriverRequest
import com.viona.omo.event.StateEventManager
import com.viona.omo.network.NetworkSources
import com.viona.omo.utils.default
import org.koin.core.annotation.Single

@Single
class DriverRepositoryImpl(
    private val networkSources: NetworkSources
) : DriverRepository {

    private val _driverStateEventManager = default<LoginDriver>()

    override val driverStateManager: StateEventManager<LoginDriver>
        get() = _driverStateEventManager

    override suspend fun loginDriver(request: LoginDriverRequest) {
        networkSources.loginDriver(request)
            .collect(_driverStateEventManager)
    }
}