package com.viona.omo.repository.customer

import com.viona.omo.data.entity.customer.login.LoginCustomer
import com.viona.omo.data.entity.customer.login.LoginCustomerRequest
import com.viona.omo.data.entity.customer.register.RegisterCustomerRequest
import com.viona.omo.event.StateEventManager
import com.viona.omo.network.NetworkSources
import com.viona.omo.utils.default
import org.koin.core.annotation.Single

@Single
class CustomerRepositoryImpl(
    private val networkSources: NetworkSources
): CustomerRepository {

    private val _userStateEventManager = default<LoginCustomer>()
    private val _registStateEventManager = default<Boolean>()

    override val custStateManager: StateEventManager<LoginCustomer>
        get() = _userStateEventManager

    override val registStateManager: StateEventManager<Boolean>
        get() = _registStateEventManager


    override suspend fun loginCustomer(request: LoginCustomerRequest) {
        networkSources.loginCustomer(request)
            .collect(_userStateEventManager)
    }

    override suspend fun registerCustomer(request: RegisterCustomerRequest) {
        networkSources.registerCustomer(request)
            .collect(_registStateEventManager)
    }
}