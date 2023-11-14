package main;

import javax.swing.SwingUtilities;

import ui.QuizCreationUI;
import util.GetConnection;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizCreationUI::new);

        // you should use this to make a new connection
        GetConnection connection = GetConnection.getInstance();
        // oh and also don't add any other code to that file...
        // any other sql related stuff should have it's own class
    }
}