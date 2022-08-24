package ch.css.kata.questionnaire;

import ch.css.kata.questionnaire.domain.Answer;
import ch.css.kata.questionnaire.domain.Poll;
import ch.css.kata.questionnaire.domain.Reply;
import ch.css.kata.questionnaire.domain.Survey;

import java.util.Map;
import java.util.Scanner;

public class QuestionnaireApp {
    private final Scanner consoleInput;

    private QuestionnaireApp() {
        System.out.println("Questionnaire (press 'q' to Quit and show the Score)");
        consoleInput = new Scanner(System.in);
    }

    public static void main(String... args) {
        QuestionnaireApp app = new QuestionnaireApp();
        app.start();
    }

    private String readInput() {
        return consoleInput.next();
    }

    private void writeOutput(String text) {
        System.out.println(text);
    }

    private void start() {
        Survey survey = new Survey(new QuestionnaireReader());
        for (Poll poll : survey.getPolls()) {
            Answer answer = askPoll(poll);
            if (answer == null) {
                break;
            }
            survey.addReply(new Reply(poll, answer));
        }

        writeOutput("Your Score:");
        writeOutput("%d out of %d questions answered correctly (%s)".formatted(
                survey.getSuccessCount(),
                survey.getNumberOfReplies(),
                survey.getSuccessRate()
        ));
        survey.getReplies().forEach(this::writeReplySummary);
    }

    private void writeReplySummary(Reply reply) {
        writeOutput(reply.toString());
    }

    private Answer askPoll(Poll poll) {
        writeOutput(poll.question().value());

        Map<Integer, Answer> indexedAnswers = poll.options().getIndexedAnswers();
        indexedAnswers.forEach((key, value) -> writeOutput(" (%d) %s".formatted(key + 1, value.value())));

        writeOutput("Your answer (%d-%d)? ".formatted(1, indexedAnswers.size()));
        while (true) {
            String input = readInput();
            try {
                int index = Integer.parseInt(input);
                Answer answer = indexedAnswers.get(index - 1);
                if (answer != null) {
                    return answer;
                }
                writeOutput("Invalid answer number '%s'".formatted(input));
            } catch (NumberFormatException ex) {
                if ("q".equals(input)) {
                    return null;
                }
                writeOutput("Unknown command '%s'".formatted(input));
            }
        }

    }
}
