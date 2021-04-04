package com.duke.orca.android.kotlin.wingtree.post.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.base.BaseFragment
import com.duke.orca.android.kotlin.wingtree.databinding.FragmentPostBinding
import com.duke.orca.android.kotlin.wingtree.main.MainViewModel

class PostFragment: BaseFragment<FragmentPostBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_post

    private val viewModel by activityViewModels<MainViewModel>()

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
        viewModel.selectedPostId.observe(viewLifecycleOwner, {
            it ?: return@observe

            binding.textViewStudyName.text = it
        })
    }
}