package com.viona.omo.data.mapper

import com.viona.omo.data.entity.customer.getcustomer.Customer
import com.viona.omo.data.entity.customer.getcustomer.CustomerResponseData
import com.viona.omo.data.entity.customer.login.LoginCustomer
import com.viona.omo.data.entity.customer.login.LoginCustomerResponseData

object CustomerMapper {

    fun mapLoginCustomerResponse(loginCustomer: LoginCustomerResponseData?): LoginCustomer {
        return LoginCustomer(
            token = loginCustomer?.token
        )
    }

    fun mapGetCustomer(customer: CustomerResponseData?): Customer {
        return Customer(
            id = customer?.id,
            username = customer?.username,
            password = customer?.password
        )
    }
}