package com.viona.omo.login.data.entity.driver.register

data class RegisterDriverRequest(
    val username: String = "",
    val password: String = "",
    val vehicleType: String = "",
    val vehicleRegistNumber: String = ""
)