package com.viona.omo.repository.user

import com.viona.omo.data.entity.customer.register.RegisterCustomerRequest
import com.viona.omo.data.entity.driver.register.RegisterDriverRequest
import com.viona.omo.data.entity.user.getUser.User
import com.viona.omo.data.entity.user.login.LoginUser
import com.viona.omo.data.entity.user.login.LoginUserRequest
import com.viona.omo.data.entity.user.register.RegisterUserRequest
import com.viona.omo.event.StateEventManager
import com.viona.omo.network.NetworkSources
import com.viona.omo.utils.default
import org.koin.core.annotation.Single

@Single
class UserRepositoryImpl(
    private val networkSources: NetworkSources
): UserRepository {

    private val _userStateEventManager = default<LoginUser>()
    private val _registStateEventManager = default<Boolean>()
    private val _getUser = default<User>()

    override val userStateManager: StateEventManager<LoginUser>
        get() = _userStateEventManager

    override val registStateManager: StateEventManager<Boolean>
        get() = _registStateEventManager
    override val getUser: StateEventManager<User>
        get() = _getUser


    override suspend fun loginUser(request: LoginUserRequest) {
        networkSources.loginUser(request)
            .collect(_userStateEventManager)
    }

    override suspend fun registerCustomer(request: RegisterCustomerRequest) {
        networkSources.registerCustomer(request)
            .collect(_registStateEventManager)
    }

    override suspend fun registerDriver(request: RegisterDriverRequest) {
        networkSources.regisetrDriver(request)
            .collect(_registStateEventManager)
    }

    override suspend fun getUser() {
       networkSources.getUser()
           .collect(_getUser)
    }
}