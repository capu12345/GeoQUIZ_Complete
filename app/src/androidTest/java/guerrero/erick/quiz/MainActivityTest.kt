package guerrero.erick.quiz

import androidx.annotation.StringRes
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.runner.RunWith


import org.junit.After
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var scenario:ActivityScenario<MainActivity>
    @Before
    fun setUp() {
    scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun verificarSiSeMuestraPrimerPreguntaOnLaunch(){
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.pregunta_chocolate)))
    }

    @Test
    fun seMuestraLaSegundaPreguntaAlDarClick(){
        onView(withId(R.id.next_button)).perform(click())
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.pregunta_33)))
    }

    @Test
    fun seMantieneElEstadodeLaUI(){
        onView(withId(R.id.next_button)).perform(click())
        scenario.recreate()
        onView(withId(R.id.question_text))
            .check(matches(withText(R.string.pregunta_33)))

    }
}