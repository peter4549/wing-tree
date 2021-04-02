package com.duke.orca.android.kotlin.wingtree.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB: ViewDataBinding>: Fragment() {
    @get:LayoutRes
    protected abstract val layoutId: Int
    protected lateinit var binding: VDB

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        setDummyData()
        return binding.root
    }

    protected fun setDummyData() {

    }
}