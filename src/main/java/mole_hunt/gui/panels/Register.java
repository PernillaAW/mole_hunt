package mole_hunt.gui.panels;

import mole_hunt.gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Register extends JPanel {
    public Register(JFrame mainFrame, Welcome welcome){
        setLayout(new GridLayout(5,1));

        JLabel registerLabel = new JLabel("Register", SwingConstants.CENTER);
        registerLabel.setFont(new Font("Serif", Font.BOLD, 24));

        JTextField userName = new JTextField("Username");
        JPasswordField passwordField = new JPasswordField("Password");
        JPasswordField confirmPassword = new JPasswordField("Confirm password");
        JButton registerButton = new JButton("Register");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "Registered Successfully");
                welcome.showPanel("welcomeOptions");
            }
        });

        add(registerLabel);
        add(userName);
        add(passwordField);
        add(confirmPassword);
        add(registerButton);
    }
}
