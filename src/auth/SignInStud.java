package auth;

import javax.swing.*;

import util.Operation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SignInStud extends JFrame implements ActionListener, FocusListener {

    Operation O = new Operation();

    char[] focused = { '0', '0' };
    boolean empty = false;
    boolean PassSee = false;

    String userType = "Stud";

    JButton ph, submit, clear, back;
    JLabel Title, Instruction;
    JTextField ID;
    JPasswordField Pass;
    JRadioButton pw;
    
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

        Pass = new JPasswordField();
        Pass.setFont(fntP);
        Pass.setForeground(Color.GRAY);
        Pass.setText("  Password");
        Pass.setBounds(60, 220, 270, 30);
        Pass.addFocusListener(this);
        add(Pass);
        if (focused[1] == '0'){
            Pass.setEchoChar((char) 0);
        }

        pw = new JRadioButton("Show Password", false);
        pw.setFont(fntP);
        pw.setBounds(360, 220, 270, 30);
        pw.addActionListener(this);
        add(pw);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setBounds(60, 490, 90, 30);
        back.addActionListener(this);
        add(back);

        submit = new JButton("Submit");
        submit.setBackground(Color.WHITE);
        submit.setBounds(400, 490, 90, 30);
        submit.addActionListener(this);
        add(submit);

        clear = new JButton("Clear");
        clear.setBackground(Color.WHITE);
        clear.setBounds(500, 490, 90, 30);
        clear.addActionListener(this);
        add(clear);

    }

    public SignInStud() {

        setTitle("SignIn");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(260, 40, 650, 600);

        Title = new JLabel();
        Title.setFont(fntB);
        Title.setBounds(180, 20, 1000, 40);
        Title.setText("Student Login");
        add(Title);

        SigninDetail();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (focused[1] == '1') {
            if (e.getSource() == pw) {
                if (PassSee == false) {
                    PassSee = true;
                    Pass.setEchoChar((char) 0);
                } else if (PassSee == true) {
                    PassSee = false;
                    Pass.setEchoChar('•');
                }
            }
        }

        if (e.getSource() == back) {
            UserType UT = new UserType();
            UT.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == submit) {
            String theID = ID.getText();
            String thePass = String.valueOf(Pass.getPassword());

            if (theID.isEmpty() || focused[0] == '0')
                empty = true;

            if (thePass.isEmpty() || focused[1] == '0')
                empty = true;

            if (empty == false) {

                O.SignIn(theID, thePass, userType);
                if (theID.equals(O.getId()) && thePass.equals(O.getPass())) {
                    JOptionPane.showMessageDialog(this, "Loged in!");

                    WelcomeStud Wel = new WelcomeStud();
                    Wel.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Email or Password");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Please Fill Out All The Details");
                empty = false;
            }
        }

        if (e.getSource() == clear) {
            if (focused[0] == '1')
                ID.setText("");
            if (focused[1] == '1')
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
        if (e.getSource() == Pass && focused[1] == '0') {
            Pass.setText("");
            Pass.setForeground(Color.BLACK);
            Pass.setEchoChar('•');
            focused[1] = '1';
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}