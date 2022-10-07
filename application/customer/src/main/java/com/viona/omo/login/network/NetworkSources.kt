package com.viona.omo.login.network

import com.viona.omo.login.data.entity.customer.register.RegisterCustomerRequest
import com.viona.omo.login.data.entity.driver.register.RegisterDriverRequest
import com.viona.omo.login.data.entity.user.getUser.User
import com.viona.omo.login.data.entity.user.login.LoginUser
import com.viona.omo.login.data.entity.user.login.LoginUserRequest
import com.viona.omo.login.data.mapper.UserMapper
import com.viona.omo.login.utils.FlowState
import com.viona.omo.login.utils.Params
import org.koin.core.annotation.Single

@Single
class NetworkSources(private val webServicesProvider: WebServiceProvider) {
    suspend fun loginUser(loginUser: LoginUserRequest): FlowState<LoginUser> {
        val params = hashMapOf(
            Params.key_username to loginUser.username,
            Params.key_password to loginUser.password
        )

        return networkHandling(
            callApi = { webServicesProvider.get().loginUser(params) },
            processResponse = { UserMapper.mapLoginUserResponse(it?.data) }
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

    suspend fun getUser(): FlowState<User> {
        return networkHandling(
            callApi = { webServicesProvider.get().getUser(RemoteService.EndPoint.TOKEN_LOGIN_USER)},
            processResponse = {UserMapper.mapGetUser(it?.data)}
        )
    }

}