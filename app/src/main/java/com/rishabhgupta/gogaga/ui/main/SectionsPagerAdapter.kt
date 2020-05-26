package com.rishabhgupta.gogaga.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rishabhgupta.gogaga.R

class SectionsPagerAdapter internal constructor(
    private val mContext: Context?,
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return MatchFragment()
            }
            1 -> {
                return AppFragment()
            }
            else -> return MatchFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }


    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return "Match Preferences"
            }
            1 -> {
                return "App Preferences"
            }
            else -> return "Match Preferences"
        }
    }
}