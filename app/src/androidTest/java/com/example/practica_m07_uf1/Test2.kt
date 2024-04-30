package com.example.practica_m07_uf1

import androidx.fragment.app.FragmentManager
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.PositionAssertions.isBelow
import androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove
import androidx.test.espresso.assertion.PositionAssertions.isCompletelyBelow
import androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf
import androidx.test.espresso.assertion.PositionAssertions.isCompletelyRightOf
import androidx.test.espresso.assertion.PositionAssertions.isLeftAlignedWith
import androidx.test.espresso.assertion.PositionAssertions.isRightAlignedWith
import androidx.test.espresso.assertion.PositionAssertions.isRightOf
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test

class Test2(){

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test1(){
        onView(withId(R.id.fabAddTransaction)).perform(click())

        onView(withId(R.id.editTextText)).check(isCompletelyBelow(withId(R.id.textView4)))
        onView(withId(R.id.editTextText)).perform(typeText("Work Salary"))

        onView(withId(R.id.textView5)).check(isCompletelyBelow(withId(R.id.editTextText)))
        onView(withId(R.id.editTextNumber)).check(isCompletelyBelow(withId(R.id.textView5)))
        onView(withId(R.id.editTextNumber)).perform(typeText("12"))

        onView(withId(R.id.textView6)).check(isCompletelyBelow(withId(R.id.editTextNumber)))
        onView(withId(R.id.editTextText2)).check(isCompletelyBelow(withId(R.id.textView6)))
        onView(withId(R.id.editTextText2)).perform(typeText("12/02/2024"))

        onView(withId(R.id.textView7)).check(isCompletelyBelow(withId(R.id.editTextText2)))
        onView(withId(R.id.editTextText3)).check(isCompletelyBelow(withId(R.id.textView7)))
        onView(withId(R.id.editTextText3)).perform(typeText("Income"))

        onView(withId(R.id.button)).check(isCompletelyBelow(withId(R.id.editTextText3)))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.editTextSearch)).check(matches(isDisplayed()))

        onView(withId(R.id.buttonSearch)).check(matches(isDisplayed()))

        onView(withId(R.id.buttonSearch)).check(isLeftAlignedWith(withId(R.id.buttonSearch)))

        onView(withId(R.id.buttonSearch)).perform(click())

        onView(withId(R.id.recyclerView))
            .check(matches(isDisplayed()))
            .check(isBelow(withId(R.id.editTextSearch)))

        onView(withId(R.id.nameTextView)).check(matches(isDisplayed()))
        onView(withId(R.id.amountTextView)).check(isCompletelyBelow(withId(R.id.nameTextView)))
        onView(withId(R.id.imageButton3)).check(isCompletelyRightOf(withId(R.id.amountTextView)))

    }

    @Test
    fun test2(){
        onView(withId(R.id.fabAddTransaction)).perform(click())

        onView(withId(R.id.editTextText)).check(isCompletelyBelow(withId(R.id.textView4)))
        onView(withId(R.id.editTextText)).perform(typeText("Work Salary2"))

        onView(withId(R.id.textView5)).check(isCompletelyBelow(withId(R.id.editTextText)))
        onView(withId(R.id.editTextNumber)).check(isCompletelyBelow(withId(R.id.textView5)))
        onView(withId(R.id.editTextNumber)).perform(typeText("12"))

        onView(withId(R.id.textView6)).check(isCompletelyBelow(withId(R.id.editTextNumber)))
        onView(withId(R.id.editTextText2)).check(isCompletelyBelow(withId(R.id.textView6)))
        onView(withId(R.id.editTextText2)).perform(typeText("12/02/2024"))

        onView(withId(R.id.textView7)).check(isCompletelyBelow(withId(R.id.editTextText2)))
        onView(withId(R.id.editTextText3)).check(isCompletelyBelow(withId(R.id.textView7)))
        onView(withId(R.id.editTextText3)).perform(typeText("Income"))

        Espresso.closeSoftKeyboard()

        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.buttonSearch)).perform(click())

        onView(withId(R.id.nameTextView))
            .check(matches(withText("Work Salary2")))
            .perform(click())


        //onView(withId(R.id.nameTextView)).perform(click())


        onView(withId(R.id.imageButton))
            .check(matches(isDisplayed()))

        onView(withId(R.id.textView))
            .check(matches(withText("Work Salary2")))

    }
}