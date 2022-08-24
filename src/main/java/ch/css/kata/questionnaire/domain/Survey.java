package ch.css.kata.questionnaire.domain;

import java.util.ArrayList;
import java.util.List;

public class Survey {

    private final List<Poll> polls;
    private final List<Reply> replies;

    public Survey(PollReader pollReader) {
        this.polls = pollReader.readPolls();
        this.replies = new ArrayList<>(polls.size());
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public long getNumberOfQuestions() {
        return polls.size();
    }

    public long getNumberOfReplies() {
        return replies.size();
    }

    public long getSuccessCount() {
        return replies.stream().filter(Reply::isCorrect).count();
    }

    public String getSuccessRate() {
        if (getNumberOfReplies() == 0) {
            return "0%";
        }
        return String.format("%.1f%%", 100.0 * getSuccessCount() / getNumberOfReplies());
    }

}
