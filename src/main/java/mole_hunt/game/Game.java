package mole_hunt.game;

import mole_hunt.gui.GameGui;

public class Game {
    Player player;

    int level;
    GameGui gameGui;
    public Game(Player player, int level, boolean loggedIn) {
        this.player = player;
        this.level = level;
        GameGui gameGui = new GameGui(3);
         gameGui.gameSquare();
    }



}
