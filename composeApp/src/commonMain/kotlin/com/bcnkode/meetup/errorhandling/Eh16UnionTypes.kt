package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.utils.showIf
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val unionTypesErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 2,
) { step ->

    val simpleUnionCode = rememberSourceCode(language = "kotlin") {
            """
fun findUserById(userId: Int): User | UserNotFound
""".trimIndent()
        }

    val longUnionCode = rememberSourceCode(language = "kotlin") {
        """
fun fetchUser(userId: Int): User | NoInternet | ServerError | UserNotFound
""".trimIndent()
    }

    TitleAndContentScaffold(
        title = "A bright future",
        subtitle = "Kotlin union types (upcoming)",
        contentAlignment = Alignment.Center,
    ) {
        Column {
            CodeInPaneWithTitle(
                "First the result, then the error",
                simpleUnionCode,
            )

            Spacer(Modifier.height(24.dp))

            Column(Modifier.showIf(step >= 1)) {
                CodeInPaneWithTitle(
                    styled(MyStyleSheet) { "It is not sealed, we can combine them, but only ${+code}Error${-code}s" },
                    longUnionCode,
                )
            }
        }
    }
}
