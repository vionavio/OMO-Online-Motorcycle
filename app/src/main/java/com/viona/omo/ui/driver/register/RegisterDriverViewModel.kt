package com.viona.omo.ui.driver.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.viona.omo.data.entity.driver.register.RegisterDriverRequest
import com.viona.omo.event.StateEventSubscriber
import com.viona.omo.repository.driver.DriverRepository
import com.viona.omo.utils.convertEventToSubscriber
import kotlinx.coroutines.launch
import org.koin.core.annotation.Scope

@Scope(RegisterDriverActivity::class)
class RegisterDriverViewModel(
    private val driverRepository: DriverRepository
) : ViewModel() {

    private val driverManager = driverRepository.registDriver
    private val driverScope = driverManager.createScope(viewModelScope)

    fun subscribeDriver(subscriber: StateEventSubscriber<Boolean>) {
        convertEventToSubscriber(driverManager, subscriber)
    }

    fun registerDriver(request: RegisterDriverRequest) = driverScope.launch {
        driverRepository.registerDriver(request)
    }
}