package com.duke.orca.android.kotlin.wingtree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.duke.orca.android.kotlin.wingtree.base.BaseFragment
import com.duke.orca.android.kotlin.wingtree.databinding.ActivityMainBinding
import com.duke.orca.android.kotlin.wingtree.notification.NotificationFragment

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.content.mainBottomNavigationBar.setIdToSelectedHashMap(
            hashMapOf(
                R.id.clHome_e to {

                },
                R.id.clTask_e to {

                },
                R.id.clChat_e to {

                },
                R.id.clAlram_e to {
                    addFragmentToMenu(NotificationFragment())
                },
                R.id.clMy_e to {

                }
            )
        )
    }

    private fun addFragmentToMenu(fragment: BaseFragment) {
        fragment.also {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout_menu, it, it.tag)
                .addToBackStack(null)
                .commit()
        }
    }
}