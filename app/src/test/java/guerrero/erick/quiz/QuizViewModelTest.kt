package guerrero.erick.quiz


import androidx.lifecycle.SavedStateHandle
import org.junit.Test

import org.junit.Assert.*
class QuizViewModelTest{
    @Test
    fun proveeElTextoDePreguntaEsperado(){
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.pregunta_chocolate,quizViewModel.currentQuestionText)
        quizViewModel.siguientePregunta()
        assertEquals(R.string.pregunta_33,quizViewModel.currentQuestionText)
    }

    @Test
    fun funcionaElBancoDePreguntas(){
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 3))
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.pregunta_proyecto,quizViewModel.currentQuestionText)
        quizViewModel.siguientePregunta()
        assertEquals(R.string.pregunta_chocolate,quizViewModel.currentQuestionText)
    }
}