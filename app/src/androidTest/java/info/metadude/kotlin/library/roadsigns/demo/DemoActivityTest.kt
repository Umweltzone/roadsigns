package info.metadude.kotlin.library.roadsigns.demo

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DemoActivityTest {

    @Suppress("RedundantVisibilityModifier")
    @Rule
    @JvmField
    public val activityRule: ActivityScenarioRule<*> =
        ActivityScenarioRule(DemoActivity::class.java)

    private lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun selectionViewIsDisplayed() {
        onView(withId(R.id.selectionView)).check(matches(isDisplayed()))
    }

    @Test
    fun roadSignViewIsDisplayed() {
        onView(withId(R.id.roadSignView)).check(matches(isDisplayed()))
    }

    @Test
    fun genericRoadSignViewIsDisplayed() {
        val selectionItemText = context.getString(
            R.string.environmental_badges_content_description_green
        )
        onView(withId(R.id.selectionView)).perform(click())
        onView(withText(selectionItemText)).perform(click())
        onView(withId(R.id.genericRoadSignView)).check(matches(isDisplayed()))
    }

    @Test
    fun genericRoadSignViewIsHidden() {
        val selectionItemText = context.getString(R.string.sign_none)
        onView(withId(R.id.selectionView)).perform(click())
        onView(withText(selectionItemText)).perform(click())
        onView(withId(R.id.genericRoadSignView)).check(matches(not(isDisplayed())))
    }

}
