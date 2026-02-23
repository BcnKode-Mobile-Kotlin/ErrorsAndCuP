package com.bcnkode.meetup.errorhandling

import androidx.compose.material3.Text
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.layouts.Bullet
import com.bcnkode.meetup.layouts.BulletListDetail
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val issuesOfCheckedErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 5,
) { step ->
    TitleAndContentScaffold(
        title = "History",
        subtitle = "Issues with checked exceptions",
    ) {
        BulletListDetail(
            bullets = listOf(
                Bullet("Catch and ignore") {
                    Text("try-catch has boilerplate + being forced to handle exceptions = empty catch blocks") // TODO consider adding code
                },
                Bullet("Propagation") {
                    Text("When you propagate an exception across layers, you handle a low level error (like IO) far from where it happens.")
                },
                Bullet("Functional issues") {
                    Text("Lambdas in Java and Kotlin don't handle checked exceptions\n\nYou need to add the try-catch inside: boilerplate")// TODO add example
                },
                Bullet("Adding exceptions") {
                    Text(styled(MyStyleSheet) { "You need to add ${+code}throws MyException${-code} in all layers until you handle your exceptions" })
                },
                Bullet("Where to catch") {
                    Text("We have arrived to the conclusion that we should handle exceptions at the perimeter")
                },
            ),
            step = step,
        )
    }
}