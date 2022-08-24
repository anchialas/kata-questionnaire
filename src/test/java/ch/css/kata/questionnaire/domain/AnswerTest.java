package ch.css.kata.questionnaire.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {

    @Test
    void value_happy_case() {
        String EXPECTED_ANSWER = "Answer";
        Answer testee = new Answer(EXPECTED_ANSWER);

        String actual = testee.value();

        assertThat(actual).isEqualTo(EXPECTED_ANSWER);
    }

}
