package io.zipcoder.casino;

import java.util.HashMap;

public class War extends CardGame implements Gamble, Game {

    War(int minBet, int maxBet) {
        super(minBet, maxBet);
    }

    public void playCard(){

    }

    public void warMethod(){

    }

    public void determineWinner(){

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
    public void Play() {

    }

    public void Quit() {

    }

    public void StartRound() {

    }
}
