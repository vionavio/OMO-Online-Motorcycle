package com.viona.omo.data.mapper

import com.viona.omo.data.entity.driver.getdriver.Driver
import com.viona.omo.data.entity.driver.getdriver.DriverResponseData
import com.viona.omo.data.entity.driver.login.LoginDriver
import com.viona.omo.data.entity.driver.login.LoginDriverResponseData

object DriverMapper {
    fun mapLoginDriverResponse(loginCustomer: LoginDriverResponseData?): LoginDriver {
        return LoginDriver(
            token = loginCustomer?.token
        )
    }

    fun mapGetDriver(driver: DriverResponseData?): Driver {
        return Driver(
            id = driver?.id,
            username = driver?.username,
            password = driver?.password,
            vehicleType = driver?.vehicleType,
            vehicleRegistNumber = driver?.vehicleRegisterNumber
        )
    }
}