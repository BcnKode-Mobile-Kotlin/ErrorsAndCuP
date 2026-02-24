package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.MyStyleSheet.code
import com.bcnkode.meetup.MyStyleSheet.unaryMinus
import com.bcnkode.meetup.MyStyleSheet.unaryPlus
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.utils.showIf
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val conclusionErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 4,
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
        title = "Conclusion",
        contentAlignment = Alignment.Center,
    ) {
        Column(Modifier.fillMaxWidth()) {

            Spacer(Modifier.weight(2f))
            Text(
                "Each tool has an additional learning curve, and some payoff",
                Modifier.showIf(step > 0),
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Try-catch → MyResult → Raise",
                Modifier.showIf(step > 0),
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(Modifier.weight(1f))
            Text("How far we should get depends on each team", Modifier.showIf(step > 1))
            Spacer(Modifier.weight(1f))
            Text("MyResult vs try-catch has a bigger impact than it may seem", Modifier.showIf(step > 2))
            Spacer(Modifier.height(8.dp))
            Text(
                styled(MyStyleSheet) { "Like ${+code}val${-code} vs ${+code}final X${-code}: in Kotlin we use immutability much more than in java" },
                Modifier.showIf(step > 2),
                style = MaterialTheme.typography.bodyMedium,
            )
            Spacer(Modifier.weight(2f))
        }
    }
}
