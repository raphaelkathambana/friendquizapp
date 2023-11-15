package auth;

import javax.swing.*;

import util.Operation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SignInTeach extends JFrame implements ActionListener, FocusListener {

    Operation O = new Operation();

    char[] focused = { '0', '0', '0', '0' };
    boolean empty = false;

    String userType = "Teach";

    JButton ph, signUp, submit, clear, info;
    JLabel Title, Instruction;
    JTextField ID, Name, Email, Pass;
    Font fntP = new Font("Century Gothic", Font.PLAIN, 15);
    Font fntB = new Font("Century Gothic", Font.BOLD, 15);

    public void SigninDetail() {

        ph = new JButton();
        add(ph);

        ID = new JTextField();
        ID.setFont(fntP);
        ID.setForeground(Color.GRAY);
        ID.setText("  ID");
        ID.setBounds(60, 100, 270, 30);
        ID.addFocusListener(this);
        add(ID);

        Pass = new JTextField();
        Pass.setFont(fntP);
        Pass.setForeground(Color.GRAY);
        Pass.setText("  Password");
        Pass.setBounds(60, 220, 270, 30);
        Pass.addFocusListener(this);
        add(Pass);

        signUp = new JButton("Don't Have an account? Signin!");
        signUp.setBackground(Color.WHITE);
        signUp.setBounds(400, 300, 90, 30);
        add(signUp);
        signUp.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBackground(Color.WHITE);
        submit.setBounds(400, 490, 90, 30);
        add(submit);
        submit.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBackground(Color.WHITE);
        clear.setBounds(500, 490, 90, 30);
        add(clear);
        clear.addActionListener(this);

    }

    public SignInTeach() {

        setTitle("SignIn");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(260, 40, 650, 600);

        Title = new JLabel();
        Title.setFont(fntB);
        Title.setBounds(180, 20, 1000, 40);
        Title.setText("Teacher Login");
        add(Title);

        SigninDetail();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp) {
            SignUpTeach Up = new SignUpTeach();
            Up.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == submit) {
            String theID = ID.getText();
            String thePass = Pass.getText();

            O.SignIn(theID, thePass, userType);
            if (theID.equals(O.getId()) && thePass.equals(O.getPass())) {
                
                JOptionPane.showMessageDialog(this, "Loged in!");

                WelcomeTeach Wel = new WelcomeTeach();
                Wel.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Please Write Your Details Properly");
            }
        }

        if (e.getSource() == clear) {
            ID.setText("");
            Name.setText("");
            Email.setText("");
            Pass.setText("");
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == ID && focused[0] == '0') {
            ID.setText("");
            ID.setForeground(Color.BLACK);
            focused[0] = '1';
        }
        if (e.getSource() == Pass && focused[3] == '0') {
            Pass.setText("");
            Pass.setForeground(Color.BLACK);
            focused[3] = '1';
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}