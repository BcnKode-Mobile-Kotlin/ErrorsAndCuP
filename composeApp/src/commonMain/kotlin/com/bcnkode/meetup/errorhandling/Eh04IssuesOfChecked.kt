package com.bcnkode.meetup.errorhandling

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bcnkode.meetup.MyStyleSheet
import com.bcnkode.meetup.composables.Code
import com.bcnkode.meetup.layouts.Bullet
import com.bcnkode.meetup.layouts.BulletListDetail
import com.bcnkode.meetup.layouts.TitleAndContentScaffold
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.speaker.SpeakerNotes
import net.kodein.cup.ui.styled

val issuesOfCheckedErrorHandling by Slide(
    user = SpeakerNotes(
        """
            PROPAGATION: When you propagate an exception across layers, you handle a low level error (like IO) far from where it happens.
        """.trimIndent()
    ),
    stepCount = 5,
) { step ->
    TitleAndContentScaffold(
        title = "History",
        subtitle = "Issues with checked exceptions",
    ) {
        val javaCode = rememberSourceCode(language = "kotlin") { JAVA_CODE }
        val propagationCode = rememberSourceCode(language = "kotlin") { PROPAGATION_CODE }
        val lambdaCode = rememberSourceCode(language = "kotlin") { LAMBDA_CODE }

        BulletListDetail(
            bullets = listOf(
                Bullet("Catch and ignore") {
                    Column {
                        Text(
                            "try-catch boilerplate\n+\nforced to handle exceptions\n=\nignored exceptions",
                            Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                        )
                        Spacer(Modifier.height(16.dp))
                        Code(javaCode, Modifier)
                    }
                },
                Bullet("Propagation") {
                    Code(propagationCode, Modifier)
                },
                Bullet("Functional issues") {
                    Column {
                        Text(
                            "Lambdas in Java and Kotlin don't handle checked exceptions.\n\nWe can't propagate them:",
                            Modifier.fillMaxWidth(),
                        )
                        Spacer(Modifier.height(8.dp))
                        Code(lambdaCode, Modifier)
                    }
                },
                Bullet("Adding exceptions") {
                    Text(styled(MyStyleSheet) { "When adding a new exception...\n\nYou need to add ${+code}throws MyException${-code} in all layers until the place you handle your exceptions." })
                },
                Bullet("Where to catch") {
                    Text("We should handle exceptions at the perimeter:\n\nFile reading, API calls, system interaction...")
                },
            ),
            step = step,
            leftPercentage = 0.3f,
        )
    }
}

private val JAVA_CODE = """
try {
    FileReader reader = new FileReader("config.txt");
} catch (IOException e) {
    // Handle the exception
}
""".trimIndent()

private val PROPAGATION_CODE = """
public class MyDataSource {
    public void readMyFile() throws IOException {...}
}

public class MyUseCase {
    public String execute() throws IOException {...}
}

public class MyPresenter {
    public void present() {
        try {
            myUseCase.execute()        
        } catch (IOException e) {
            // What is this exception?
        }
    }
}
""".trimIndent()

private val LAMBDA_CODE = """
List<String> fileContents = filePaths.stream()
    .map(path -> {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            return "Error reading file"; 
        }
    })
    .collect(Collectors.toList());
""".trimIndent()
