import org.jetbrains.compose.desktop.application.dsl.TargetFormat

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
            implementation(libs.cup.laser)
            implementation(libs.cup.sourceCode)
            implementation(libs.cup.speakerWindow)
            implementation(libs.cup.widgets.material3)
            implementation(libs.emoji.compose)
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.bcnkode.meetup.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.bcnkode.meetup"
            packageVersion = "1.0.0"
        }
    }
}

tasks.withType<Copy>().configureEach {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}