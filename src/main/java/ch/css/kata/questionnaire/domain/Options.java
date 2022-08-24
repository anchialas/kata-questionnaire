package ch.css.kata.questionnaire.domain;

import java.util.List;

import static java.util.Objects.requireNonNull;

public record Options(List<Answer> answers) {

    public Options {
        requireNonNull(answers);
    }
}
