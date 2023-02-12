package com.dumdumbich.docsheap.ui

import android.os.Bundle
import com.dumdumbich.docsheap.R
import com.dumdumbich.docsheap.databinding.ActivityMainBinding
import com.dumdumbich.docsheap.ui.base.BaseActivity


class MainActivity : BaseActivity() {

    private lateinit var ui: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        ui.mainBottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_navigation_home -> {
                    //showFragment(HomeFragment())
                    true
                }
                R.id.menu_item_navigation_library -> {
                    //showFragment(TuneFragment())
                    true
                }
                R.id.menu_item_navigation_setting -> {
                    //showFragment(ServeFragment())
                    true
                }
                else -> false
            }
        }

        if (savedInstanceState == null) setDefaultMainMenuItem()

    }

    private fun setDefaultMainMenuItem() {
        ui.mainBottomNavigationView.selectedItemId = R.id.menu_item_navigation_home
    }


}