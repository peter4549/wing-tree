package com.duke.orca.android.kotlin.wingtree.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.databinding.MainBottomNavigationBarBinding

class MainBottomNavigationBar: BottomNavigationBar<MainBottomNavigationBarBinding> {

    constructor(context: Context): super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override val layoutId: Int
        get() = R.layout.main_bottom_navigation_bar

    override fun bind(viewDataBinding: MainBottomNavigationBarBinding) {
        viewDataBinding.mainBottomNavigationBar = this
    }

    fun onViewClick(view: View) {
        idToOnSelectedHashMap[view.id]?.invoke()
    }
}