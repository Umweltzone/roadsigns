package info.metadude.kotlin.library.roadsigns.demo

import android.content.Context
import android.view.View
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
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
            testCaseOf(R.string.environmental_badges_content_description_green),
            testCaseOf(R.string.environmental_badges_content_description_yellow_green),
            testCaseOf(R.string.environmental_badges_content_description_red_yellow_green),
            testCaseOf(R.string.diesel_prohibition_cars_free_until_euro_5_v_open_for_residents),
            testCaseOf(R.string.diesel_prohibition_hgvs_free_until_euro_v_open_for_residents_hamburg),
            testCaseOf(R.string.diesel_prohibition_free_as_of_euro_5_v_except_delivery_vehicles_stuttgart)
        )

        private fun testCaseOf(descriptionResource: Int) = arrayOf(
            descriptionResource, // as selectionItemTextRes
            isDisplayed(),
            descriptionResource // as contentDescriptionTextRes
        )
    }

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
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
