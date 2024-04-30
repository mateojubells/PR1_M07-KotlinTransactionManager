package com.example.practica_m07_uf1
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class Test1 {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Ignore
    fun testOpenAddTransactionFragment() {
        onView(withId(R.id.fabAddTransaction)).perform(click())
        onView(withId(R.id.editTextText)).check(matches(isDisplayed()))
    }
    @Test
    fun testOpenAddTransactionFragment2() {
        onView(withId(R.id.fabAddTransaction)).perform(click())
        onView(withId(R.id.fabAddTransaction)).check(matches(isDisplayed()))
    }
    @Test
    fun testOpenDetailsView() {
        Thread.sleep(2000) //Esperamos a que carguen los datos
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fragmentContainerView)).check(matches(isDisplayed()))
    }
}

