package mole_hunt.game;

public class Player {
    String name;
    int roundPoints;
    int highScore;

    public Player(String name){
        this.name = name;
        roundPoints = 0;
        /* ADD PLAYER VALIDATION TROUGH A DATABASE
         * ADD PLAYER HIGHSCORE FROM DATABASE
         * ADD GUEST PLAYER */
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoundPoints() {
        return roundPoints;
    }

    public void setRoundPoints(int roundPoints) {
        this.roundPoints = roundPoints;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
