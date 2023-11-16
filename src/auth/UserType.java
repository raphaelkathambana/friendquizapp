package auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserType extends JFrame implements ActionListener {

    JButton ph, Stud, Teach;
    JLabel Title, Instruction;
    Font fntP = new Font("Century Gothic", Font.PLAIN, 15);
    Font fntB = new Font("Century Gothic", Font.BOLD, 15);

    public UserType() {        
        ph = new JButton();
        add(ph);

        setTitle("Register");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(260, 40, 650, 600);       

        Title = new JLabel();
        Title.setFont(new Font("Century Gothic", Font.BOLD, 20));
        Title.setBounds(288, 20, 150, 40);
        Title.setText("QUIZIFY!!");
        add(Title);

        Instruction = new JLabel();
        Instruction.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        Instruction.setBounds(110, 50, getWidth(), 40);
        Instruction.setText("Time to take a quiz!! ");
        add(Instruction);

        Stud = new JButton("Student");
        Stud.setContentAreaFilled(false);
        Stud.setFont(fntB);
        Stud.setBounds(50, 120, 120, 150);
        add(Stud);
        Stud.addActionListener(this);

        Teach = new JButton("Teacher");
        Teach.setContentAreaFilled(false);
        Teach.setFont(fntB);
        Teach.setBounds(190, 120, 120, 150);
        add(Teach);
        Teach.addActionListener(this);

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        UserType User = new UserType();
        User.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == Stud) {
            SignInStud In = new SignInStud();
            In.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == Teach){
            SignInTeach In = new SignInTeach();
            In.setVisible(true);
            this.setVisible(false);
        }
    }

}
