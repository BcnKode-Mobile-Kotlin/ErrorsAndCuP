package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.widgets.material3.BulletPoints

sealed class Either<out A, out B> {
    data class Left<out A>(val value: A) : Either<A, Nothing>()
    data class Right<out B>(val value: B) : Either<Nothing, B>()
    // ...
}
val arrowEitherErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) {
    val resultCode = rememberSourceCode(language = "kotlin") {
        """
sealed class Either<out A, out B> {
    data class Left<out A>(val value: A) : Either<A, Nothing>()
    data class Right<out B>(val value: B) : Either<Nothing, B>()
    // ...
}
""".trimIndent()
    }

    TitleAndContentScaffold(
        title = "Present: modeling results",
        subtitle = "Arrow's Either type",
        contentAlignment = Alignment.Center,
    ) {
        Column(Modifier.fillMaxHeight()) {
            Spacer(Modifier.weight(3f))
            Text("Better error types, non-ideal naming")
            Spacer(Modifier.height(8.dp))
            Pane(Modifier.align(Alignment.CenterHorizontally)) {
                SourceCode(
                    resultCode,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
            Spacer(Modifier.weight(3f))
        }
    }
}
