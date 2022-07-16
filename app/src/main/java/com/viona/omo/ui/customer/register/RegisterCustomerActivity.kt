package com.viona.omo.ui.customer.register

import android.os.Bundle
import com.viona.omo.data.entity.customer.register.RegisterCustomerRequest
import com.viona.omo.data.response.base.ErrorResponse
import com.viona.omo.databinding.ActivityRegisterCustomerBinding
import com.viona.omo.event.StateEventSubscriber
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterCustomerActivity : ScopeActivity() {
    private val viewModel: RegisterCustomerViewModel by viewModel()

    private val binding: ActivityRegisterCustomerBinding by lazy {
        ActivityRegisterCustomerBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegisterCust.setOnClickListener {
            viewModel.registerCustomer(
                RegisterCustomerRequest(
                    binding.etUsername.text.toString(),
                    binding.etPassword.text.toString()
                )
            )
        }

        viewModel.subscribeCustomer(subscribeCustomer())
    }

    private fun subscribeCustomer() = object : StateEventSubscriber<Boolean> {
        override fun onIdle() {
            binding.tvToken.append("idle..\n")
        }

        override fun onLoading() {
            binding.tvToken.append("onLoading..\n")
        }

        override fun onFailure(throwable: ErrorResponse) {
            binding.tvToken.append("${throwable.message}...\n")
        }

        override fun onSuccess(data: Boolean) {
            binding.tvToken.append("$data..\n")
        }
    }
}