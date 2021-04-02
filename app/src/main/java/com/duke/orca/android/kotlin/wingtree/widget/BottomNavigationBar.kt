package com.duke.orca.android.kotlin.wingtree.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BottomNavigationBar<VDB : ViewDataBinding>: LinearLayout {
    @get:LayoutRes
    protected abstract val layoutId: Int
    protected lateinit var viewDataBinding: VDB
    protected var idToOnSelectedHashMap = hashMapOf<@IdRes Int, () -> Unit>()

    protected abstract fun bind(viewDataBinding: VDB)

    fun setIdToSelectedHashMap(hashMap: HashMap<Int, () -> Unit>) {
        idToOnSelectedHashMap = hashMap
    }

    private fun init(viewDataBinding: VDB) {
        bind(viewDataBinding)
        addView(viewDataBinding.root)
    }

    constructor(context: Context): super(context) {
        init(inflateViewDataBinding())
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(inflateViewDataBinding())
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(inflateViewDataBinding())
    }

    private fun inflateViewDataBinding(): VDB {
        viewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            layoutId,
            null,
            false
        )

        viewDataBinding.root.layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        return viewDataBinding
    }
}