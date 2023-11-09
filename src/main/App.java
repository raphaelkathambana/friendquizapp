package main;

import javax.swing.SwingUtilities;

import ui.QuizCreationUI;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizCreationUI::new);
    }
}