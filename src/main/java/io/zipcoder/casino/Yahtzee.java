package io.zipcoder.casino;

public class Yahtzee extends DiceGame implements Game{

    private Dice[] cup;
    DicePlayer dicePlayer;

    public Yahtzee(Player player) {
        this.dicePlayer = new DicePlayer(player);
    }

    public void compareScore(DicePlayer player1, DicePlayer player2){

        player1.getScoreSheet().getTotalScore();
    }

    public void reRoll(){

    }

    public void stopRoll(){

    }

    /**
     * implemented from 'Game'
     */
    public void Quit() {

    }

    public void StartGame(DicePlayer dicePlayer) {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();

        dicePlayer.getCup()[0] = dice1;
        dicePlayer.getCup()[1] = dice2;
        dicePlayer.getCup()[2] = dice3;
        dicePlayer.getCup()[3] = dice4;
        dicePlayer.getCup()[4] = dice5;

    }

    public void StartRound() {
        for(Dice d : dicePlayer.getCup()) {
            d.roll();
        }
        dicePlayer.printCup();
    }
}
