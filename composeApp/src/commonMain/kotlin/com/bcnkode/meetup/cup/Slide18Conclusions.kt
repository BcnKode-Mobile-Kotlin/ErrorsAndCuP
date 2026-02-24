package com.bcnkode.meetup.cup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.widgets.material3.BulletPoints

val conclusionsCuP by Slide {
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
                    Text("Spaghetti d'Estat")
                }
            }
            Spacer(Modifier.weight(1f))
        }
    }
}