package auth;

import javax.swing.*;

import util.Operation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SignUpTeach extends JFrame implements ActionListener, FocusListener {

    Operation O = new Operation();

    char[] focused = { '0', '0', '0', '0' };
    boolean empty = false;
    boolean PassSee = false;

    String userType = "Teach";

    JButton ph, submit, clear, back;
    JLabel Title, Instruction;
    JTextField Name, Email;
    JPasswordField Pass;
    JRadioButton pw;

    Font fntP = new Font("Century Gothic", Font.PLAIN, 15);
    Font fntB = new Font("Century Gothic", Font.BOLD, 15);

    public void SignUpDetail() {

        ph = new JButton();
        add(ph);


        Name = new JTextField();
        Name.setFont(fntP);
        Name.setForeground(Color.GRAY);
        Name.setText("  Name");
        Name.setBounds(60, 140, 270, 30);
        Name.addFocusListener(this);
        add(Name);

        Email = new JTextField();
        Email.setFont(fntP);
        Email.setForeground(Color.GRAY);
        Email.setText("  Email");
        Email.setBounds(60, 180, 270, 30);
        Email.addFocusListener(this);
        add(Email);

        Pass = new JPasswordField();
        Pass.setFont(fntP);
        Pass.setForeground(Color.GRAY);
        Pass.setText("  Password");
        Pass.setBounds(60, 220, 270, 30);
        Pass.addFocusListener(this);
        add(Pass);
        if (focused[2] == '0'){
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

    public SignUpTeach() {

        setTitle("SignUp");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(260, 40, 650, 600);

            Title = new JLabel();
            Title.setFont(fntB);
            Title.setBounds(180, 20, 1000, 40);
            Title.setText("Teacher SignUp");
            add(Title);

            SignUpDetail();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (focused[2] == '1') {
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

        if (e.getSource() == back){
            SignInTeach In = new SignInTeach();
            In.setVisible(true);
            this.setVisible(false);
        }
        
        if (e.getSource() == submit) {
            
            String theName = Name.getText();
            String theEmail = Email.getText();
            String thePass = String.valueOf(Pass.getPassword());


            if (theName.isEmpty() || focused[0] == '0')
                empty = true;

            if (theEmail.isEmpty() || focused[1] == '0')
                empty = true;

            if (thePass.isEmpty() || focused[2] == '0')
                empty = true;

            if (empty == false) {
                try {
                    O.SignUp(theName, theEmail, thePass, userType);
                    JOptionPane.showMessageDialog(this, "Sign Up Successful! Your ID number is: " + O.getStrId(userType));

                    UserType UT = new UserType();
                    UT.setVisible(true);
                    this.setVisible(false);
                } catch (NumberFormatException NumErr) {
                    JOptionPane.showMessageDialog(this, "Please Write Your Details Properly");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Fill Out All The Details");
                empty = false;
            }

        }
        if (e.getSource() == clear) {
            if (focused[0] == '1')
                Name.setText("");
            if (focused[1] == '1')
                Email.setText("");
            if (focused[2] == '1')
                Pass.setText(""); 
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

        if (e.getSource() == Name && focused[0] == '0') {
            Name.setText("");
            Name.setForeground(Color.BLACK);
            focused[0] = '1';
        }
        if (e.getSource() == Email && focused[1] == '0') {
            Email.setText("");
            Email.setForeground(Color.BLACK);
            focused[1] = '1';
        }
        if (e.getSource() == Pass && focused[2] == '0') {
            Pass.setText("");
            Pass.setForeground(Color.BLACK);
            Pass.setEchoChar('•');
            focused[2] = '1';
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}
