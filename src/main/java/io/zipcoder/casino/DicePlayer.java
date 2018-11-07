package io.zipcoder.casino;

import java.util.HashMap;

public class DicePlayer {
    private Player player;
    Dice[] cup = new Dice[5];
    ScoreSheet scoreSheet = new ScoreSheet();

    public DicePlayer(Player player){
        this.player = player;
    }

    public ScoreSheet getScoreSheet() {
        return scoreSheet;
    }

    public Dice[] getCup() {
        return cup;
    }

    public void printCup() {
        for(Dice d : cup) {
            System.out.print(d.getValue() + " ");
        }
        System.out.println();
    }

    public Player getPlayer() {
        return player;
    }

    public void printBalanceAtEnd() {
        System.out.println("Your total balance is now: $" + getPlayer().getCurrentBalance());
    }
}


