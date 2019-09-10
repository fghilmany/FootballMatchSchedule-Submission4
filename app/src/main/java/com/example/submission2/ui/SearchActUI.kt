package com.example.submission2.ui

import android.graphics.Typeface
import android.support.v4.widget.SwipeRefreshLayout
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Spinner
import com.example.submission2.R
import com.example.submission2.activity.SearchActivity
import com.example.submission2.fragment.PrevMatchFrag
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class SearchActUI : AnkoComponent<SearchActivity> {
    override fun createView(ui: AnkoContext<SearchActivity>)= with(ui) {

        verticalLayout {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            lparams(width = matchParent, height = matchParent)

                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)

                    textView {
                        id = R.id.tv_league_name
                        textSize = 18f
                        typeface = Typeface.DEFAULT_BOLD
                    }.lparams{
                        width = wrapContent
                        height = wrapContent
                        margin = dip(8)
                        gravity = Gravity.CENTER_HORIZONTAL
                    }

                    recyclerView {
                        id = R.id.rv_match_league
                        foregroundGravity = Gravity.CENTER_HORIZONTAL
                        lparams{
                            width = matchParent
                            height = wrapContent
                        }

                    }

            }


        }

    }
}