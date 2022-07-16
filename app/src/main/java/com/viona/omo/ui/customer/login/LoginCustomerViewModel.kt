package com.viona.omo.ui.customer.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viona.omo.ui.customer.login.LoginCustomerActivity
import com.viona.omo.data.entity.customer.login.LoginCustomer
import com.viona.omo.data.entity.customer.login.LoginCustomerRequest
import com.viona.omo.event.StateEventSubscriber
import com.viona.omo.repository.customer.CustomerRepository
import com.viona.omo.utils.convertEventToSubscriber
import kotlinx.coroutines.launch
import org.koin.core.annotation.Scope


@Scope(LoginCustomerActivity::class)
class LoginCustomerViewModel(
    private val custRepository: CustomerRepository
): ViewModel() {

    private val custManager = custRepository.custStateManager

    private val custScope = custManager.createScope(viewModelScope)

    fun subscribeCustomer(subscriber: StateEventSubscriber<LoginCustomer>) {
        convertEventToSubscriber(custManager, subscriber)
    }

    fun loginCustomer(loginRequest: LoginCustomerRequest) = custScope.launch {
        custRepository.loginCustomer(loginRequest)
    }

}