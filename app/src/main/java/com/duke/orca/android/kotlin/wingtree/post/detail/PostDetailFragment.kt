package com.duke.orca.android.kotlin.wingtree.post.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.base.BaseFragment
import com.duke.orca.android.kotlin.wingtree.databinding.FragmentPostDetailBinding

class PostDetailFragment: BaseFragment<FragmentPostDetailBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_post_detail

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}