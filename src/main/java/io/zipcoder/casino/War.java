package io.zipcoder.casino;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

public class War extends CardGame implements Gamble, Game {

    private ArrayList<Card> tableCards = new ArrayList<Card>();
    private ArrayList<CardPlayer> warMembers = new ArrayList<CardPlayer>();
    private Scanner scanner = new Scanner(System.in);
    private boolean war = false;

    War(int minBet, int maxBet, int ante) {
        super(minBet, maxBet, ante);
    }


    /**
     * Specific to war methods
     */
    public void playCard(boolean cardFace){
        //if the player has cards in their hand
        if(super.getPlayersTurn().getHand().size() > 0) {
            //pull out a card to play
            Card card = super.getPlayersTurn().getHand().get(0);
            //play the card face up, on the table
            card.setVisibility(cardFace);
            tableCards.add(card);
            //store the last played card in the players wrapper class
            super.getPlayersTurn().setPlayedCard(card);
            //remove this card from their hand
            super.getPlayersTurn().getHand().remove(card);
            //print the card that was played
            if(cardFace == true) {
                System.out.println(super.getPlayersTurn().getPlayer().getName() + " has played " + card.getName() + " and has " + super.getPlayersTurn().getHand().size() + " cards left.");
            } else {
                System.out.println(super.getPlayersTurn().getPlayer().getName() + " has played a card face down.");
            }
        //if the player has not cards in their hand but has cards in their discard, pickup their discard and play a card
        } else if(super.getPlayersTurn().getHand().size() == 0 && super.getPlayersTurn().getDiscard().size() > 0) {
            System.out.println(super.getPlayersTurn().getPlayer().getName() + " ran out of cards and picked up their discard pile.");
            super.getPlayersTurn().getHand().addAll(super.getPlayersTurn().getDiscard());
            super.getPlayersTurn().setDiscard(new ArrayList<Card>());
            playCard(true);
        //if the person has no cards in their hand, and no cards in discard they lose.
        } else if(super.getPlayersTurn().getHand().size() == 0 && super.getPlayersTurn().getDiscard().size() == 0){
            super.setLoser(super.getPlayersTurn().getPlayer());
            System.out.println(super.getPlayersTurn().getPlayer().getName() + " has lost the match!");
        }
    }

    public CardPlayer warMethod(){
        System.out.println("War!");

        int max = 0;
        CardPlayer winner = null;

        //each player plays 3 cards
        for(int i = 0; i < warMembers.size(); i ++){
            for(int m = 0; m < 2; m ++){
                playCard(false);
            }
            playCard(true);
            super.chooseNextTurn();
        }

        //find the player with the highest value
        winner = determineWinner(warMembers);
        warMembers = new ArrayList<>();
        return winner;
    }

    public CardPlayer determineWinner(ArrayList<CardPlayer> playerList){

        int max = 0;
        CardPlayer winner = null;
        boolean war = false;

        //loop through and get the max card value
        for(int i = 0; i < playerList.size(); i ++){
            CardPlayer player = playerList.get(i);
            //if the players card is greater than the current max
            if(player.getPlayedCard().getCardValue() > max)
            {
                //set their value as max
                max = player.getPlayedCard().getCardValue();
                //make them the winner
                winner = player;
                //set war to false
                war = false;
            }  else if (player.getPlayedCard().getCardValue() == max){
                warMembers.add(player);
                war = true;
            }
        }
        if(war)
        {
            warMembers.add(winner);
            winner = warMethod();
            return winner;
        } else if(!war)
        {
            System.out.println("The winner is " + winner.getPlayer().getName());
            return winner;
        }
        return null;
    }

    /**
     * Below 3 Implemented from Gamble
     */
    public void bet(int betAmount) {
        super.changeTablePot(betAmount);
    }


    public void payout() {
        if(super.getWinner() != null)
        {
            super.getWinner().changeBalance(super.getTablePot());
        }
    }

    public void payAnte() {
        for(int i = 0; i < super.getPlayers().size(); i ++)
        {
            CardPlayer player = super.getPlayers().get(i);
            player.getPlayer().changeBalance(super.getAnte() * -1);
        }
    }

    /**
     * Below 3 Implemented from Game
     */

    public void quit() {

    }

    public void startGame() {
        System.out.println("Welcome to war!");
        super.chooseStatingPlayer();
        payAnte();
        deal();
        startRound();
    }

    public void startRound() {
        while(super.getLoser() == null) {
            System.out.println("Type play to play the top card from your pile.");
            String input = scanner.next();
            input = input.toLowerCase().trim();
            if (input.equals("play")) {
                //each player
                for (CardPlayer player : super.getPlayers()) {
                    //plays a card, then
                    playCard(true);
                    //the turn updates to be the next players.
                    super.chooseNextTurn();
                }
                //determine the winner once all players play a card
                CardPlayer winner = determineWinner(super.getPlayers());
                System.out.println(winner.getPlayer().getName() + " has been rewarded " + tableCards.size() + " cards.");
                //add all the table cards to the players discard
                winner.addDiscard(tableCards);
                //clear the table cards pile
                tableCards = new ArrayList<Card>();
                //if the user does not type play
            } else {
                //display a message
                System.out.println("Sorry, I don't understand that command.");
            }
        }

    }

    public void deal() {
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
                //remove the card from the deck
                super.getDeck().remove(card);
            }
        }

        System.out.println(super.getPlayersTurn().getPlayer().getName() +
                "has: " + super.getPlayersTurn().getHand().size() + " cards.");

    }
}
