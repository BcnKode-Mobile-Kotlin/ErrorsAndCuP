package com.bcnkode.meetup.composables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcnkode.meetup.layouts.Pane
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeThemes

@Composable
fun Code(code: SourceCode, modifier: Modifier = Modifier.padding(12.dp)) {
    SourceCode(
        code,
        modifier = modifier,
        style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 8.sp),
        theme = SourceCodeThemes.darcula,
    )
}

@Composable
fun CodeInPane(code: SourceCode, modifier: Modifier = Modifier) {
    Pane(modifier = modifier) {
        Code(code)
    }
}

@Composable
fun ColumnScope.CodeInPaneWithTitle(
    title: String,
    code: SourceCode,
    modifier: Modifier = Modifier,
) {
    Text(title, style = MaterialTheme.typography.bodyMedium)
    Spacer(Modifier.height(8.dp))
    Pane(modifier = modifier) {
        Code(code)
    }
}

@Composable
fun ColumnScope.CodeInPaneWithTitle(
    title: AnnotatedString,
    code: SourceCode,
    modifier: Modifier = Modifier,
) {
    Text(title, style = MaterialTheme.typography.bodyMedium)
    Spacer(Modifier.height(8.dp))
    Pane(modifier = modifier) {
        Code(code)
    }
}
