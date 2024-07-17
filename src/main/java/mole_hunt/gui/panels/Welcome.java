package mole_hunt.gui.panels;

import mole_hunt.gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    public Welcome(MainFrame mainFrame){
        setLayout(new BorderLayout());

        setBackground(Color.DARK_GRAY);
        setOpaque(true);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(Color.decode("#373F51"));

        JPanel welcomeOptionsPanel = optionsPanel(mainFrame);
        Login login = new Login(mainFrame, this);
        Register register = new Register(mainFrame, this);
        Guest guest = new Guest(mainFrame, this);

        cardPanel.add(welcomeOptionsPanel);
        cardPanel.add(login, "Login");
        cardPanel.add(register, "Register");
        cardPanel.add(guest, "Guest");

        add(cardPanel, BorderLayout.CENTER);
        cardLayout.show(cardPanel, "welcomeOptions");
    }
    private JPanel optionsPanel(MainFrame mainFrame) {
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setBackground(Color.decode("#373F51"));

        JLabel welcomeLabel = new JLabel("Welcome to Mole hunt!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.RED);
        welcomeLabel.setBackground(Color.decode("#373F51"));
        welcomeLabel.setOpaque(true);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(200,50));
        loginButton.setMaximumSize(new Dimension(200,50));
        loginButton.setFont(new Font("Serif", Font.PLAIN, 18));
        loginButton.setForeground(Color.RED);
        loginButton.setBackground(Color.decode("#373F51"));
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(200,50));
        registerButton.setMaximumSize(new Dimension(200,50));
        registerButton.setFont(new Font("Serif", Font.PLAIN, 18));
        registerButton.setForeground(Color.RED);
        registerButton.setBackground(Color.decode("#373F51"));
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        JButton guestButton = new JButton("Play as guest");
        guestButton.setPreferredSize(new Dimension(200,50));
        guestButton.setMaximumSize(new Dimension(200,50));
        guestButton.setFont(new Font("Serif", Font.PLAIN, 18));
        guestButton.setForeground(Color.RED);
        guestButton.setBackground(Color.decode("#373F51"));
        guestButton.setFocusPainted(false);
        guestButton.setBorderPainted(false);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Login");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Register");
            }
        });

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Play guest button is pressed");
                mainFrame.playAsGuest();
            }
        });
        panel.add(welcomeLabel);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(guestButton);

        return panel;
    }

    public void showPanel(String panelName){
        cardLayout.show(cardPanel, panelName);
    }
}
