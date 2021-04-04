package com.duke.orca.android.kotlin.wingtree.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.base.BaseFragment
import com.duke.orca.android.kotlin.wingtree.base.TabFragment
import com.duke.orca.android.kotlin.wingtree.databinding.FragmentNotificationsBinding
import com.duke.orca.android.kotlin.wingtree.main.MainViewModel
import com.duke.orca.android.kotlin.wingtree.notification.adapter.NotificationAdapter
import com.duke.orca.android.kotlin.wingtree.util.LayoutManagerWrapper

class UnconfirmedNotificationsFragment: TabFragment<FragmentNotificationsBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_notifications

    private val viewModel by activityViewModels<MainViewModel>()

    private val notificationAdapter = NotificationAdapter { binding, item ->
        onTabItemClickListener?.onTabItemClick(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        initializeAdapter()
        initializeLiveData()

        return view
    }

    private fun initializeAdapter() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LayoutManagerWrapper(requireContext(), 1)
            adapter = notificationAdapter
        }
    }

    private fun initializeLiveData() {
        viewModel.unconfirmedNotificationItems.observe(viewLifecycleOwner, {
            notificationAdapter.submitList(it)
        })
    }
}