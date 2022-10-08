package com.viona.omo.maps

import android.location.Location
import android.os.Bundle
import com.viona.navigation.attachFragment
import com.viona.navigation.replaceFragment
import com.viona.omo.databinding.ActivityMainBinding
import com.viona.search.SearchLocationFragment
import com.viona.utils.BindingActivity
import com.viona.utils.listener.findFragmentListener

class MainActivity : BindingActivity<ActivityMainBinding>(), MainActivityListener {
    override fun inflateBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var homeTag: String

    override fun onCreateBinding(savedInstanceState: Bundle?) {
        homeTag = supportFragmentManager.attachFragment(binding.mainFrame, HomeFragment::class)
        binding.btnSearch.setOnClickListener {
            navigateToSearchFragment()
        }
    }

    private fun navigateToSearchFragment() {
        supportFragmentManager.replaceFragment(binding.mainFrame, SearchLocationFragment::class)
    }

    private fun onLocation(data: Location) {
        val instance = findFragmentListener<HomeFragmentListener>(homeTag)
        instance?.onMessageFromActivity("starting...")
    }

    override fun onLocationResult(data: Location) {
        onLocation(data)
    }
}