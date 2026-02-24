package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val conclusionErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 1,
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
        Column {

            Spacer(Modifier.weight(2f))
            Text("Each tool requires more effort in learning, but it helps a bit more")
            Spacer(Modifier.height(8.dp))
            Text("Try-catch → MyResult → Raise", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.weight(1f))
            Text("How far should we get, depends on each team")
            Spacer(Modifier.weight(1f))
            Text("MyResult vs try-catch has a bigger effect than it may seem")
            Spacer(Modifier.height(8.dp))
            Text(styled(MyStyleSheet) { "Like ${+code}val${-code} vs ${+code}final X${-code}: in Kotlin we use immutability much more than in java" }, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.weight(2f))
        }
    }
}
