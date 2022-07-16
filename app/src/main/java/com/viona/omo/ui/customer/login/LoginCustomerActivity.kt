package com.viona.omo.ui.customer.login

import android.content.Intent
import android.os.Bundle
import com.viona.omo.data.entity.customer.login.LoginCustomer
import com.viona.omo.data.entity.customer.login.LoginCustomerRequest
import com.viona.omo.data.response.base.ErrorResponse
import com.viona.omo.databinding.ActivityLoginCustomerBinding
import com.viona.omo.event.StateEventSubscriber
import com.viona.omo.ui.customer.register.RegisterCustomerActivity
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginCustomerActivity : ScopeActivity() {

    private val viewModel: LoginCustomerViewModel by viewModel()
    private val binding: ActivityLoginCustomerBinding by lazy {
        ActivityLoginCustomerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            viewModel.loginCustomer(
                LoginCustomerRequest(
                    binding.etUsername.text.toString(),
                    binding.etPassword.text.toString()
                )
            )
        }
        binding.btnRegisterCust.setOnClickListener {
            val intent = Intent(this, RegisterCustomerActivity::class.java)
            startActivity(intent)
        }

        viewModel.subscribeCustomer(subscribeCustomer())
    }

    private fun subscribeCustomer() = object : StateEventSubscriber<LoginCustomer> {
        override fun onIdle() {
            binding.tvToken.append("idle..\n")
        }

        override fun onLoading() {
            binding.tvToken.append("onLoading..\n")
        }

        override fun onFailure(throwable: ErrorResponse) {
            binding.tvToken.append("${throwable.message}...\n")
        }

        override fun onSuccess(data: LoginCustomer) {
            binding.tvToken.append("$data..\n")
        }
    }
}