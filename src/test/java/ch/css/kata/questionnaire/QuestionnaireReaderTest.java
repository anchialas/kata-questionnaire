package ch.css.kata.questionnaire;

import ch.css.kata.questionnaire.domain.Answer;
import ch.css.kata.questionnaire.domain.Options;
import ch.css.kata.questionnaire.domain.Poll;
import ch.css.kata.questionnaire.domain.Question;
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

        List<Poll> actual = testee.readPolls();

        assertThat(actual).hasSize(expectedPollCount);
        assertThat(actual.get(0)).isEqualTo(new Poll(
                new Question("Which of these animals is a mammal?"),
                new Options(List.of(
                        new Answer("Ant"),
                        new Answer("Bee"),
                        new Answer("Cat")
                )),
                new Answer("Cat")
        ));
    }
}
