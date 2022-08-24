package ch.css.kata.questionnaire.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SurveyTest {

    @Test
    void getSuccessRate() {
        Poll poll1 = new Poll(
                new Question("Was gibt 1+1?"),
                new Options(List.of(
                        new Answer("1"),
                        new Answer("2")
                )),
                new Answer("2")
        );
        Poll poll2 = new Poll(
                new Question("Was gibt 1-1?"),
                new Options(List.of(
                        new Answer("0"),
                        new Answer("1")
                )),
                new Answer("0")
        );
        Reply reply1 = new Reply(poll1, new Answer("1"));
        Reply reply2 = new Reply(poll2, new Answer("0"));
        Survey testee = new Survey(List.of(poll1, poll2), List.of(reply1, reply2));

        String actual = testee.getSuccessRate();

        assertThat(actual).isEqualTo("50.0%");
    }
}