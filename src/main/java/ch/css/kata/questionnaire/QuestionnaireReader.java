package ch.css.kata.questionnaire;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class QuestionnaireReader {

    public static final String QUESTIONNAIRE_FILE = "/questionnaire.txt";
    public static final String QUESTION_MARK = "?";

    List<String> read() throws URISyntaxException, IOException {
        Path filePath = Path.of(getClass().getResource(QUESTIONNAIRE_FILE).toURI());
        return Files.readAllLines(filePath);

    }

    public List<List<String>> readPolls() throws URISyntaxException, IOException {
        int[] index = new int[]{0};

        return new ArrayList<>(read().stream().collect(groupingBy(str -> {
            if (str.startsWith(QUESTION_MARK)) {
                index[0]++;
            }
            return index[0];
        })).values());
    }


}
