package com.bcnkode.meetup

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.bcnkode.meetup.cup.advancedAnimationsCuP
import com.bcnkode.meetup.cup.advantagesCuP
import com.bcnkode.meetup.cup.applicationCuP
import com.bcnkode.meetup.cup.configurationCuP
import com.bcnkode.meetup.cup.slidesCuP
import com.bcnkode.meetup.cup.animatedContentCuP
import com.bcnkode.meetup.cup.customStyleCuP
import com.bcnkode.meetup.cup.introCuP
import com.bcnkode.meetup.cup.slidesIndexCuP
import com.bcnkode.meetup.cup.styleCuP
import com.bcnkode.meetup.cup.whatIsCuP
import com.bcnkode.meetup.errorhandling.arrowEitherErrorHandling
import com.bcnkode.meetup.errorhandling.errorModelsErrorHandling
import com.bcnkode.meetup.errorhandling.exhaustiveErrorErrorHandling
import com.bcnkode.meetup.errorhandling.explicitErrorsErrorHandling
import com.bcnkode.meetup.errorhandling.goodOfCheckedErrorHandling
import com.bcnkode.meetup.errorhandling.indexErrorHandling
import com.bcnkode.meetup.errorhandling.introErrorHandling
import com.bcnkode.meetup.errorhandling.issuesOfCheckedErrorHandling
import com.bcnkode.meetup.errorhandling.kotlinResultErrorHandling
import com.bcnkode.meetup.errorhandling.logicOrExceptionsErrorHandling
import com.bcnkode.meetup.errorhandling.myResultErrorHandling
import com.bcnkode.meetup.errorhandling.needForRaiseErrorHandling
import com.bcnkode.meetup.errorhandling.performanceErrorHandling
import com.bcnkode.meetup.errorhandling.railwayOrientedErrorHandling
import com.bcnkode.meetup.errorhandling.raiseContextParametersErrorHandling
import com.bcnkode.meetup.errorhandling.unionTypesErrorHandling
import net.kodein.cup.Presentation
import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.cup.laser.laser
import net.kodein.cup.speaker.speakerWindow
import org.kodein.emoji.compose.EmojiService

fun main() = cupApplication(title = "Gestión de errors y slides en Kotlin") {
    remember {
        EmojiService.initialize()
    }
    BcnKodeTheme {
        SlidesPresentation()
    }
}

@Composable
fun SlidesPresentation() {
    Presentation(
        slides = presentationSlides,
        configuration = {
            laser()
            speakerWindow()

            /*defaultSlideSpecs = SlideSpecs(
                size = SLIDE_SIZE_16_9,

            )*/
        },
        backgroundColor = Color.Black,
    ) { slidesContent ->
        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onBackground) {
            slidesContent()
        }
    }
}

val errorHandlingSlides = Slides(
    introErrorHandling,
    indexErrorHandling,
    goodOfCheckedErrorHandling,
    issuesOfCheckedErrorHandling,
    performanceErrorHandling,
    explicitErrorsErrorHandling,
    kotlinResultErrorHandling,
    arrowEitherErrorHandling,
    myResultErrorHandling,
    exhaustiveErrorErrorHandling,
    errorModelsErrorHandling,
    logicOrExceptionsErrorHandling,
    railwayOrientedErrorHandling,
    needForRaiseErrorHandling,
    raiseContextParametersErrorHandling,
    unionTypesErrorHandling,
)

val slides = Slides(
    introCuP,
    slidesIndexCuP,
    whatIsCuP,
    advantagesCuP,
    configurationCuP,
    applicationCuP,
    slidesCuP,
    animatedContentCuP,
    advancedAnimationsCuP,
    styleCuP,
    customStyleCuP,
)

val presentationSlides = Slides(
    errorHandlingSlides,
    slides,
)
