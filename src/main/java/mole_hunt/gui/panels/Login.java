package mole_hunt.gui.panels;

import mole_hunt.gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    public Login(JFrame mainFrame, Welcome welcome) {
        setLayout(new GridLayout(5,1));

        JLabel loginLabel = new JLabel("Login", SwingConstants.CENTER);
        loginLabel.setFont(new Font("serif", Font.BOLD, 24));

        JTextField usernameField = new JTextField("Username");
        JPasswordField password= new JPasswordField("Password");
        JButton loginButton = new JButton("Login");
        JButton backButton =  new JButton("Back");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "Logged in successfully");
                welcome.showPanel("welcomeOptions");
            }
        });

        add(loginLabel);
        add(usernameField);
        add(password);
        add(loginButton);
        add(backButton);
    }
}
