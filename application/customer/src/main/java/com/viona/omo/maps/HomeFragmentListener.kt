package com.viona.omo.maps

import com.viona.utils.listener.FragmentListener

interface HomeFragmentListener : FragmentListener {
    fun onMessageFromActivity(message: String)
}