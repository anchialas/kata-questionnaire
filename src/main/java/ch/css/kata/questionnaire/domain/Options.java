package ch.css.kata.questionnaire.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;

public record Options(List<Answer> answers) {

    public Options(List<Answer> answers) {
        requireNonNull(answers);
        this.answers = new ArrayList<>(answers);
        this.answers.add(Answer.DEFAULT_ANSWER);
    }

    public Map<Integer, Answer> getIndexedAnswers() {
        AtomicInteger index = new AtomicInteger();
        return answers.stream().collect(toMap(x -> index.getAndIncrement(), Function.identity()));
    }
}
