package com.bcnkode.meetup.cup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.kodein.cup.Slide

val finishCuP by Slide {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var showGoodbye by remember { mutableStateOf(false) }
        Button(onClick = { showGoodbye = !showGoodbye }) {
            Text(text = "Click here!", color = MaterialTheme.colorScheme.background)
        }
        if (showGoodbye) {
            Text("Thank you so much")
            Text("Any questions?")
        }
    }
}