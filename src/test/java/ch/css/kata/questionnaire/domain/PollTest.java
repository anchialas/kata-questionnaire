package ch.css.kata.questionnaire.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PollTest {

    @Test
    void isAnswerCorrect_happy_case() {
        Question question = new Question("Was gibt 1+1?");
        Options options = new Options(List.of(
                new Answer("1"),
                new Answer("2"),
                new Answer("3")
        ));
        Answer correctAnswer = new Answer("2");
        Poll testee = new Poll(question, options, correctAnswer);

        boolean actual = testee.isAnswerCorrect(new Answer("2"));

        assertThat(actual).isTrue();
    }

}