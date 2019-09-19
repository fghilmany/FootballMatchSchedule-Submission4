package com.example.submission2.ui

import android.graphics.Color
import android.support.v4.widget.SwipeRefreshLayout
import android.view.Gravity
import android.widget.LinearLayout
import com.example.submission2.activity.detail.DetailMatchAct
import com.example.submission2.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class DetailActivityUI : AnkoComponent<DetailMatchAct>{
    lateinit var swipeRefresh : SwipeRefreshLayout
    override fun createView(ui: AnkoContext<DetailMatchAct>) = with(ui) {

        linearLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            orientation = LinearLayout.VERTICAL
            lparams {
                width = matchParent
                height = matchParent
            }
            swipeRefresh = swipeRefreshLayout {
                id = R.id.swiperefresh
                setColorSchemeResources(
                    R.color.colorAccent,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light
                )

                scrollView {
                    isVerticalScrollBarEnabled = false
                    verticalLayout {
                        lparams(width = matchParent, height = wrapContent)
                        gravity = Gravity.CENTER_HORIZONTAL

                        linearLayout {
                            gravity = Gravity.CENTER_HORIZONTAL

                            imageView {
                                id = R.id.iv_club_home
                            }.lparams {
                                width = dip(75)
                                height = dip(75)
                                margin = dip(16)
                            }

                            textView {
                                text = "VS"
                                textSize = 24f
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(16)
                            }

                            imageView {
                                id = R.id.iv_club_away
                            }.lparams {
                                width = dip(75)
                                height = dip(75)
                                margin = dip(16)
                            }

                            lparams {
                                width = matchParent
                                height = wrapContent
                                margin = dip(16)
                            }
                        }

                        linearLayout {
                            gravity = Gravity.CENTER_HORIZONTAL
                            lparams {
                                width = matchParent
                                height = wrapContent

                            }

                            textView {
                                id = R.id.tv_club_home_name
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(10)
                            }

                            textView {
                                id = R.id.tv_score_home
                                textSize = 30f
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(16)
                            }

                            textView {
                                text = "-"
                                textSize = 36f
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(16)
                            }

                            textView {
                                id = R.id.tv_score_away
                                textSize = 30f
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(16)
                            }

                            textView {
                                id = R.id.tv_club_away_name
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(10)
                            }
                        }

                        textView {
                            id = R.id.tv_match_date
                            gravity = Gravity.CENTER_HORIZONTAL
                        }.lparams(width = matchParent, height = wrapContent)

                        view {
                            backgroundColor = Color.GRAY
                        }.lparams(width = matchParent, height = dip(3))

                        linearLayout {
                            gravity = Gravity.CENTER_HORIZONTAL
                            lparams{width = matchParent
                                height = wrapContent
                                margin = dip(10)
                            }

                            textView {
                                id = R.id.tv_home_formation
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(16)
                            }

                            textView {
                                text = "Formation"
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(16)
                            }

                            textView {
                                id = R.id.tv_away_formation
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                margin = dip(16)
                            }
                        }

                        linearLayout {
                            gravity = Gravity.CENTER_HORIZONTAL
                            lparams{width = matchParent
                                height = wrapContent
                                margin = dip(10)
                                padding = dip(6)
                            }

                            textView {
                                id = R.id.tv_home_Goal
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.LEFT
                                margin = dip(16)
                            }

                            textView {
                                text = "Goal"
                                
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.CENTER_HORIZONTAL
                                margin = dip(16)
                            }

                            textView {
                                id = R.id.tv_away_goal

                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.RIGHT
                                margin = dip(16)

                            }
                        }

                        linearLayout {
                            gravity = Gravity.CENTER_HORIZONTAL
                            lparams{width = matchParent
                                height = wrapContent
                                margin = dip(10)
                                padding = dip(6)
                            }

                            textView {
                                id = R.id.tv_home_ycard
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.LEFT
                                margin = dip(16)
                            }

                            textView {
                                text = "Yellow Card"

                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.CENTER_HORIZONTAL
                                margin = dip(16)
                            }

                            textView {
                                id = R.id.tv_away_ycard

                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.RIGHT
                                margin = dip(16)

                            }
                        }

                        linearLayout {
                            gravity = Gravity.CENTER_HORIZONTAL
                            lparams{width = matchParent
                                height = wrapContent
                                margin = dip(10)
                                padding = dip(6)
                            }

                            textView {
                                id = R.id.tv_home_rcard
                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.LEFT
                                margin = dip(16)
                            }

                            textView {
                                text = "Red Card"

                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.CENTER_HORIZONTAL
                                margin = dip(16)
                            }

                            textView {
                                id = R.id.tv_away_rcard

                            }.lparams {
                                width = wrapContent
                                height = wrapContent
                                gravity = Gravity.RIGHT
                                margin = dip(16)

                            }
                        }

                    }

                }


            }

        }


    }
}