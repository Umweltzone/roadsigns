package info.metadude.kotlin.library.roadsigns.demo

import android.content.Context
import android.support.annotation.StringRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.view.View
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class DemoActivityParameterizedTest(

    @StringRes private val selectionItemTextRes: Int,
    private val isDisplayed: Matcher<View>,
    @StringRes private val contentDescriptionTextRes: Int

) {

    @Suppress("RedundantVisibilityModifier")
    @Rule
    @JvmField
    public val activityRule: ActivityTestRule<*> = ActivityTestRule(DemoActivity::class.java)

    private lateinit var context: Context

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun testParameters() = listOf(
            arrayOf(
                R.string.environmental_badges_content_description_green,
                isDisplayed(),
                R.string.environmental_badges_content_description_green
            ),
            arrayOf(
                R.string.environmental_badges_content_description_yellow_green,
                isDisplayed(),
                R.string.environmental_badges_content_description_yellow_green
            ),
            arrayOf(
                R.string.environmental_badges_content_description_red_yellow_green,
                isDisplayed(),
                R.string.environmental_badges_content_description_red_yellow_green
            ),
            arrayOf(
                R.string.diesel_prohibition_cars_free_until_euro_5_v_open_for_residents,
                isDisplayed(),
                R.string.diesel_prohibition_cars_free_until_euro_5_v_open_for_residents
            ),
            arrayOf(
                R.string.diesel_prohibition_hgvs_free_until_euro_v_open_for_residents_hamburg,
                isDisplayed(),
                R.string.diesel_prohibition_hgvs_free_until_euro_v_open_for_residents_hamburg
            ),
            arrayOf(
                R.string.diesel_prohibition_free_as_of_euro_5_v_except_delivery_vehicles_stuttgart,
                isDisplayed(),
                R.string.diesel_prohibition_free_as_of_euro_5_v_except_delivery_vehicles_stuttgart
            )
        )
    }

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getTargetContext()
    }

    @Test
    fun contentDescriptionMatchesSelectionText() {
        val selectionItemText = context.getString(selectionItemTextRes)
        val contentDescriptionText = context.getString(contentDescriptionTextRes)
        onView(withId(R.id.selectionView)).perform(click())
        onView(withText(selectionItemText)).perform(click())
        onView(withId(R.id.genericRoadSignView))
            .check(matches(isDisplayed))
            .check(matches(withContentDescription(contentDescriptionText)))
    }

}
