package com.viona.omo.ui.driver.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viona.omo.data.entity.user.getUser.User
import com.viona.omo.data.entity.user.login.LoginUser
import com.viona.omo.data.entity.user.login.LoginUserRequest
import com.viona.omo.event.StateEventSubscriber
import com.viona.omo.repository.user.UserRepository
import com.viona.omo.utils.convertEventToSubscriber
import kotlinx.coroutines.launch
import org.koin.core.annotation.Scope

@Scope(LoginDriverActivity::class)
class LoginDriverViewModel(
    private val driverRepository: UserRepository
) : ViewModel() {

    private val driverManager = driverRepository.userStateManager

    private val driverScope = driverManager.createScope(viewModelScope)

    private val getDriver = driverRepository.getUser

    fun subscribeDriver(subscriber: StateEventSubscriber<LoginUser>) {
        convertEventToSubscriber(driverManager, subscriber)
    }

    fun subscribeGetDriver(subscriber: StateEventSubscriber<User>) {
        convertEventToSubscriber(getDriver, subscriber)
    }

    fun loginDriver(request: LoginUserRequest) = driverScope.launch {
        driverRepository.loginUser(request)
    }

    fun getDriver() = driverScope.launch {
        driverRepository.getUser()
    }
}