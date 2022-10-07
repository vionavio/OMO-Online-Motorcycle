package com.viona.profile

import androidx.fragment.app.Fragment
import com.viona.navigation.ProfileFragmentConnector
import com.viona.profile.ProfileFragment
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class ProfileFragmentConnectorProvider : ProfileFragmentConnector {
    override val profileFragment: KClass<Fragment>
        get() = ProfileFragment::class as KClass<Fragment>
}