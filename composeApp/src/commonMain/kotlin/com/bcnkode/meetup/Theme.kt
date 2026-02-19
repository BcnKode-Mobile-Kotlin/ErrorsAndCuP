package com.bcnkode.meetup

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import meetup_cup.composeapp.generated.resources.Montserrat_Black
import meetup_cup.composeapp.generated.resources.Montserrat_BlackItalic
import meetup_cup.composeapp.generated.resources.Montserrat_Bold
import meetup_cup.composeapp.generated.resources.Montserrat_BoldItalic
import meetup_cup.composeapp.generated.resources.Montserrat_ExtraBold
import meetup_cup.composeapp.generated.resources.Montserrat_ExtraBoldItalic
import meetup_cup.composeapp.generated.resources.Montserrat_ExtraLight
import meetup_cup.composeapp.generated.resources.Montserrat_ExtraLightItalic
import meetup_cup.composeapp.generated.resources.Montserrat_Italic
import meetup_cup.composeapp.generated.resources.Montserrat_Light
import meetup_cup.composeapp.generated.resources.Montserrat_LightItalic
import meetup_cup.composeapp.generated.resources.Montserrat_Medium
import meetup_cup.composeapp.generated.resources.Montserrat_MediumItalic
import meetup_cup.composeapp.generated.resources.Montserrat_Regular
import meetup_cup.composeapp.generated.resources.Montserrat_SemiBold
import meetup_cup.composeapp.generated.resources.Montserrat_SemiBoldItalic
import meetup_cup.composeapp.generated.resources.Montserrat_Thin
import meetup_cup.composeapp.generated.resources.Montserrat_ThinItalic
import meetup_cup.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun BcnKodeTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            background = Color(0xFF141530),
            onBackground = Color.White,
            primary = Color.White,
            secondary = Color(0xFFD9D9D9),
        ),
        typography = typography,
    ) {
        content()
    }
}

private val montserratFontFamily: FontFamily
    @Composable get() = FontFamily(
        Font(Res.font.Montserrat_Black, weight = FontWeight.Black),
        Font(Res.font.Montserrat_BlackItalic, weight = FontWeight.Black, style = FontStyle.Italic),
        Font(Res.font.Montserrat_Bold, weight = FontWeight.Bold),
        Font(Res.font.Montserrat_BoldItalic, weight = FontWeight.Bold, style = FontStyle.Italic),
        Font(Res.font.Montserrat_ExtraBold, weight = FontWeight.ExtraBold),
        Font(Res.font.Montserrat_ExtraBoldItalic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
        Font(Res.font.Montserrat_ExtraLight, weight = FontWeight.ExtraLight),
        Font(Res.font.Montserrat_ExtraLightItalic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
        Font(Res.font.Montserrat_Italic, style = FontStyle.Italic),
        Font(Res.font.Montserrat_Light, weight = FontWeight.Light),
        Font(Res.font.Montserrat_LightItalic, weight = FontWeight.Light, style = FontStyle.Italic),
        Font(Res.font.Montserrat_Medium, weight = FontWeight.Medium),
        Font(Res.font.Montserrat_MediumItalic, weight = FontWeight.Medium, style = FontStyle.Italic),
        Font(Res.font.Montserrat_Regular),
        Font(Res.font.Montserrat_SemiBold, weight = FontWeight.SemiBold),
        Font(Res.font.Montserrat_SemiBoldItalic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
        Font(Res.font.Montserrat_Thin, weight = FontWeight.Thin),
        Font(Res.font.Montserrat_ThinItalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    )

private val typography: Typography
    @Composable get() = Typography(
        displayLarge = TextStyle(
            fontFamily = montserratFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        ),
        displayMedium = TextStyle(
            fontFamily = montserratFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = montserratFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        ),
    )
