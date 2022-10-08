package com.viona.omo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.viona.omo.databinding.ActivitySplashBinding
import com.viona.omo.maps.MainActivity
import org.koin.androidx.scope.ScopeActivity


class SplashScreenActivity : ScopeActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    private val handler by lazy { Handler() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        handler.postDelayed({
            navigateToMain()
            finish()
        }, 3000)
    }

    private fun navigateToMain() {
        val home = Intent(this@SplashScreenActivity, MainActivity::class.java)
        startActivity(home)
    }
}