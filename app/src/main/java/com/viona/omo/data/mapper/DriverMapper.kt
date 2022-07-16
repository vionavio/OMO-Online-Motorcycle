package com.viona.omo.data.mapper

import com.viona.omo.data.entity.driver.login.LoginDriver
import com.viona.omo.data.entity.driver.login.LoginDriverResponseData

object DriverMapper {
    fun mapLoginDriverResponse(loginCustomer: LoginDriverResponseData?): LoginDriver {
        return LoginDriver(
            token = loginCustomer?.token
        )
    }
}