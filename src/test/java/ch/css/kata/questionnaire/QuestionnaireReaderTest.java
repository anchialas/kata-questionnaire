package ch.css.kata.questionnaire;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionnaireReaderTest {

    private final QuestionnaireReader testee = new QuestionnaireReader();

    @Test
    void read_all_lines() throws Exception {
        int expectedLineCount = 8;

        List<String> actual = testee.read();

        assertThat(actual).hasSize(expectedLineCount);
    }

    @Test
    void read_all_polls() throws Exception {
        int expectedPollCount = 2;

        List<List<String>> actual = testee.readPolls();

        assertThat(actual).hasSize(expectedPollCount);
    }

}
