package ch.css.kata.questionnaire.domain;

import static java.util.Objects.requireNonNull;

/**
 * Repräsentiert eine Frage mit allen möglichen Antwortmöglichkeiten und der korrekten Antwort.
 */
record Poll(Question question, Options options, Answer correctAnswer) {
    Poll {
        requireNonNull(question);
        requireNonNull(options);
        requireNonNull(correctAnswer);
    }

    boolean isAnswerCorrect(Answer answer) {
        return correctAnswer.equals(answer);
    }

}
