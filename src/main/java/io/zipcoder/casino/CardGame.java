package io.zipcoder.casino;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class CardGame {

    private int tablePot;
    private int minBet;
    private int maxBet;
    private int handSize;
    private int ante;
    private Player playersTurn;
    private Player winner = null;
    private ArrayList<CardPlayer> players = new ArrayList<CardPlayer>();
    private Deck deck = new Deck();


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

    public Deck getDeck() {
        return deck;
    }

    public ArrayList<CardPlayer> getPlayers() {
        return players;
    }

    public void addPlayers(Player... players){
        for(Player player : players){
            CardPlayer cardPlayer = new CardPlayer(player);
            this.players.add(cardPlayer);
        }
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getAnte(){
        return ante;
    }

    public int getTablePot() {
        return tablePot;
    }

    public void changeTablePot(int amountPlusMinus) {
        tablePot += amountPlusMinus;
    }

    public Player getWinner() {
        return winner;
    }

    public int getHandSize() {
        return handSize;
    }

    public void setHandSize(int handSize){
        this.handSize = handSize;
    }
}
