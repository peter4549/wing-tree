package com.duke.orca.android.kotlin.wingtree.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setDummyData()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected fun setDummyData() {

    }
}