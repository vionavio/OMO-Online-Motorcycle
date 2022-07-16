package com.viona.omo.network

import com.viona.omo.data.entity.customer.getcustomer.Customer
import com.viona.omo.data.entity.customer.login.LoginCustomer
import com.viona.omo.data.entity.customer.login.LoginCustomerRequest
import com.viona.omo.data.entity.customer.register.RegisterCustomerRequest
import com.viona.omo.data.entity.driver.login.LoginDriver
import com.viona.omo.data.entity.driver.login.LoginDriverRequest
import com.viona.omo.data.entity.driver.register.RegisterDriverRequest
import com.viona.omo.data.mapper.CustomerMapper
import com.viona.omo.data.mapper.DriverMapper
import com.viona.omo.data.response.CustomerResponse
import com.viona.omo.utils.FlowState
import com.viona.omo.utils.Params
import org.koin.core.annotation.Single

@Single
class NetworkSources(private val webServicesProvider: WebServiceProvider) {
    suspend fun loginCustomer(loginRequest: LoginCustomerRequest): FlowState<LoginCustomer> {
        val params = hashMapOf(
            Params.key_username to loginRequest.username,
            Params.key_password to loginRequest.password
        )

        return networkHandling(
            callApi = { webServicesProvider.get().loginCustomer(params) },
            processResponse = { CustomerMapper.mapLoginCustomerResponse(it?.data) }
        )
    }

    suspend fun loginDriver(request: LoginDriverRequest): FlowState<LoginDriver> {
        val param = hashMapOf(
            Params.key_username to request.username,
            Params.key_password to request.password
        )

        return networkHandling(
            callApi = { webServicesProvider.get().loginDriver(param) },
            processResponse = { DriverMapper.mapLoginDriverResponse(it?.data) }
        )
    }

    suspend fun registerCustomer(request: RegisterCustomerRequest): FlowState<Boolean> {
        val param = hashMapOf(
            Params.key_username to request.username,
            Params.key_password to request.password
        )
        return networkHandling(
            callApi = { webServicesProvider.get().registerCustomer(param) },
            processResponse = { it!!.data }
        )
    }

    suspend fun regisetrDriver(request: RegisterDriverRequest): FlowState<Boolean> {
        val param = hashMapOf(
            Params.key_username to request.username,
            Params.key_password to request.password,
            Params.key_vehicle_type to request.vehicleType,
            Params.key_vehicle_regist_number to request.vehicleRegistNumber
        )
        return networkHandling(
            callApi = { webServicesProvider.get().registerDriver(param) },
            processResponse = { it!!.data }
        )
    }

    suspend fun getCustomer(): FlowState<Customer> {
        return networkHandling(
            callApi = { webServicesProvider.get().getCustomer(RemoteService.EndPoint.TOKEN_LOGIN_CUSTOMER)},
            processResponse = {CustomerMapper.mapGetCustomer(it?.data)}
        )
    }
}