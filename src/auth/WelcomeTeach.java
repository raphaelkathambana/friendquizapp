package auth;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomeTeach extends JFrame implements ActionListener{


    JButton ph, signUpStud, back;
    JLabel Title, Instruction;
    // JTextField ID, Name, Email, Pass;
    Font fntP = new Font("Century Gothic", Font.PLAIN, 15);
    Font fntB = new Font("Century Gothic", Font.BOLD, 15);

    public void WelcomeDetail() {
        ph = new JButton();
        add(ph);

        signUpStud = new JButton("Sign Up a student!");
        signUpStud.setBackground(Color.WHITE);
        signUpStud.setBounds(60, 300, 290, 30);
        signUpStud.addActionListener(this);
        add(signUpStud);

        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setBounds(60, 490, 90, 30);
        back.addActionListener(this);
        add(back);

    }

    public WelcomeTeach() {

        setTitle("Home");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(260, 40, 650, 600);

        Title = new JLabel();
        Title.setFont(fntB);
        Title.setBounds(180, 20, 1000, 40);
        Title.setText("Welcome, Teacher!");
        add(Title);

        WelcomeDetail();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            UserType UT = new UserType();
            UT.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource() == signUpStud) {
            SignUpStud Up = new SignUpStud();
            Up.setVisible(true);
            this.setVisible(false);
        }
    }

}
