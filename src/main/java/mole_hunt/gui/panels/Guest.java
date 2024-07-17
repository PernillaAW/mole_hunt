package mole_hunt.gui.panels;

import mole_hunt.game.Game;
import mole_hunt.game.Player;
import mole_hunt.gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guest extends JPanel {
    public Guest (JFrame mainFrame, Welcome welcome){
        setLayout(new GridLayout(4,1));

        JLabel guestLabel = new JLabel("Guest", SwingConstants.CENTER);
        guestLabel.setFont(new Font("Serif", Font.BOLD, 24));

        JButton continueButton = new JButton("Continue");

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "Continuing as guest");
            }
        });
        add(guestLabel);
        add(continueButton);
    }
}
