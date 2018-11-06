package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;

public class War extends CardGame implements Gamble, Game {

    private ArrayList<Card> tableCards = new ArrayList<Card>();

    War(int minBet, int maxBet, int ante) {
        super(minBet, maxBet, ante);
    }


    /**
     * Specific to war methods
     */
    public void playCard(){
        //take a card from the hand
        //add it to the tablecard face up
    }

    public void warMethod(){
        //take three cards from your hand face down
        //play one card face up
    }

    public void determineWinner(Card player1card, Card player2card){

    }

    /**
     * Below 3 Implemented from Gamble
     */
    public void Bet(int betAmount) {
        //add money to the pot
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

    public void Deal() {
        //while there are cards in the deck
        while(super.getDeck().size() != 0){
            //for each player playing the game
            for(int i = 0; i < super.getPlayers().size(); i ++)
            {
                //grab the card from the top (last added) to the deck
                Card card = super.getDeck().get(super.getDeck().size() - 1);
                //get the player whos hand we are adding the card to
                CardPlayer player = super.getPlayers().get(i);
                //add the card to their hand
                player.getHand().add(card);
            }
        }
    }
}
