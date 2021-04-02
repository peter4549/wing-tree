package com.duke.orca.android.kotlin.wingtree.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.duke.orca.android.kotlin.wingtree.base.BaseFragment
import com.duke.orca.android.kotlin.wingtree.databinding.FragmentNotificationBinding
import com.duke.orca.android.kotlin.wingtree.notification.adapter.NotificationFragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator

class NotificationFragment: BaseFragment() {

    private lateinit var dataBinding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentNotificationBinding.inflate(inflater, container, false)

        initializeView()

        return dataBinding.root
    }

    private fun initializeView() {
        dataBinding.viewPager2.adapter = NotificationFragmentStateAdapter(requireActivity())
       TabLayoutMediator(dataBinding.tabLayout, dataBinding.viewPager2) { tab, position ->
           tab.tag = position
       }.attach()
    }
}