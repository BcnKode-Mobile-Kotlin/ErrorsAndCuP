package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.MyStyleSheet.code
import com.bcnkode.meetup.Sizes
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import net.kodein.cup.widgets.material3.BulletPoints

/*fun a(result: Failure<GenericApiError>) {
when (result.error) {
    GenericApiError.NoInternet -> TODO()
    GenericApiError.Network -> TODO()
    GenericApiError.Server -> TODO()
    GenericApiError.Unknown -> TODO()
}
}*/

val exhaustiveErrorErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) {
    val handlingCode = rememberSourceCode(language = "kotlin") {
        """
enum class GenericApiError : ApiError<Nothing> {
    NoInternet,
    Network,
    Server,
    Unknown,
}
            
when (result.error) {
    GenericApiError.NoInternet -> TODO()
    GenericApiError.Network -> TODO()
    GenericApiError.Server -> TODO()
    GenericApiError.Unknown -> TODO()
}
""".trimIndent()
    }

    TitleAndContentScaffold(
        title = "Present: modeling results",
        subtitle = "Modeling errors exhaustively",
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(1f))
            Text("Using enums and sealed hierarchies lets us be exhaustive")
            Spacer(Modifier.height(8.dp))
            Pane(Modifier.align(Alignment.CenterHorizontally)) {
                SourceCode(
                    handlingCode,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
            Spacer(Modifier.weight(1f))
        }
    }
}
