package com.viona.omo.ui.driver

import android.os.Bundle
import com.viona.omo.data.entity.driver.login.LoginDriver
import com.viona.omo.data.entity.driver.login.LoginDriverRequest
import com.viona.omo.data.response.base.ErrorResponse
import com.viona.omo.databinding.ActivityLoginDriverBinding
import com.viona.omo.event.StateEventSubscriber
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
                LoginDriverRequest(
                    binding.etUsername.text.toString(),
                    binding.etPassword.text.toString()
                )
            )
        }
        viewModel.subscribeDriver(subscribeDriver())
    }

    private fun subscribeDriver() = object: StateEventSubscriber<LoginDriver> {
        override fun onIdle() {
            binding.tvToken.append("idle..\n")
        }

        override fun onLoading() {
            binding.tvToken.append("onLoading..\n")
        }

        override fun onFailure(throwable: ErrorResponse) {
            binding.tvToken.append("${throwable.message}...\n")
        }

        override fun onSuccess(data: LoginDriver) {
            binding.tvToken.append("$data..\n")
        }

    }
}