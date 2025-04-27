package me.davidcosta.movio

import android.app.Activity
import androidx.compose.material3.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest = "src/test/AndroidManifest.xml")
class ExampleUnitTest {

    @get:Rule
    val rule = createComposeRule()

    private lateinit var activityController: ActivityController<Activity>
    private lateinit var activity: Activity

    @Before
    fun setUp() {
        activityController = Robolectric.buildActivity(Activity::class.java)
        activity = activityController.get()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

//    @Test
//    fun testScreen() {
//        rule.setContent {
//            PosterComp(
//                posterData = Poster(
//                    id = 1,
//                    title = "Blade Runner",
//                    posterPath = "poster.jpg"
//                )
//            )
//        }
//        rule.onNodeWithContentDescription("Poster do filme Blade Runner").assertExists()
//    }

    @Test
    fun testSample() {
        rule.setContent {
            Text("Blade Runner")
        }
        rule.onNodeWithText("Blade Runner").assertExists()
    }
}