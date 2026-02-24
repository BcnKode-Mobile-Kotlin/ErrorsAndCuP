package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import com.bcnkode.meetup.composables.CodeInPaneWithTitle
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import net.kodein.cup.widgets.material3.BulletPoints

sealed class MyResult<out V, out E>
data class Success<out V>(val value: V) : MyResult<V, Nothing>()
data class Failure<out E>(val error: E) : MyResult<Nothing, E>()

inline fun <V, E, U> MyResult<V, E>.map(
    transform: (V) -> U,
): MyResult<U, E> = when (this) {
    is Success -> Success(transform(value))
    is Failure -> this
}

inline fun <V, E, F> MyResult<V, E>.mapError(
    transform: (E) -> F,
): MyResult<V, F> = when (this) {
    is Success -> this
    is Failure -> Failure(transform(error))
}

val myResultErrorHandling by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
    stepCount = 3,
) { step ->
    val resultCode = rememberSourceCode(language = "kotlin") {
        val highlight by marker(highlighted(1))
        """
sealed class ${highlight}MyResult${X}<out V, out E>
data class ${highlight}Success${X}<out V>(val value: V) : MyResult<V, Nothing>()
data class ${highlight}Failure${X}<out E>(val error: E) : MyResult<Nothing, E>()

inline fun <V, E, U> MyResult<V, E>.map(
    transform: (V) -> U,
): MyResult<U, E> = when (this) {
    is Success -> Success(transform(value))
    is Failure -> this
}

inline fun <V, E, F> MyResult<V, E>.mapError(
    transform: (E) -> F,
): MyResult<V, F> = when (this) {
    is Success -> this
    is Failure -> Failure(transform(error))
}
""".trimIndent()
    }

    TitleAndContentScaffold(
        title = "Present: modeling results",
        subtitle = "Custom solution: MyResult",
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(1f))
            CodeInPaneWithTitle(
                "Like Either, but better naming*",
                resultCode,
                Modifier.align(Alignment.CenterHorizontally),
                step = step,
            )
            Spacer(Modifier.weight(1f))
            Text(
                styled(MyStyleSheet) { "* Prefix ${+code}My${-code} is because we cannot remove ${+code}kotlin.Result${-code} from autoimport" },
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.weight(1f))
        }
    }
}
