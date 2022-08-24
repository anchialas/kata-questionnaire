package ch.css.kata.questionnaire;

import ch.css.kata.questionnaire.domain.Answer;
import ch.css.kata.questionnaire.domain.Options;
import ch.css.kata.questionnaire.domain.Poll;
import ch.css.kata.questionnaire.domain.Question;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class QuestionnaireReader {

    public static final String QUESTIONNAIRE_FILE = "/questionnaire.txt";
    public static final String QUESTION_MARK = "?";
    public static final String CORRECT_ANSWER_MARK = "*";

    List<String> read() throws URISyntaxException, IOException {
        Path filePath = Path.of(getClass().getResource(QUESTIONNAIRE_FILE).toURI());
        return Files.readAllLines(filePath);
    }

    public List<Poll> readPolls() throws URISyntaxException, IOException {
        AtomicInteger index = new AtomicInteger();
        Map<Integer, List<String>> questionMap = read().stream().collect(groupingBy(line -> getQuestionIndex(index, line)));
        return questionMap.values().stream().map(this::toPoll).collect(toList());
    }

    private int getQuestionIndex(AtomicInteger index, String line) {
        if (line.startsWith(QUESTION_MARK)) {
            index.incrementAndGet();
        }
        return index.get();
    }

    private Poll toPoll(List<String> lines) {
        Question question = toQuestion(lines.remove(0));

        Answer correctAnswer = null;
        List<Answer> answers = new ArrayList<>();
        for (String answerLine : lines) {
            final Answer answer;
            if (answerLine.startsWith(CORRECT_ANSWER_MARK)) {
                answer = new Answer(answerLine.substring(1));
                if (correctAnswer != null) {
                    throw new IllegalArgumentException("Frage hat mehr als eine Antwort: " + question.value());
                }
                correctAnswer = answer;
            } else {
                answer = new Answer(answerLine);
            }
            answers.add(answer);
        }
        return new Poll(question, new Options(answers), correctAnswer);
    }

    private Question toQuestion(String questionLine) {
        return new Question(questionLine.substring(1) + "?");
    }

}
