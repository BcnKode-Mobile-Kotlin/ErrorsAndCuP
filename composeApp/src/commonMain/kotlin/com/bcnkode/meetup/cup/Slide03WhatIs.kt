package com.bcnkode.meetup.cup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import com.bcnkode.meetup.layouts.TwoPanes
import meetup_cup.composeapp.generated.resources.Res
import meetup_cup.composeapp.generated.resources.cmp_logo
import meetup_cup.composeapp.generated.resources.kotlin_logo
import net.kodein.cup.Slide
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.painterResource

val whatIsCuP by Slide(
    user = SpeakerNotes(
        """
            
        """.trimIndent()
    ),
) {
    TitleAndContentScaffold(
        title = "What is",
    ) {
        TwoPanes(
            leftContent = {
                Text(
                    text = styled {
                        "${+b}CuP${-b} helps you declare your presentation in Kotlin using Compose Multiplatform"
                    },
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            },
            rightContent = {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(Res.drawable.kotlin_logo),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Image(
                        painter = painterResource(Res.drawable.cmp_logo),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                    )
                }
            },
        )
    }
}