package com.duke.orca.android.kotlin.wingtree.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.base.BaseFragment
import com.duke.orca.android.kotlin.wingtree.databinding.FragmentNotificationBinding
import com.duke.orca.android.kotlin.wingtree.notification.adapter.NotificationFragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator

class NotificationFragment: BaseFragment<FragmentNotificationBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_notification

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        initializeView()

        return view
    }

    private fun initializeView() {
        binding.viewPager2.adapter = NotificationFragmentStateAdapter(requireActivity())
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.tag = position
        }.attach()
    }
}