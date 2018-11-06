package io.zipcoder.casino;

import java.util.ArrayList;

public class Stud extends CardGame implements Gamble, Game {
    // ArrayList<Card> playerHand = new ArrayList<>(3);

    public Stud(int minBet, int maxBet, int ante) {
        super(minBet, maxBet, ante);

    }


    public void playCard(){
        //turn card faceUp
    }

    public Player determineWinner(){
        return null;
    }

    public void Bet(int betAmount) {
        super.changeTablePot(betAmount);
    }

    public int Payout(int payoutAmount) {
        if(super.getWinner() != null){
            super.getWinner().changeBalance(super.getTablePot());
        }
        return 0;
    }

    public void payAnte() {
        for(int i = 0; i < super.getPlayers().size(); i ++)
        {
            CardPlayer player = super.getPlayers().get(i);
            player.getPlayer().changeBalance(-super.getAnte());
        }
    }

    public void Quit() {
        //playAgain?
        // Shuffle

    }

    public void StartGame() {
        Deck deck = new Deck();
        // Set Hand Size for game
        setHandSize(3);
        //Player(s) pay ante
        payAnte();
        //Dealer deals 3 cards in turn to each player(and dealer)
        Deal();
    }

    public void StartRound() {

        //Each player turns a card1 in hand to face up
        //player(s) bets or folds
            //if bet, players turn card2 face up
        //player(s) bets or folds
            //if bet, players turn card3 face up
        //determinewinner
        //add all table cards to table deck face down

    }

    public void

    /**
     * Deal each player(and dealer) 3 face down cards in turn
     */
    public void Deal() {
        for(int i = 0; i < getHandSize() * getPlayers().size(); i ++)
        {
            //grab the card from the top (last added) to the deck
            Card card = super.getDeck().pullCard();
            //get the player whos hand we are adding the card to
            CardPlayer player = super.getPlayers().get(i);
            //add the card to their hand
            player.getHand().add(card);
        }
    }
}
/*
    public void Deal() {
        for(int i = 0; i < getHandSize() * getPlayers().size(); i ++)
        {
            //grab the card from the top (last added) to the deck
            Card card = deck.pullCard();
            //get the player whos hand we are adding the card to
            CardPlayer player = super.getPlayers().get(i);
            //add the card to their hand
            player.getHand().add(card);
            //remove the card from the deck
            super.getDeck().remove(card);
        }
    }