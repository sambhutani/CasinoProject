package io.zipcoder.casino;

public class Stud extends CardGame implements Gamble, Game {
    public Stud(int minBet, int maxBet, int ante) {
        super(minBet, maxBet, ante);
    }

    public void Deal() {

    }


    public void determineWinner(){

    }

    public void fold(){

    }

    /**
     * Below 3 Implemented from Gamble
     * @param betAmount
     */
    public void Bet(int betAmount) {

    }

    public int Payout(int payoutAmount) {
        return 0;
    }

    public void Ante(int anteAmount) {

    }

    /**
     * Below 3 Implemented from Game
     */

    public void Quit() {

    }

    public void StartGame() {

    }

    public void StartRound() {

    }
}
