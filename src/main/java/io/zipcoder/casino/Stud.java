package io.zipcoder.casino;

public class Stud extends CardGame implements Gamble, Game {
    public Stud(int minBet, int maxBet, int ante) {
        super(minBet, maxBet, ante);
    }

    public void deal() {

    }

    public void determineWinner(){

    }

    public void fold(){

    }

    /**
     * Below 3 Implemented from Gamble
     * @param betAmount
     */
    public void bet(int betAmount) {

    }

    public void payout() {

    }


    public void Ante(int anteAmount) {

    }


    /**
     * Below 3 Implemented from Game
     */

    public void quit() {

    }

    public void startGame() {

    }

    public void startRound() {

    }
}
