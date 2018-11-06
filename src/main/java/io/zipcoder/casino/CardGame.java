package io.zipcoder.casino;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class CardGame {
    private int tablePot;
    private int minBet;
    private int maxBet;
    private int handSize;
    private int ante;
    private Player playersTurn;
    private ArrayList<CardPlayer> players;
    private ArrayList<Card> deck = new ArrayList<>();


    CardGame(int minBet, int maxBet, int ante){
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.ante = ante;
    }

    //use hand size to determine dealing
    public abstract void Deal();

    public void Shuffle(){

        //shuffle the card stack

    }

    public void faceDown(Card card){
        card.setVisibility(false);
    }

    public void faceUp(Card card){
        card.setVisibility(true);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<CardPlayer> getPlayers() {
        return players;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public int getAnte(){
        return ante;
    }
}
