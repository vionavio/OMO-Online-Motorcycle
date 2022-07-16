package com.viona.omo.repository.customer

import com.viona.omo.data.entity.customer.getcustomer.Customer
import com.viona.omo.data.entity.customer.login.LoginCustomer
import com.viona.omo.data.entity.customer.login.LoginCustomerRequest
import com.viona.omo.data.entity.customer.register.RegisterCustomerRequest
import com.viona.omo.event.StateEventManager

interface CustomerRepository {

    val custStateManager: StateEventManager<LoginCustomer>
    val registStateManager: StateEventManager<Boolean>
    val getCustomer: StateEventManager<Customer>

    suspend fun loginCustomer(request: LoginCustomerRequest)

    suspend fun registerCustomer(request: RegisterCustomerRequest)

    suspend fun getCustomer()
}