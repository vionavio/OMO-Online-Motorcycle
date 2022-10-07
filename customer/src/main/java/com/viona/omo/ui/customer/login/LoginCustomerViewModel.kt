package com.viona.omo.ui.customer.login

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


@Scope(LoginCustomerActivity::class)
class LoginCustomerViewModel(
    private val custRepository: UserRepository
): ViewModel() {

    private val custManager = custRepository.userStateManager
    private val getCustomer = custRepository.getUser

    private val custScope = custManager.createScope(viewModelScope)

    fun subscribeCustomer(subscriber: StateEventSubscriber<LoginUser>) {
        convertEventToSubscriber(custManager, subscriber)
    }

    fun subscribeGetCustomer(subscriber: StateEventSubscriber<User>) {
        convertEventToSubscriber(getCustomer, subscriber)
    }

    fun loginCustomer(loginRequest: LoginUserRequest) = custScope.launch {
        custRepository.loginUser(loginRequest)
    }

    fun getCustomer() = custScope.launch {
        custRepository.getUser()
    }

}