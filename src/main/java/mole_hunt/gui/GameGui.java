package mole_hunt.gui;


import javax.swing.*;
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
        add(gameTopPanel(), BorderLayout.NORTH);
        add(gameSquare(), BorderLayout.CENTER);
        add(gameCountPanel(), BorderLayout.EAST);
    }

    public JPanel gameTopPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel gameInfoLabel = new JLabel("Let's play a game of Mole Hunt");

        panel.add(gameInfoLabel);

        return panel;
    }

    public JPanel gameCountPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);


        int moleNumber = random.nextInt(500);

        JLabel gameMoleNumberLabel = new JLabel("Your number to collect is: ", SwingConstants.CENTER);
        gameMoleNumberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel gameMoleNumber = new JLabel("" + moleNumber, SwingConstants.CENTER);
        gameMoleNumber.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(gameMoleNumberLabel);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(gameMoleNumber);
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
