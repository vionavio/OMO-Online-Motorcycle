package com.viona.omo.ui.driver.register

import android.os.Bundle
import com.viona.omo.data.entity.driver.register.RegisterDriverRequest
import com.viona.omo.data.response.base.ErrorResponse
import com.viona.omo.databinding.ActivityRegisterDriverBinding
import com.viona.omo.event.StateEventSubscriber
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterDriverActivity : ScopeActivity() {

    private val viewModel: RegisterDriverViewModel by viewModel()
    private val binding: ActivityRegisterDriverBinding by lazy {
        ActivityRegisterDriverBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegisterDriver.setOnClickListener {
            viewModel.registerDriver(
                RegisterDriverRequest(
                    binding.etUsername.text.toString(),
                    binding.etPassword.text.toString(),
                    binding.tvVehicleType.text.toString(),
                    binding.tvVehicleRegistNum.text.toString()
                )
            )
        }
        viewModel.subscribeDriver(subscribeDriver())
    }

    private fun subscribeDriver() = object : StateEventSubscriber<Boolean> {
        override fun onIdle() {
            binding.tvResponse.append("idle..\n")
        }

        override fun onLoading() {
            binding.tvResponse.append("onLoading..\n")
        }

        override fun onFailure(throwable: ErrorResponse) {
            binding.tvResponse.append("${throwable.message}...\n")
        }

        override fun onSuccess(data: Boolean) {
            binding.tvResponse.append("$data..\n")
        }
    }
}