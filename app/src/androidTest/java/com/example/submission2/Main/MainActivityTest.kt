package com.example.submission2.Main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.submission2.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule
    @JvmField var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun appBehaviour(){
        onView(withId(R.id.rv_match_league))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_match_league)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(13))
        onView(withId(R.id.rv_match_league)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(13, click())
        )
    }
}