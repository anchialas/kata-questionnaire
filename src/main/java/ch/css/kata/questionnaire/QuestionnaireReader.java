package ch.css.kata.questionnaire;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class QuestionnaireReader {

    public static final String QUESTIONNAIRE_FILE = "/questionnaire.txt";

    public String read() throws URISyntaxException, IOException {
        Path filePath = Path.of(getClass().getResource(QUESTIONNAIRE_FILE).toURI());
        return Files.readString(filePath);

    }
}
