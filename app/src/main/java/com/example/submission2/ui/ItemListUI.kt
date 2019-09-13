package com.example.submission2.ui

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.submission2.Main.MainActivity
import com.example.submission2.R
import org.jetbrains.anko.*
import org.jetbrains.anko.db.classParser

class ItemListUI :AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout{
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL

            lparams(width = matchParent, height = wrapContent)

            linearLayout{
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_HORIZONTAL

                lparams(width = matchParent, height = wrapContent)



                textView {
                    id = R.id.tv_club_home_name
                    hint = "Club home name"
                }.lparams{
                    width = wrapContent
                    height= wrapContent
                    margin = dip(5)
                }

                textView {
                    id = R.id.tv_score_home
                    hint = " "
                    textSize = 25f
                    typeface = Typeface.DEFAULT_BOLD
                    hint = " "
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(5)
                }

                textView {
                    text = "VS"
                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(5)
                }

                textView {
                    id = R.id.tv_score_away
                    hint= " "
                    textSize = 25f
                    typeface = Typeface.DEFAULT_BOLD
                    hint = " "

                }.lparams{
                    width = wrapContent
                    height = wrapContent
                    margin = dip(5)
                }

                textView {
                    id = R.id.tv_club_away_name
                    hint = "Club away name"
                    gravity = Gravity.RIGHT
                }.lparams{
                    width = wrapContent
                    height= wrapContent
                    margin = dip(5)
                }


            }

            textView {
                id = R.id.tv_match_date
                hint = "00-00-00"
                textSize = 10f
            }.lparams(width = wrapContent, height = wrapContent)
        }
    }
}