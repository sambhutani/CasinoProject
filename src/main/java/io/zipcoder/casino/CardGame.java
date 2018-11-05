package io.zipcoder.casino;

import java.util.HashMap;

public class CardGame {
    private boolean isFaceUp; // Deal() will change IF card is visible
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

    public void Deal(){
        //faceUp/ faceDown
    }

    public void Shuffle(){

    }

}
