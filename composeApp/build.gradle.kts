plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.cup)
}

cup {
    targetDesktop()
    targetWeb()
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.material3)
            implementation(libs.compose.emoji)
            implementation(libs.cup.laser)
            implementation(libs.cup.sourceCode)
            implementation(libs.cup.speakerWindow)
            implementation(libs.cup.widgets.material3)
        }
    }
}
