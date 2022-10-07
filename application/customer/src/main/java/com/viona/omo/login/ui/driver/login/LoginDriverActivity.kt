package com.viona.omo.login.ui.driver.login

import android.content.Intent
import android.os.Bundle
import com.viona.omo.login.data.entity.user.getUser.User
import com.viona.omo.login.data.entity.user.login.LoginUser
import com.viona.omo.login.data.entity.user.login.LoginUserRequest
import com.viona.omo.login.data.response.base.ErrorResponse
import com.viona.omo.databinding.ActivityLoginDriverBinding
import com.viona.omo.login.event.StateEventSubscriber
import com.viona.omo.login.ui.driver.register.RegisterDriverActivity
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginDriverActivity : ScopeActivity() {

    private val viewModel: LoginDriverViewModel by viewModel()
    private val binding: ActivityLoginDriverBinding by lazy {
        ActivityLoginDriverBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            viewModel.loginDriver(
                LoginUserRequest(
                    binding.etUsername.text.toString(),
                    binding.etPassword.text.toString()
                )
            )
        }
        binding.btnRegisterDriver.setOnClickListener {
            val intent = Intent(this, RegisterDriverActivity::class.java)
            startActivity(intent)
        }
        viewModel.subscribeDriver(subscribeDriver())
        
        binding.btnGetDriver.setOnClickListener { 
            viewModel.getDriver()
        }
        viewModel.subscribeGetDriver(subscribeGetDriver())
    }

    private fun subscribeDriver() = object: StateEventSubscriber<LoginUser> {
        override fun onIdle() {
            binding.tvToken.append("idle..\n")
        }

        override fun onLoading() {
            binding.tvToken.append("onLoading..\n")
        }

        override fun onFailure(throwable: ErrorResponse) {
            binding.tvToken.append("${throwable.message}...\n")
        }

        override fun onSuccess(data: LoginUser) {
            binding.tvToken.append("$data..\n")
        }

    }

    private fun subscribeGetDriver() = object : StateEventSubscriber<User> {
        override fun onIdle() {
            binding.tvDriver.append("idle..\n")
        }

        override fun onLoading() {
            binding.tvDriver.append("loading..\n")
        }

        override fun onFailure(throwable: ErrorResponse) {
            binding.tvDriver.append("${throwable.message}..\n")
        }

        override fun onSuccess(data: User) {
            binding.tvDriver.append("$data..\n")
        }

    }
}