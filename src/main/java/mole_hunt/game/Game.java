package mole_hunt.game;

import mole_hunt.gui.GameGui;

import java.util.Random;

public class Game {
    private Player player;
    private int level;
    private  int moleNumber;
    private Random random;
    GameGui gameGui;
    public Game(Player player, int level, boolean loggedIn) {
        this.player = player;
        this.level = level;
        random = new Random();
        moleNumber = random.nextInt(500);
    }

    public int getMoleNumber(){
        return moleNumber;
    }

    public void subtractNumber(int value){
        moleNumber -= value;
        if (moleNumber < 0){
            moleNumber = 0;
        }
    }

    public boolean gameOver(){
        return moleNumber == 0;
    }



}
