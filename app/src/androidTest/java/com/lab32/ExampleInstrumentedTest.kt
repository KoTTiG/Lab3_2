package com.lab32

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HelloWorldEspressoTest {
    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun passageInOrder() {
        onView(withId(R.id.act_main_to_second_button)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(SecondActivity::class.java.name))
        onView(withId(R.id.activity_second_tothird_button)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(ThirdActivity::class.java.name))
        onView(withId(R.id.activity_third_tosecond_button))
        Intents.intended(IntentMatchers.hasComponent(SecondActivity::class.java.name))
    }

    @Test
    fun testBottomNavMain() {
        onView(withId(R.id.about)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(AboutActivity::class.java.name))
    }

    @Test
    fun testBottomNavSecond() {
        onView(withId(R.id.act_main_to_second_button)).perform(click())
        onView(withId(R.id.about)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(AboutActivity::class.java.name))
    }

    @Test
    fun testBottomNavThird() {
        onView(withId(R.id.act_main_to_second_button)).perform(click())
        onView(withId(R.id.activity_second_tothird_button)).perform(click())
        onView(withId(R.id.about)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(AboutActivity::class.java.name))
        onView(withId(R.id.activity_about_tobrowser_button)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(WebActivity::class.java.name))
    }

    @Test
    fun testStack() {
        onView(withId(R.id.act_main_to_second_button)).perform(click())
        Espresso.pressBack()
        Intents.intended(IntentMatchers.anyIntent())
        onView(withId(R.id.act_main_to_second_button)).perform(click())
        onView(withId(R.id.activity_second_tothird_button)).perform(click())
        Espresso.pressBack()
        Espresso.pressBack()
        onView(withId(R.id.act_main_to_second_button)).perform(click())
        onView(withId(R.id.activity_second_tothird_button)).perform(click())
        onView(withId(R.id.activity_third_tofirst_button)).perform(click())
    }

    @Test
    fun testScreenOrientation() {
        activityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        onView(withId(R.id.act_main_to_second_button)).perform(click())
        activityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        onView(withId(R.id.activity_second_tothird_button)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(ThirdActivity::class.java.name))

    }
}
