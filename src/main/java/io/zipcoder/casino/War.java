package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class War extends CardGame implements Gamble, Game {

    private ArrayList<Card> tableCards = new ArrayList<Card>();
    private Scanner scanner = new Scanner(System.in);

    War(int minBet, int maxBet, int ante) {
        super(minBet, maxBet, ante);
    }


    /**
     * Specific to war methods
     */
    public void playCard(){
        //if the player has cards in their hand
        if(super.getPlayersTurn().getHand().size() > 0) {
            //pull out a card to play
            Card card = super.getPlayersTurn().getHand().get(0);
            //play the card face up, on the table
            card.setVisibility(true);
            tableCards.add(card);
            //store the last played card in the players wrapper class
            super.getPlayersTurn().setPlayedCard(card);
            //remove this card from their hand
            super.getPlayersTurn().getHand().remove(card);
            //print the card that was played
            System.out.println(super.getPlayersTurn().getPlayer().getName() + " has played " + card.getName() + " and has " + super.getPlayersTurn().getHand().size() + " cards left.");
        //if the player has not cards in their hand but has cards in their discard, pickup their discard and play a card
        } else if(super.getPlayersTurn().getHand().size() == 0 && super.getPlayersTurn().getDiscard().size() > 0) {
            System.out.println(super.getPlayersTurn().getPlayer().getName() + " ran out of cards and picked up their discard pile.");
            super.getPlayersTurn().getHand().addAll(super.getPlayersTurn().getDiscard());
            super.getPlayersTurn().setDiscard(new ArrayList<Card>());
            playCard();
        //if the person has no cards in their hand, and no cards in discard they lose.
        } else if(super.getPlayersTurn().getHand().size() == 0 && super.getPlayersTurn().getDiscard().size() == 0){
            super.setLoser(super.getPlayersTurn().getPlayer());
        }
    }

    public void warMethod(){
        //take three cards from your hand face down
        //play one card face up
    }

    public CardPlayer determineWinner(){

        int max = 0;
        CardPlayer winner = null;

        for(int i = 0; i < getPlayers().size(); i ++){
            CardPlayer player = getPlayers().get(i);
            if(player.getPlayedCard().getCardValue() > max){
                max = player.getPlayedCard().getCardValue();
                winner = player;
            }
        }
        System.out.println("The winner is " + winner.getPlayer().getName());
        return winner;
    }

    /**
     * Below 3 Implemented from Gamble
     */
    public void Bet(int betAmount) {
        super.changeTablePot(betAmount);
    }

    public void Payout() {
        if(super.getWinner() != null) {
            super.getWinner().changeBalance(super.getTablePot());
        }
    }

    public void payAnte() {
        for(int i = 0; i < super.getPlayers().size(); i ++)
        {
            CardPlayer player = super.getPlayers().get(i);
            player.getPlayer().changeBalance(-super.getAnte());
        }
    }

    /**
     * Below 3 Implemented from Game
     */

    public void Quit() {

    }

    public void StartGame() {
        System.out.println("Welcome to war!");
        super.chooseStatingPlayer();
        payAnte();
        Deal();
        StartRound();
    }

    public void StartRound() {
        while(super.getLoser() == null) {
            System.out.println("Type play to play the top card from your pile.");
            String input = scanner.next();
            input = input.toLowerCase().trim();

            if (input.equals("play")) {
                //each player
                for (CardPlayer player : super.getPlayers()) {
                    //plays a card, then
                    playCard();
                    //the turn updates to be the next players.
                    super.chooseNextTurn();
                }
                //determine the winner
                CardPlayer winner = determineWinner();

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

        //player plays a card faceup
        //remove cards from player hand
        //pc plays a card faceup
        //remove cards from npc hand
        //determinewinner
        //add all table cards to winners discard facedown

        //when player is out of cards
        //shuffle players discard
        //insert discard into hand facedown
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
                //remove the card from the deck
                super.getDeck().remove(card);
            }
        }
        System.out.println(super.getPlayersTurn().getPlayer().getName() + " has: " + super.getPlayersTurn().getHand().size() + " cards.");
    }
}
