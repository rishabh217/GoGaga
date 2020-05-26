package com.rishabhgupta.gogaga

import android.os.Bundle
import android.view.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.rishabhgupta.gogaga.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<View>(R.id.view_pager) as ViewPager
        val tabLayout = findViewById<TabLayout>(R.id.tabs) as TabLayout

        viewPager.adapter = SectionsPagerAdapter(this, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager, true)

    }
}