package com.viona.utils.listener

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun <T: ActivityListener>Fragment.findActivityListener(): T? {
    return activity as? T
}

fun <T: FragmentListener>FragmentActivity.findFragmentListener(tag: String): T? {
    return supportFragmentManager.findFragmentByTag(tag) as? T
}