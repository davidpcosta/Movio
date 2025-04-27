package me.davidcosta.movio

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import me.davidcosta.movio.core.components.poster.PosterComp
import me.davidcosta.movio.core.domain.Poster

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("me.davidcosta.movio", appContext.packageName)
    }

    @Test
    fun testScreen() {
        rule.setContent {
            PosterComp(
                posterData = Poster(
                    id = 1,
                    title = "Blade Runner",
                    posterPath = "poster.jpg"
                )
            )
        }
        rule.onNodeWithContentDescription("Poster do filme Blade Runner").assertExists()
    }
}