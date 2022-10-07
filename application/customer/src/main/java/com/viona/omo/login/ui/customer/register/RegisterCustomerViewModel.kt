package com.viona.omo.login.ui.customer.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viona.omo.login.data.entity.customer.register.RegisterCustomerRequest
import com.viona.omo.login.event.StateEventSubscriber
import com.viona.omo.login.repository.user.UserRepository
import com.viona.omo.login.utils.convertEventToSubscriber
import kotlinx.coroutines.launch
import org.koin.core.annotation.Scope

@Scope(RegisterCustomerActivity::class)
class RegisterCustomerViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val customerManager = userRepository.registStateManager

    private val customerScope = customerManager.createScope(viewModelScope)

    fun subscribeCustomer(subscriber: StateEventSubscriber<Boolean>) {
        convertEventToSubscriber(customerManager, subscriber)
    }

    fun registerCustomer(request: RegisterCustomerRequest) = customerScope.launch {
        userRepository.registerCustomer(request)
    }
}