package com.example.submission2.ui

import android.graphics.Typeface
import android.support.v4.widget.SwipeRefreshLayout
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Spinner
import com.example.submission2.FavoriteFragment
import com.example.submission2.R
import com.example.submission2.fragment.PrevMatchFrag
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FavoriteFragmentUI : AnkoComponent<FavoriteFragment> {
    lateinit var spinner : Spinner
    lateinit var progressBar: ProgressBar
    lateinit var swipeRefresh : SwipeRefreshLayout
    override fun createView(ui: AnkoContext<FavoriteFragment>)= with(ui) {

        verticalLayout {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            lparams(width = matchParent, height = matchParent)


            swipeRefresh = swipeRefreshLayout {
                id = R.id.swiperefresh
                setColorSchemeResources(
                    R.color.colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light
                )

                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)


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
}