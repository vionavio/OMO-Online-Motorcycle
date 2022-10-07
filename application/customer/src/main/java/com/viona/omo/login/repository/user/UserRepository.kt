package com.viona.omo.login.repository.user

import com.viona.omo.login.data.entity.customer.register.RegisterCustomerRequest
import com.viona.omo.login.data.entity.driver.register.RegisterDriverRequest
import com.viona.omo.login.data.entity.user.getUser.User
import com.viona.omo.login.data.entity.user.login.LoginUser
import com.viona.omo.login.data.entity.user.login.LoginUserRequest
import com.viona.omo.login.event.StateEventManager

interface UserRepository {

    val userStateManager: StateEventManager<LoginUser>
    val registStateManager: StateEventManager<Boolean>
    val getUser: StateEventManager<User>

    suspend fun loginUser(request: LoginUserRequest)

    suspend fun registerCustomer(request: RegisterCustomerRequest)
    suspend fun registerDriver(request: RegisterDriverRequest)

    suspend fun getUser()
}