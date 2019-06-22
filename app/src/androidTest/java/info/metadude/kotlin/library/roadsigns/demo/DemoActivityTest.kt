package info.metadude.kotlin.library.roadsigns.demo

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DemoActivityTest {

    @Suppress("RedundantVisibilityModifier")
    @Rule
    @JvmField
    public val activityRule: ActivityTestRule<*> = ActivityTestRule(DemoActivity::class.java)

    private lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getTargetContext()
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
        val selectionItemText = context.getString(R.string.environmental_badges_content_description_green)
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
