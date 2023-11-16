package ui;

import java.awt.*;
import java.util.List;
import javax.swing.*;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;

import util.Question;
import util.Quiz;

public class QuizTakingUI {
    private JFrame frame;
    private JPanel quizPanel;
    private JTextArea questionTextArea;
    private ButtonGroup optionGroup;
    private JRadioButton[] optionRadioButtons;
    private JButton nextButton;
    private Quiz quiz;
    private int timeRemaining;
    private JLabel timerLabel;
    private Timer timer;
    private int currentQuestionIndex;

    public QuizTakingUI(Quiz quiz) {
        this.quiz = quiz;
        this.currentQuestionIndex = 0;
        this.timeRemaining = 60; // 60 seconds for each question

        frame = new JFrame("Quiz Taking");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        quizPanel = new JPanel(new GridLayout(0, 1));

        questionTextArea = new JTextArea(5, 20);
        questionTextArea.setWrapStyleWord(true);
        questionTextArea.setLineWrap(true);
        questionTextArea.setOpaque(false);
        questionTextArea.setEditable(false);

        optionGroup = new ButtonGroup();

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            int selectedOptionIndex = getSelectedOptionIndex();
            int correctAnswerIndex = quiz.getQuestion(currentQuestionIndex).getCorrectAnswerIndex();

            currentQuestionIndex++;

            if (currentQuestionIndex < quiz.getNumQuestions()) {
                processAnswer(selectedOptionIndex, correctAnswerIndex);
                updateQuestion();
            } else {
                JOptionPane.showMessageDialog(frame, "Quiz Completed");
            }
        });
        timerLabel = new JLabel();

        quizPanel.add(timerLabel);
        frame.add(questionTextArea, BorderLayout.NORTH);
        frame.add(quizPanel, BorderLayout.CENTER);
        frame.add(nextButton, BorderLayout.SOUTH);

        timer = new Timer(1000, e -> {
            timeRemaining--;
            timerLabel.setText("Time Remaining: " + timeRemaining + " seconds");
            if (timeRemaining <= 0) {
                showNextQuestion();
                Logger.getLogger(QuizTakingUI.class.getName()).info("Timer Started");
            }
        });

        updateQuestion();

        frame.setVisible(true);
    }

    public void startQuiz() {
        showNextQuestion();
        timer.start();
        frame.setVisible(true);
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < quiz.getNumQuestions()) {
            int selectedOptionIndex = getSelectedOptionIndex();
            int correctAnswerIndex = quiz.getQuestion(currentQuestionIndex).getCorrectAnswerIndex();

            currentQuestionIndex++;
            processAnswer(selectedOptionIndex, correctAnswerIndex);
            updateQuestion();
            nextButton.setEnabled(false);
            currentQuestionIndex++;
            timeRemaining = 60;
        } else {
            timer.stop();
            JOptionPane.showMessageDialog(frame, "Quiz completed!");
            frame.dispose();
        }
    }

    private void updateQuestion() {
        Question currentQuestion = quiz.getQuestion(currentQuestionIndex);
        questionTextArea.setText(currentQuestion.getPrompt());

        if (optionRadioButtons != null) {
            for (int i = 0; i < optionRadioButtons.length; i++) {
                optionGroup.remove(optionRadioButtons[i]);
                quizPanel.remove(optionRadioButtons[i]);
            }
        }

        optionRadioButtons = new JRadioButton[currentQuestion.getNumOptions()];

        for (int i = 0; i < currentQuestion.getNumOptions(); i++) {
            optionRadioButtons[i] = new JRadioButton(currentQuestion.getOption(i));
            optionGroup.add(optionRadioButtons[i]);
            quizPanel.add(optionRadioButtons[i]);
        }

        optionGroup.clearSelection();
        frame.revalidate();
        Logger.getLogger(QuizTakingUI.class.getName()).log(Level.INFO, "Question Updated");
    }

    private void processAnswer(int selectedOptionIndex, int correctAnswerIndex) {
        if (optionGroup.getSelection() != null) {
            if (selectedOptionIndex == correctAnswerIndex) {
                JOptionPane.showMessageDialog(frame, "Correct!");
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect!");
            }
            nextButton.setEnabled(true);
        }
    }

    private int getSelectedOptionIndex() {
        for (int i = 0; i < optionRadioButtons.length; i++) {
            if (optionRadioButtons[i].isSelected()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Question question1 = new Question("What is the capital of France?", List.of("London", "Berlin", "Paris"), 2);
        Question question2 = new Question("Which planet is known as the Red Planet?", List.of("Earth", "Mars", "Venus"),
                1);
        List<String> optionsForQuestion3 = new ArrayList<>();
        optionsForQuestion3.add("Jupiter");
        optionsForQuestion3.add("Saturn");
        optionsForQuestion3.add("Mars");
        optionsForQuestion3.add("Uranus");

        Question question3 = new Question("What is the largest planet in our solar system?", optionsForQuestion3, 0);
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);

        SwingUtilities.invokeLater(() -> new QuizTakingUI(quiz));
    }
}