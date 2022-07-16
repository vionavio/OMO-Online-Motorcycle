package com.viona.omo.ui.driver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viona.omo.data.entity.driver.login.LoginDriver
import com.viona.omo.data.entity.driver.login.LoginDriverRequest
import com.viona.omo.event.StateEventSubscriber
import com.viona.omo.repository.driver.DriverRepository
import com.viona.omo.utils.convertEventToSubscriber
import kotlinx.coroutines.launch
import org.koin.core.annotation.Scope

@Scope(LoginDriverActivity::class)
class LoginDriverViewModel(
    private val driverRepository: DriverRepository
) : ViewModel() {

    private val driverManager = driverRepository.driverStateManager

    private val driverScope = driverManager.createScope(viewModelScope)

    fun subscribeDriver(subscriber: StateEventSubscriber<LoginDriver>) {
        convertEventToSubscriber(driverManager, subscriber)
    }

    fun loginDriver(request: LoginDriverRequest) = driverScope.launch {
        driverRepository.loginDriver(request)
    }
}