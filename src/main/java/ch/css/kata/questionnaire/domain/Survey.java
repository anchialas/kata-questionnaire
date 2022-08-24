package ch.css.kata.questionnaire.domain;

import java.util.List;

public class Survey {

    private final List<Poll> polls;
    private final List<Reply> replies;

    public Survey(List<Poll> polls, List<Reply> replies) {
        this.polls = polls;
        this.replies = replies;
    }

    public long getNumberOfQuestions() {
        return polls.size();
    }

    public long getSuccessCount() {
        return replies.stream().filter(Reply::isCorrect).count();
    }

    public String getSuccessRate() {
        return String.format("%.1f%%", 100.0 * getSuccessCount() / getNumberOfQuestions());
    }
}
