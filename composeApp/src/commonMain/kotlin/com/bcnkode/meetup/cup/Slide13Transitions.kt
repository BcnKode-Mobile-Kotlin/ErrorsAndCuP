package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.composables.CodeInPane
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

val transitionsCuP by Slide(
    stepCount = 2,
    user = SpeakerNotes(
        """
           (Paso 0) 1. Sobrescribiendo el global:
            Acabamos de ver cómo poner unas transiciones a toda la presentación. Pero, ¿y si llego a una diapositiva 
            quiero que, solo esta vez, la pantalla entre deslizando desde abajo hacia arriba?
            Muy fácil: cuando declaramos nuestra variable Slide, le pasamos sus propios SlideSpecs. Al hacer esto, 
            CuP ignora la configuración global del main y aplica este TransitionSet.moveVertical exclusivamente a esta diapositiva.
            
            (Paso 1) 2. Transiciones 100% Custom:
            (Clic para revelar el código del TransitionSet)
            Pero esperad, que hay más. No estamos limitados a los presets que nos da la librería 
            (como fade o moveVertical o moveHorizontal). ¿Qué es realmente un TransitionSet por debajo?
            ¡Es Jetpack Compose puro! Si creáis vuestro propio TransitionSet, le podéis pasar los bloques enter y exit. 
            Dentro de ellos, podéis sumar animaciones nativas con el operador +, exactamente igual que hacéis en un 
            AnimatedVisibility de Android: fadeIn() + slideIn().
            
            3. Conclusión: Si queréis que vuestra diapositiva entre haciendo un tirabuzón, escalando y cambiando de 
            alfa a la vez... solo tenéis que sumar los modificadores. Control absoluto. 
        """.trimIndent()
    )
) { step ->
    val sourceCode = rememberSourceCode(language = "kotlin") {
        """
        val slide by Slide(
            specs = SlideSpecs(
                startTransitions = TransitionSet.moveVertical,
                endTransitions = TransitionSet.moveVertical,
            )
        ) {
            ...
        }
    """.trimIndent()
    }
    val transitionSetCode = rememberSourceCode(language = "kotlin") {
        """
            TransitionSet(
                enter = { fadeIn() + slideIn() },
                exit = { fadeOut() + slideOut() }, 
            )
        """.trimIndent()
    }

    TitleAndContentScaffold(
        title = "Transitions",
        subtitle = "Specific"
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(3f))
            if (step == 0) {
                CodeInPaneWithTitle(
                    title = "Set a specific transitions",
                    code = sourceCode,
                    modifier = Modifier.fillMaxWidth(),
                )
            } else {
                CodeInPane(
                    code = transitionSetCode,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Spacer(Modifier.weight(3f))
        }
    }
}