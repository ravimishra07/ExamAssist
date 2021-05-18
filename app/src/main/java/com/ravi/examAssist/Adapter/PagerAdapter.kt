package com.ravi.examAssist.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ravi.examAssist.Fragments.LoginTabFragment
import com.ravi.examAssist.Fragments.SignupFragment

class PagerAdapter(fm: FragmentManager?, var mNumOfTabs: Int) : FragmentStatePagerAdapter(
    fm!!
) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LoginTabFragment()
            }
            1 -> {
                SignupFragment()
            }
            else -> LoginTabFragment()
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}