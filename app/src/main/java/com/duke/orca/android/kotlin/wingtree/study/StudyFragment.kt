package com.duke.orca.android.kotlin.wingtree.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.base.BaseFragment
import com.duke.orca.android.kotlin.wingtree.databinding.FragmentStudyBinding
import com.duke.orca.android.kotlin.wingtree.databinding.LayoutStudyHeaderBinding
import com.duke.orca.android.kotlin.wingtree.databinding.LayoutStudyListBinding
import com.duke.orca.android.kotlin.wingtree.main.MainViewModel

class StudyFragment: BaseFragment<FragmentStudyBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_study

    private val viewModel by activityViewModels<MainViewModel>()

    private val headerBinding: LayoutStudyHeaderBinding by lazy { binding.layoutStudyHeader }
    private val listBinding: LayoutStudyListBinding by lazy { binding.layoutStudyList }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        initializeLiveData()

        return view
    }

    private fun initializeLiveData() {
        viewModel.selectedStudy.observe(viewLifecycleOwner, {
            it ?: return@observe

            headerBinding.root.setBackgroundColor(it.color)
            headerBinding.textViewName.text = it.name
        })
    }
}