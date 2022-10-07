package com.viona.profile

import android.os.Bundle
import com.viona.profile.databinding.FragmentProfileBinding
import com.viona.utils.BindingFragment

class ProfileFragment : BindingFragment<FragmentProfileBinding>() {
    override fun inflateBinding(): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun onCreateBinding(savedInstanceState: Bundle?) {

    }
}