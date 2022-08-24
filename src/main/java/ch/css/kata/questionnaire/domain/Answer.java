package ch.css.kata.questionnaire.domain;

public record Answer(String value) {
    public static final Answer DEFAULT_ANSWER = new Answer("I don't know");
}
