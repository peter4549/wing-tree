package com.duke.orca.android.kotlin.wingtree.base

import android.content.Context
import androidx.databinding.ViewDataBinding

open class TabFragment<VDB: ViewDataBinding>: BaseFragment<VDB>() {
    override val layoutId: Int
        get() = 0

    protected var onTabItemClickListener: OnTabItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnTabItemClickListener)
            onTabItemClickListener = context
    }
}