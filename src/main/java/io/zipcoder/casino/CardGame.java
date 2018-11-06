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
    private CardPlayer playersTurn;
    private Player winner = null;
    private Player loser = null;
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

    public CardPlayer getPlayersTurn() {
        return playersTurn;
    }

    public void setPlayersTurn(CardPlayer playersTurn) {
        this.playersTurn = playersTurn;
    }

    public void addNpc(){
        addPlayers(new NPC("Opponant", getAnte()));
    }

    public void chooseStatingPlayer(){
        //loop through the players
        for(int i = 0; i < getPlayers().size(); i ++){
            //if one is not an NPC
            if(!(getPlayers().get(i).getPlayer() instanceof NPC)){
                //set this player to have the current turn
                setPlayersTurn(getPlayers().get(i));
                break;
            }
        }
    }

    public void chooseNextTurn(){
        if(playersTurn != null)
        {
            //if it is the end of the turn circle
            if((players.indexOf(playersTurn) + 1) == players.size()){
                //start again at the starting player
                playersTurn = players.get(0);
                //System.out.println("it is now " + playersTurn.getPlayer().getName() + "'s turn");

            //if it is not the end of the turn circle
            } else {
                playersTurn = players.get(players.indexOf(playersTurn) + 1);
                //System.out.println("it is now " + playersTurn.getPlayer().getName() + "'s turn");
            }
        }
    }

    public void printTurn(){
        System.out.println("it is now " + playersTurn.getPlayer().getName() + "'s turn");
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }
}
