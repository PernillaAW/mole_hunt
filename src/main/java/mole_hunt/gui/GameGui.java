package mole_hunt.gui;

import mole_hunt.game.Game;
import mole_hunt.game.Player;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.plaf.synth.SynthUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameGui extends JPanel {
    private final int GRIDSIZE;
    private Random random;
    private JLabel[][] labels;

    public GameGui(int GRIDSIZE) {
        this.GRIDSIZE = GRIDSIZE;
        this.labels = new JLabel[GRIDSIZE][GRIDSIZE];
        this.random = new Random();
        setLayout(new BorderLayout());
        add(gamePanel(), BorderLayout.NORTH);
        add(gameSquare(), BorderLayout.CENTER);
    }

    public JPanel gamePanel() {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel gameInfoLabel = new JLabel("Let's play a game of Mole Hunt");

        int moleNumber = random.nextInt(500);

        JLabel gameMoleNumberLabel = new JLabel("Your number to collect is: " +  moleNumber);

        panel.add(gameInfoLabel);
        panel.add(gameMoleNumberLabel);

        return panel;
    }

    public JPanel gameSquare() {
        JPanel panel = new JPanel(new GridLayout(GRIDSIZE, GRIDSIZE));
        panel.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < GRIDSIZE; i++) {
            for (int j = 0; j < GRIDSIZE; j++) {
                labels[i][j] = new JLabel("", SwingConstants.CENTER);
                labels[i][j].setFont(new Font("Serif", Font.BOLD, 24));
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(labels[i][j]);
            }
        }
        System.out.println("gameSquare initialized.");
        return panel;
    }

    public void randomAction() {
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSquares();
            }
        });
        timer.start();
    }

    public void updateSquares() {
        for (int i = 0; i < this.GRIDSIZE; i++) {
            for (int j = 0; j < this.GRIDSIZE; j++) {
                labels[i][j].setText("");
            }
        }
            int row = random.nextInt(GRIDSIZE);
            int col = random.nextInt(GRIDSIZE);
            int number = random.nextInt(100);
            labels[row][col].setText(String.valueOf(number));
    }
}
