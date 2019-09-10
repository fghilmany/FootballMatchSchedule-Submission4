package com.example.submission2.ui

import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import com.example.submission2.activity.detail.DetailMatchAct
import com.example.submission2.R
import org.jetbrains.anko.*

class DetailActivityUI : AnkoComponent<DetailMatchAct>{
    override fun createView(ui: AnkoContext<DetailMatchAct>) = with(ui) {

        verticalLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            orientation = LinearLayout.VERTICAL
            lparams{
                width = matchParent
                height = matchParent
            }

            linearLayout {
                gravity = Gravity.CENTER

                imageView {
                    id = R.id.iv_club_home
                }.lparams{
                    width = dip(75)
                    height = dip(75)
                    margin = dip(16)
                }

                textView {
                    text = "VS"
                    textSize = 24f
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }

                imageView{
                    id = R.id.iv_club_away
                }.lparams{
                    width = dip(75)
                    height = dip(75)
                    margin = dip(16)
                }
            }.lparams{
                width = matchParent
                height = wrapContent
                margin = dip(16)
            }

            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                lparams{
                    width = matchParent
                    height = wrapContent

                }

                textView {
                    id = R.id.tv_club_home_name
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                }

                textView {
                    id = R.id.tv_score_home
                    textSize = 30f
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }

                textView {
                    text = "-"
                    textSize = 36f
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }

                textView {
                    id = R.id.tv_score_away
                    textSize = 30f
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }

                textView {
                    id = R.id.tv_club_away_name
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                }
            }

            textView {
                id = R.id.tv_match_date
            }.lparams(width = wrapContent, height = wrapContent)

            view{
                backgroundColor = Color.GRAY
            }.lparams{
                width = matchParent
                height = dip(3)
                margin = dip(16)
            }

            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                lparams(width = matchParent, height = wrapContent)

                textView {
                    id = R.id.tv_home_formation
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }

                textView {
                    text = "Formation"
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }

                textView {
                    id = R.id.tv_away_formation
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }
            }

            linearLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                lparams(width = matchParent, height = wrapContent)

                textView {
                    id = R.id.tv_home_Goal
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }

                textView {
                    text = "Goal"
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)
                }

                textView {
                    id = R.id.tv_away_goal

                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(16)

                }
            }
        }

    }


}