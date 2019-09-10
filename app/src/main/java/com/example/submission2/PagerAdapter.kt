package com.example.submission2

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.submission2.fragment.NextMatchFrag
import com.example.submission2.fragment.PrevMatchFrag

class PagerAdapter(fm : FragmentManager): FragmentPagerAdapter(fm){

    private val pages = listOf(
        PrevMatchFrag(),
        NextMatchFrag()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position] as Fragment

    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Prev Match"
            else -> "Next Match"
        }
    }

}