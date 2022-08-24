package ch.css.kata.questionnaire.domain;

import java.util.List;

@FunctionalInterface
public interface PollReader {
     List<Poll> readPolls();
}
