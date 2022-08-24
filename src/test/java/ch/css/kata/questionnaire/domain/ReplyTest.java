package ch.css.kata.questionnaire.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReplyTest {

    @Test
    void toString_correctAnswer_outputOk() {
        Poll poll = new Poll(
                new Question("Was gibt 1+1?"),
                new Options(List.of(
                        new Answer("1"),
                        new Answer("2")
                )),
                new Answer("2")
        );
        Reply testee = new Reply(poll, new Answer("2"));

        String actual = testee.toString();

        assertThat(actual).isEqualTo("""
                Was gibt 1+1?
                   Your answer '2' is correct""");
    }

    @Test
    void toString_wrongAnswer_outputOk() {
        Poll poll = new Poll(
                new Question("Was gibt 1+1?"),
                new Options(List.of(
                        new Answer("1"),
                        new Answer("2")
                )),
                new Answer("2")
        );
        Reply testee = new Reply(poll, new Answer("1"));

        String actual = testee.toString();

        assertThat(actual).isEqualTo("""
                Was gibt 1+1?
                   Your answer '1' is wrong
                   Correct answer: '2'""");

    }
}