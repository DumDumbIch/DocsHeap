package com.dumdumbich.docsheap.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.dumdumbich.docsheap.R
import com.dumdumbich.docsheap.databinding.ActivityMainBinding
import com.dumdumbich.docsheap.ui.base.BaseActivity
import com.dumdumbich.docsheap.ui.screen.home.HomeFragment
import com.dumdumbich.docsheap.ui.screen.library.LibraryFragment
import com.dumdumbich.docsheap.ui.screen.setting.SettingFragment


class MainActivity : BaseActivity() {

    private lateinit var ui: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        fragmentManager = supportFragmentManager

        ui.mainBottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_navigation_home -> {
                    showFragment(HomeFragment())
                    true
                }
                R.id.menu_item_navigation_library -> {
                    showFragment(LibraryFragment())
                    true
                }
                R.id.menu_item_navigation_setting -> {
                    showFragment(SettingFragment())
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) setDefaultMainMenuItem()

    }


    private fun showFragment(fragment: Fragment) {
        ui.mainFragmentContainer.let { container ->
            fragmentManager.beginTransaction()
                .replace(container.id, fragment)
                .commit()
        }
    }


    private fun setDefaultMainMenuItem() {
        ui.mainBottomNavigationView.selectedItemId = R.id.menu_item_navigation_home
    }


}