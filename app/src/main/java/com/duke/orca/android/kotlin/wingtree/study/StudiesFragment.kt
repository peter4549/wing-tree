package com.duke.orca.android.kotlin.wingtree.study

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.base.TabFragment
import com.duke.orca.android.kotlin.wingtree.databinding.FragmentStudiesBinding
import com.duke.orca.android.kotlin.wingtree.study.adapter.StudyAdapter
import com.duke.orca.android.kotlin.wingtree.study.data.Study
import com.duke.orca.android.kotlin.wingtree.util.LayoutManagerWrapper

class StudiesFragment: TabFragment<FragmentStudiesBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_studies

    private val studyAdapter = StudyAdapter {
        onTabItemClickListener?.onTabItemClick(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LayoutManagerWrapper(requireContext(), 2)
            adapter = studyAdapter
        }

        setDummyData()

        return view
    }

    override fun setDummyData() {
        val list = listOf(
            Study(
                bookmark = false,
                color = Color.RED,
                id = "0",
                name = "Android",
                users = arrayListOf()
            ),
            Study(
                bookmark = true,
                color = Color.GREEN,
                id = "1",
                name = "OPIc",
                users = arrayListOf()
            ),
            Study(
                bookmark = true,
                color = Color.BLUE,
                id = "2",
                name = "Cook",
                users = arrayListOf()
            )
        )

        studyAdapter.submitList(list)
    }
}