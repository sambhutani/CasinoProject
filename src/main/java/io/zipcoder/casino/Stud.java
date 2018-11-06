package io.zipcoder.casino;

import java.util.Scanner;

public class Stud extends CardGame implements Gamble, Game {
    // ArrayList<Card> playerHand = new ArrayList<>(3);
    Scanner scanner = new Scanner(System.in);

    public Stud(int minBet, int maxBet, int ante) {
        super(minBet, maxBet, ante);

    }
    
    public void playCard(Player player, Card card){
        card.setVisibility(true);               //CARD isVISIBLE
        Printer.showCard(player, card);         //PRINT card name to CONSOLE
    }

    /**
     * Need method to determine what hand wins first
     */
    public void determineWinner(){
        CardPlayer winningPlayer = super.getPlayers().get(0); // 0 index must be dealer in case of a tie
        for(int i = 0; i < super.getPlayers().size(); i ++)
        {
            CardPlayer player = super.getPlayers().get(i);
            player.getHand().get(i);
        }
    }

    public void Bet(Player player, int betAmount) {
        super.changeTablePot(betAmount);
        player.changeBalance(betAmount * -1);
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
        Deck deck = new Deck();     //CREATE deck for game       
        setHandSize(3);             //SET Hand Size for game
        payAnte();                  //PAY ante (all players)
        Deal();                     //DEALS hands to each player
        StartRound();               //METHOD called
        Printer.studHandsDealt();   //CONSOLE dealt msg
    }

    /**
     * Game played in this method
     */
    public void StartRound() {
        for (int i = 0; i < getHandSize() - 1; i++){    //Each player turns a card in hand to face up
            gameRound();
        }
        lastGameRound();
        determineWinner();
    }

    /**
     * Plays through rounds that includes flipping cards face up and then betting or folding
     */
    public void gameRound(){
        for (int j = 0; j < getPlayers().size(); j++) {
            CardPlayer player = super.getPlayers().get(j);              //GET a player
            playCard(player.getPlayer(), player.getHand().get(j));      //SHOW-PRINT players first CARD
        }
        for (int j = 0; j < getPlayers().size(); j++) {                 //Betting round or fold
            CardPlayer player = super.getPlayers().get(j);
            int bet;
            //ask player to bet and pass amount to Bet(betAmount
            System.out.println("Enter a bet, if 0 is entered you fold");
            bet = scanner.nextInt();
            if (bet == 0){
                System.out.println(player.getPlayer().getName() + " folds.");
                //if fold, player is removed from game
                //if only 1 player (dealer) game ends
            } else {
                //wants a cardplayer but bet method is updating balance on a 'player' - casted CardPlayer to Player
                Bet(super.getPlayers().get(j).getPlayer(), bet);
                System.out.println(player.getPlayer().getName() + " bets: " + bet);
            }
        }
    }

    /**
     * PreCondition: Betting rounds already played
     * Plays through round that include flipping last card face up
     * PostCondtion: tablePot is now at max value
     * DetermineWinner() expected to be called after this method
     */
    public void lastGameRound(){
        for (int j = 0; j < getPlayers().size(); j++) {
            CardPlayer player = super.getPlayers().get(j);              //GET a player
            playCard(player.getPlayer(), player.getHand().get(j));      //SHOW-PRINT players first CARD
        }
    }


    /**
     * Deal each player(and dealer) 3 face down cards in turn
     */
    public void Deal() {
        for(int i = 0; i < getHandSize(); i ++){                        //OUTER loop - run 3 times as there are 3 cards per hand
            for (int j = 0; j < getPlayers().size(); j++) {             //INNER loop through each player
                Card card = super.getDeck().pullCard();                     //PULL card from deck (removed from deck)
                CardPlayer player = super.getPlayers().get(j);              //GET a player
                player.getHand().add(card);                                 //ADD card to player hand
            }
        }
    }
}
