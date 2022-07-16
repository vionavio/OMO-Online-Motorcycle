package com.viona.omo.data.mapper

import com.viona.omo.data.entity.customer.login.LoginCustomer
import com.viona.omo.data.entity.customer.login.LoginCustomerResponseData

object CustomerMapper {

    fun mapLoginCustomerResponse(loginCustomer: LoginCustomerResponseData?): LoginCustomer {
        return LoginCustomer(
            token = loginCustomer?.token
        )
    }
}