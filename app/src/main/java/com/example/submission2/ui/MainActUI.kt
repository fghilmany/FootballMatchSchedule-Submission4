package com.example.submission2.ui

import android.view.Gravity
import android.widget.Spinner
import com.example.submission2.Main.MainActivity
import com.example.submission2.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.support.v4.viewPager

class MainActUI : AnkoComponent<MainActivity>{

    override fun createView(ui: AnkoContext<MainActivity>)= with(ui) {
        verticalLayout {

            lparams(width = matchParent, height = matchParent)

            tabLayout {
                id = R.id.tabs_main
                // gravity = Gravity.TOP
                lparams{
                    width = matchParent
                    height = wrapContent
                    tabGravity = top}
            }

            viewPager {
                id = R.id.viewpager_main


            }.lparams{width = matchParent
                height = wrapContent}


        }

    }
}