package com.duke.orca.android.kotlin.wingtree.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.duke.orca.android.kotlin.wingtree.R
import com.duke.orca.android.kotlin.wingtree.base.OnTabItemClickListener
import com.duke.orca.android.kotlin.wingtree.databinding.ActivityMainBinding
import com.duke.orca.android.kotlin.wingtree.notification.NotificationFragment
import com.duke.orca.android.kotlin.wingtree.notification.data.NotificationItem
import com.duke.orca.android.kotlin.wingtree.post.detail.PostFragment
import com.duke.orca.android.kotlin.wingtree.study.StudiesFragment
import com.duke.orca.android.kotlin.wingtree.study.data.Study
import com.duke.orca.android.kotlin.wingtree.study.StudyFragment

class MainActivity : AppCompatActivity(), OnTabItemClickListener {

    private lateinit var dataBinding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.content.mainBottomNavigationBar.setIdToSelectedHashMap(
            hashMapOf(
                R.id.clHome_e to {
                    replaceFragmentToTab(StudiesFragment(), false)
                },
                R.id.clTask_e to {

                },
                R.id.clChat_e to {

                },
                R.id.clAlram_e to {
                    addFragmentToTab(NotificationFragment(), false)
                },
                R.id.clMy_e to {

                }
            )
        )
    }

    private fun addFragmentToTab(fragment: Fragment, addToBackStack: Boolean) {
        fragment.also {
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.add(R.id.fragment_container_view_tab, it, it.tag)

            if (addToBackStack)
                fragmentTransaction.addToBackStack(it.tag)

            fragmentTransaction.commit()
        }
    }

    private fun replaceFragmentToTab(fragment: Fragment, addToBackStack: Boolean) {
        fragment.also {
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.fragment_container_view_tab, it, it.tag)

            if (addToBackStack)
                fragmentTransaction.addToBackStack(it.tag)

            fragmentTransaction.commit()
        }
    }

    private fun replaceFragmentToContent(fragment: Fragment, addToBackStack: Boolean) {
        fragment.also {
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.fragment_container_view_content, it, it.tag)

            if (addToBackStack)
                fragmentTransaction.addToBackStack(it.tag)

            fragmentTransaction.commit()
        }
    }

    /** OnTabItemClickListener */
    override fun onTabItemClick(item: Any) {
        when(item) {
            is NotificationItem -> {
                viewModel.selectNotificationItem(item)
                replaceFragmentToContent(PostFragment(), false)
            }
            is Study -> {
                viewModel.selectStudy(item)
                replaceFragmentToContent(StudyFragment(), false)
            }
        }
    }
}