package ch.css.kata.questionnaire.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionTest {

    @Test
    void value_happy_case() {
        String questionText = "Was gibt 1+1?";
        Question testee = new Question(questionText);

        String actual = testee.value();

        assertThat(actual).isEqualTo(questionText);
    }

}