package com.duke.orca.android.kotlin.wingtree.notification.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.duke.orca.android.kotlin.wingtree.notification.AllNotificationsFragment
import com.duke.orca.android.kotlin.wingtree.notification.UnconfirmedNotificationsFragment
import java.lang.IllegalStateException

class NotificationFragmentStateAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    private val itemCount = 2

    override fun getItemCount(): Int = itemCount

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> UnconfirmedNotificationsFragment()
            1 -> AllNotificationsFragment()
            else -> throw IllegalStateException("Invalid position.")
        }
    }
}