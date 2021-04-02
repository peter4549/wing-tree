package com.duke.orca.android.kotlin.wingtree.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.base.BaseFragment
import com.duke.orca.android.kotlin.wingtree.databinding.FragmentStudiesBinding

class StudiesFragment: BaseFragment<FragmentStudiesBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_studies

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        return view
    }
}