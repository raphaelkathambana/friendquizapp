package ui;

import javax.swing.*;

import util.Question;
import util.Quiz;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QuizCreationUI extends JFrame {
    private List<Question> questions;
    private int currentQuestionIndex;
    private JTextField questionField;
    private JTextField option1Field;
    private JTextField option2Field;
    private JTextField option3Field;
    private JTextField option4Field;
    private JComboBox<String> correctAnswerComboBox;
    private JButton addButton;
    private JButton finishButton;

    public QuizCreationUI() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;

        setTitle("Quiz Creation");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(6, 2));

        JLabel questionLabel = new JLabel("Question:");
        questionField = new JTextField();
        questionPanel.add(questionLabel);
        questionPanel.add(questionField);

        JLabel option1Label = new JLabel("Option 1:");
        option1Field = new JTextField();
        questionPanel.add(option1Label);
        questionPanel.add(option1Field);

        JLabel option2Label = new JLabel("Option 2:");
        option2Field = new JTextField();
        questionPanel.add(option2Label);
        questionPanel.add(option2Field);

        JLabel option3Label = new JLabel("Option 3:");
        option3Field = new JTextField();
        questionPanel.add(option3Label);
        questionPanel.add(option3Field);

        JLabel option4Label = new JLabel("Option 4:");
        option4Field = new JTextField();
        questionPanel.add(option4Label);
        questionPanel.add(option4Field);

        JLabel correctAnswerLabel = new JLabel("Correct Answer:");
        String[] answerOptions = { "Option 1", "Option 2", "Option 3", "Option 4" };
        correctAnswerComboBox = new JComboBox<>(answerOptions);
        questionPanel.add(correctAnswerLabel);
        questionPanel.add(correctAnswerComboBox);

        add(questionPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Question");
        addButton.addActionListener(e -> addQuestion());
        buttonPanel.add(addButton);

        finishButton = new JButton("Finish");
        finishButton.addActionListener(e -> finishQuizCreation());
        buttonPanel.add(finishButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void addQuestion() {
        String questionText = questionField.getText();
        String option1 = option1Field.getText();
        String option2 = option2Field.getText();
        String option3 = option3Field.getText();
        String option4 = option4Field.getText();

        var options = new ArrayList<String>();
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);

        int correctAnswerIndex = correctAnswerComboBox.getSelectedIndex();

        Question question = new Question(questionText, options, correctAnswerIndex);
        question.setCorrectAnswerIndex(correctAnswerIndex);

        questions.add(question);

        clearFields();
        currentQuestionIndex++;
        JOptionPane.showMessageDialog(this, "Question added!");
    }

    private void finishQuizCreation() {
        // Add logic to save the quiz with the created questions
        JOptionPane.showMessageDialog(this, "Quiz creation completed!");
        this.createQuiz();
        dispose();
    }

    private void clearFields() {
        questionField.setText("");
        option1Field.setText("");
        option2Field.setText("");
        option3Field.setText("");
        option4Field.setText("");
        correctAnswerComboBox.setSelectedIndex(0);
    }

    private void createQuiz() {
        // Create a quiz
        Quiz quiz = new Quiz();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            quiz.addQuestion(question);
        }
        // Create and start the QuizTakingGUI
        SwingUtilities.invokeLater(() -> new QuizTakingUI(quiz));

    }

    public static void main(String[] args) {
        QuizCreationUI quizCreationUI = new QuizCreationUI();
        quizCreationUI.setVisible(true);
    }
}
