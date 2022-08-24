package ch.css.kata.questionnaire;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionnaireReaderTest {

    private final QuestionnaireReader testee = new QuestionnaireReader();

    @Test
    void read_happy_case() throws Exception {
        String content = testee.read();

        assertThat(content).isEqualTo("hello");
    }

}