package util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        Logger.getLogger(Quiz.class.getName()).log(Level.INFO, "Question Added: {0}", question.getPrompt());
        Logger.getLogger(Quiz.class.getName()).log(Level.INFO, "{0} options added", question.getNumOptions());
        Logger.getLogger(Quiz.class.getName()).log(Level.INFO, "Options Added: {0}", question.getOptions());
        questions.add(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public int getNumQuestions() {
        return questions.size();
    }

    public String getQuestions() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            result.append("Question ").append(i + 1).append(": ").append(question.getQuestion()).append("\n");
            for (int j = 0; j < question.getNumOptions(); j++) {
                result.append("Option ").append(j + 1).append(": ").append(question.getOption(j)).append("\n");
            }
            result.append("Correct Answer: ").append(question.getCorrectAnswerIndex()).append("\n\n");
        }
        return result.toString();
    }
}
