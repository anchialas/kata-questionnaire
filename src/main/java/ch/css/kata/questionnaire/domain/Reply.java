package ch.css.kata.questionnaire.domain;

import static java.util.Objects.requireNonNull;

public record Reply(Poll poll, Answer choosenAnswer) {

    public Reply {
        requireNonNull(poll);
        requireNonNull(choosenAnswer);
    }

    public boolean isCorrect() {
        return poll.isAnswerCorrect(choosenAnswer);
    }

    public String toString() {
        return poll.question().value()
                + "\n   Your answer '" + choosenAnswer.value() + "' is " + (isCorrect() ? "correct" : "wrong")
                + (isCorrect() ? "" : "\n   Correct answer: '" + poll.correctAnswer().value() + "'");
    }
}
