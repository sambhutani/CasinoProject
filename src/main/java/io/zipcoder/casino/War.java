package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

public class War extends CardGame implements Gamble, Game {

    private ArrayList<Card> tableCards = new ArrayList<Card>();

    War(int minBet, int maxBet) {
        super(minBet, maxBet);
    }

    public void Deal() {

        //for every card in super.geDeck();

    }

    /**
     * Specific to war methods
     */
    public void playCard(){

    }

    public void warMethod(){

    }

    public void determineWinner(){

    }

    /**
     * Below 3 Implemented from Gamble
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
