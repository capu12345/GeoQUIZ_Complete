package guerrero.erick.quiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


private const val TAG = "QuizViewModel"

public const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle:SavedStateHandle): ViewModel() {
    private val bancoPreguntas = listOf(
        Pregunta(R.string.pregunta1,true),
        Pregunta(R.string.pregunta2,false),
        Pregunta(R.string.pregunta3,false),
        Pregunta(R.string.pregunta4,false),
        Pregunta(R.string.pregunta5,true),
        Pregunta(R.string.pregunta6,true),
        Pregunta(R.string.pregunta7,false),
        Pregunta(R.string.pregunta8,true),
        Pregunta(R.string.pregunta9,false),
        Pregunta(R.string.pregunta10,false),
        Pregunta(R.string.pregunta11,true),
        Pregunta(R.string.pregunta12,true),
        Pregunta(R.string.pregunta13,false),
        Pregunta(R.string.pregunta14,false),
        Pregunta(R.string.pregunta15,true),
        )

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    private var indice:Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY,value)

    val currentQuestionAnswer:Boolean
        get() = bancoPreguntas[indice].respuesta
    val currentQuestionText:Int
        get() = bancoPreguntas[indice].textoPregunta

    fun siguientePregunta(){

        indice = (indice+1)%bancoPreguntas.size
    }
}