package com.viona.omo.ui.customer.home

import android.os.Bundle
import com.viona.omo.databinding.ActivityHomeCustomerBinding
import org.koin.androidx.scope.ScopeActivity

class HomeCustomerActivity : ScopeActivity() {

    private val binding:ActivityHomeCustomerBinding by lazy {
        ActivityHomeCustomerBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}