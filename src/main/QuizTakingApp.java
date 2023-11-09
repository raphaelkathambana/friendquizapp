package main;

import java.util.List;

import javax.swing.SwingUtilities;

import ui.QuizTakingUI;
import util.Question;
import util.Quiz;

public class QuizTakingApp {
    public static void main(String[] args) {
        // Create a quiz
        Quiz quiz = new Quiz();
        Question question1 = new Question("What is the capital of France?", List.of("Paris", "London", "Berlin", "Rome"), 0);
        Question question2 = new Question("What is the largest planet in our solar system?", List.of("Jupiter", "Saturn", "Mars", "Earth"), 2);
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);

        // Create and start the QuizTakingGUI
        SwingUtilities.invokeLater(() -> new QuizTakingUI(quiz));
    }
}
