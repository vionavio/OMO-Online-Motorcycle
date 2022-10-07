package com.viona.omo.login.data.mapper

import com.viona.omo.login.data.entity.user.getUser.User
import com.viona.omo.login.data.entity.user.getUser.UserResponseData
import com.viona.omo.login.data.entity.user.login.LoginUser
import com.viona.omo.login.data.entity.user.login.LoginUserResponseData


object UserMapper {

    fun mapLoginUserResponse(loginUser: LoginUserResponseData?): LoginUser {
        return LoginUser(
            token = loginUser?.token
        )
    }

    fun mapGetUser(user: UserResponseData?): User {
        return User(
            id = user?.id,
            username = user?.username,
            password = user?.password,
            role = user?.role
        )
    }
}