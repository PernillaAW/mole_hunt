package mole_hunt.gui;

import mole_hunt.game.Game;
import mole_hunt.gui.panels.Welcome;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Mole Hunt");
        setMinimumSize(new Dimension(450,800));
        getContentPane().setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        Welcome welcome = new Welcome(this);
        mainPanel.add(welcome, "welcome");

        add(mainPanel);
        setVisible(true);

    }

    public void showPanel(String panelName){
        cardLayout.show(mainPanel, panelName);
    }
    public void playAsGuest() {
        System.out.println("Switching..");
        GameGui gameGui = new GameGui(3);
        gameGui.randomAction();
        mainPanel.add(gameGui, "game");
        setVisible(true);
        showPanel("game");
        System.out.println("SHOWS!");
    }
}
