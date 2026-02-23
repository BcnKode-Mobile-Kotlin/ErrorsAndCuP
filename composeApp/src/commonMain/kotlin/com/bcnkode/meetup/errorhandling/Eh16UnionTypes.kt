package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.Sizes
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

val unionTypesErrorHandling by Slide(
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
        title = "A bright future",
        subtitle = "Kotlin union types (upcoming)",
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text("First the result, then the error")
            Spacer(Modifier.height(8.dp))
            Pane {
                SourceCode(
                    simpleUnionCode,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }

            Spacer(Modifier.height(24.dp))

            Text(styled(MyStyleSheet) { "It is not sealed, we can combine them, but only ${+code}Error${-code}s" })
            Spacer(Modifier.height(8.dp))
            Pane {
                SourceCode(
                    longUnionCode,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
        }
    }
}
