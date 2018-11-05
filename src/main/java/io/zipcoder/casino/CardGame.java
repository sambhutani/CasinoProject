package io.zipcoder.casino;

import java.util.HashMap;

public abstract class CardGame {
    private int tablePot;
    private int minBet;
    private int maxBet;
    private int handSize;
    private Player playersTurn;
    private Player[] players;


    CardGame(int minBet, int maxBet){
        this.minBet = minBet;
        this.maxBet = maxBet;
    }

    //use hand size to determine dealing
    public abstract void Deal();

    public void Shuffle(){

    }

    public void faceDown(Card card){
        card.setVisibility(false);
    }

    public void faceUp(Card card){
        card.setVisibility(true);
    }
}
