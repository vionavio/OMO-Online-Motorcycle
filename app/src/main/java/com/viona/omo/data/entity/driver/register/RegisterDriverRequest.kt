package com.viona.omo.data.entity.driver.register

data class RegisterDriverRequest(
    val username: String = "",
    val password: String = "",
    val vehicleType: String = "",
    val vehicleRegistNumber: String = ""
)