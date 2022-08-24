package ch.css.kata.questionnaire.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OptionsTest {

    @Test
    void answers_has_one_entry() {
        List<Answer> expectedAnswers = List.of(new Answer("I don't know"));
        Options testee = new Options(expectedAnswers);

        List<Answer> actualAnswers = testee.answers();

        assertThat(actualAnswers).hasSize(expectedAnswers.size());
    }

}
