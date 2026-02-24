package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints

val conclusionsCuP by Slide(
    user = SpeakerNotes(
        """
           1. Lo Bueno (Por qué me encanta):
            Diseño y Consistencia: Reutilizar componentes y temas de tu app es un lujo. Te aseguras de que el diseño 
            siempre cuadra al píxel gracias a los Scaffolds, sin hacer el tonto ajustando cajas a mano.
            
            Animaciones y Productividad: Hacer animaciones nativas es divertidísimo. Además, como es código puro, si le 
            pides a una IA como Gemini o ChatGPT que te genere un Canvas o un componente complejo, te acelera el trabajo 
            de forma brutal.
            
           2. Lo Malo (La cruda realidad):
            Pero seamos honestos, no todo es de color de rosa:
            
            Cero "Drag & Drop": Si quieres poner una flecha apuntando a una caja... te toca calcular coordenadas y usar 
            un Canvas. Tareas de 5 segundos en Keynote aquí pueden llevar 15 minutos.
            
            La pesadilla del formato: Cuadrar los espacios y los marcadores invisibles para que el código quede bonito a 
            veces es pesado y frustrante.
            
            "Spaghetti d'Estat": Si una diapositiva tiene 15 pasos y muchas animaciones cruzadas, la gestión de los 
            if (step == X) se convierte en un código espagueti difícil de mantener. 
        """.trimIndent()
    )
) {
    TitleAndContentScaffold(
        title = "Conclusions"
    ) {
        Column {
            Spacer(Modifier.weight(1f))
            BulletPoints {
                BulletPoint {
                    Text("Easy to create components and unify styles and themes")
                }
                BulletPoint {
                    Text("Great way to create animations")
                }
                BulletPoint {
                    Text("Easy to gain consistency")
                }
                BulletPoint {
                    Text("With AI we can improve the development speed")
                }
                BulletPoint {
                    Text("Zero freedom \"Drag and drop\"")
                }
                BulletPoint {
                    Text("Code highlighting nightmare")
                }
                BulletPoint {
                    Text("Learning and dependence curve")
                }
                BulletPoint {
                    Text("State spaghetti")
                }
            }
            Spacer(Modifier.weight(1f))
        }
    }
}