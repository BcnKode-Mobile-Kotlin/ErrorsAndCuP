package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.Pane
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes

sealed interface ApiError<out E>
enum class GenericApiError : ApiError<Nothing> {
    NoInternet,
    Network,
    Server,
    Unknown,
}
data class ControlledApiError<T>(val error: T) : ApiError<T>

sealed interface UiDataError
enum class UiGenericDataError : UiDataError { NoInternet, Generic }
data class SpecificUiError<T>(val error: T) : UiDataError

fun GenericApiError.toBasicUi() =
    when (this) {
        GenericApiError.NoInternet -> UiGenericDataError.NoInternet
        GenericApiError.Network, GenericApiError.Server, GenericApiError.Unknown -> {
            UiGenericDataError.Generic
        }
    }

fun <ApiE, UiE> ApiError<ApiE>.toUiError(mapper: (ApiE) -> UiE) =
    when (this) {
        is ControlledApiError<ApiE> -> SpecificUiError(mapper(this.error))
        is GenericApiError -> this.toBasicUi()
    }

val errorModelsErrorHandling by Slide(
    user = SpeakerNotes(
        """
            Data should not return specific network errors like 401.
            UI does not care about all errors, so we map
        """.trimIndent()
    ),
) {
    val handlingCode = rememberSourceCode(language = "kotlin") {
        """
sealed interface ApiError<out E>
enum class GenericApiError : ApiError<Nothing> {
    NoInternet,
    Network,
    Server,
    Unknown,
}
data class ControlledApiError<T>(val error: T) : ApiError<T>
""".trimIndent()
    }

    val mappingCode = rememberSourceCode(language = "kotlin") {
            """
sealed interface UiDataError
enum class UiGenericDataError : UiDataError { NoInternet, Generic }
data class SpecificUiError<T>(val error: T) : UiDataError

fun GenericApiError.toBasicUi() =
    when (this) {
        GenericApiError.NoInternet -> UiGenericDataError.NoInternet
        GenericApiError.Network, GenericApiError.Server, GenericApiError.Unknown -> {
            UiGenericDataError.Generic
        }
    }
""".trimIndent()
        }

    TitleAndContentScaffold(
        title = "Present: modeling results",
        subtitle = "Modeling errors across layers",
    ) {
        Column(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(1f))
            Pane(Modifier.align(Alignment.CenterHorizontally)) {
                SourceCode(
                    handlingCode,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
            Spacer(Modifier.height(8.dp))
            Pane(Modifier.align(Alignment.CenterHorizontally)) {
                SourceCode(
                    mappingCode,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
                    theme = SourceCodeThemes.darcula,
                )
            }
            Spacer(Modifier.weight(1f))
        }
    }
}
