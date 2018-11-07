//package io.zipcoder.casino;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.regex.Pattern;
//
//public class War extends CardGame implements Gamble, Game {
//
//    private ArrayList<Card> tableCards = new ArrayList<Card>();
//
//    War(int minBet, int maxBet, int ante) {
//        super(minBet, maxBet, ante);
//    }
//
//
//    /**
//     * Specific to war methods
//     */
//    public void playCard(){
//        //take a card from the hand
//        //add it to the tablecard face up
//    }
//
//    public void warMethod(){
//        //take three cards from your hand face down
//        //play one card face up
//    }
//
//    public void determineWinner(Card player1card, Card player2card){
//
//    }
//
//    /**
//     * Below 3 Implemented from Gamble
//     */
//    public void Bet(int betAmount) {
//        super.changeTablePot(betAmount);
//    }
//
//    public int Payout(int payoutAmount) {
//        if(super.getWinner() != null){
//            super.getWinner().changeBalance(super.getTablePot());
//        }
//        return 0;
//    }
//
//    public void payAnte() {
//        for(int i = 0; i < super.getPlayers().size(); i ++)
//        {
//            CardPlayer player = super.getPlayers().get(i);
//            player.getPlayer().changeBalance(-super.getAnte());
//        }
//    }
//
//    /**
//     * Below 3 Implemented from Game
//     */
//
//    public void Quit() {
//
//    }
//
//    public void StartGame() {
//        System.out.println("Welcome to war!");
//        super.chooseStatingPlayer();
//        payAnte();
//        Deal();
//        //super.chooseNextTurn();
//    }
//
//    public void StartRound() {
//        //player plays a card faceup
//        //remove cards from player hand
//        //pc plays a card faceup
//        //remove cards from npc hand
//        //determinewinner
//        //add all table cards to winners discard facedown
//
//        //when player is out of cards
//        //shuffle players discard
//        //insert discard into hand facedown
//    }
//
//    public void Deal() {
//        //while there are cards in the deck
//        while(super.getDeck().size() != 0){
//            //for each player playing the game
//            for(int i = 0; i < super.getPlayers().size(); i ++)
//            {
//                //grab the card from the top (last added) to the deck
//                Card card = super.getDeck().get(super.getDeck().size() - 1);
//                //get the player whos hand we are adding the card to
//                CardPlayer player = super.getPlayers().get(i);
//                //add the card to their hand
//                player.getHand().add(card);
//
//
//
//                //remove the card from the deck
//                super.getDeck().remove(card);
//
//            }
//        }
//        System.out.println(super.getPlayersTurn().getPlayer().getName() + "has: " + super.getPlayersTurn().getHand().size() + " cards.");
//    }
//
//}
