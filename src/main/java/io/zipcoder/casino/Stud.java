package io.zipcoder.casino;
import java.util.Scanner;

public class Stud extends CardGame implements Gamble, Game {
    Scanner scanner = new Scanner(System.in);
    Console console;
    // private int roundCount = 0;

    public Stud(int minBet, int maxBet, int ante) {
        super(minBet, maxBet, ante);
    }
    
    public void playCard(Player player, Card card) {
        card.setVisibility(true);               //CARD isVISIBLE
        Printer.showCard(player, card);         //PRINT card name to CONSOLE
    }

    public void fold(){
    }

    /**
     * Determine what player wins by looping through player array and then
     * passing each hand to the 'handValue' method
     */
    public CardPlayer determineWinner(){
    int max = 0;
    CardPlayer winner = null;

    for(int i = 0; i < getPlayers().size(); i ++){
        CardPlayer player = getPlayers().get(i);
        int playerHandValue = handValue(player); // 'handValue' method sets 'max' value of this hand
        if(playerHandValue > max){
            max = playerHandValue;
            winner = player;
        }
    }
    System.out.println("The winner is " + winner.getPlayer().getName());
    System.out.println(winner.getPlayer().getName() + "\'s hand was: " + winner.getHand().get(0).getName() + " - " + winner.getHand().get(1).getName() + " - " + winner.getHand().get(2).getName() );
    return winner;
    }

    /**
     * Method will return a int value, larger value means strong hand to determine the winning player
     * @param player
     * @return
     */
    public int handValue(CardPlayer player){
        int handValue = 0;
        int card1 = player.getHand().get(0).getCardValue();
        int card2 = player.getHand().get(1).getCardValue();
        int card3 = player.getHand().get(2).getCardValue();

        //Three of a Kind
        if (card1 == card2 && card1 == card3){
            handValue = card1 * 1000000;
        //Two pair
        }
        else if (card1 == card2){
            handValue = (card1 * 10000) + card3;
        }
        else if (card1 == card3){
            handValue = (card1 * 10000) + card2;
        }
        else if (card2 == card3){
            handValue = (card2 * 10000) + card1;
        //High Card
        } else {
            // Card1 is Highest
            if (card1 > card2 && card1 > card3 && card2 > card3) {
                handValue = (card1 * 100) + (card2 * 10) + card3;
            }
            else if (card1 > card2 && card1 > card3 && card3 > card2) {
                handValue = (card1 * 100) + (card3 * 10) + card2;
            }
            // Card2 is Highest
            else if (card2 > card1 && card2 > card3 && card1 > card3) {
                handValue = (card2 * 100) + (card1 * 10) + card3;
            }
            else if (card2 > card1 && card2 > card3 && card3 > card1) {
                handValue = (card2 * 100) + (card3 * 10) + card1;
            }
            // Card3 is Highest
            else if (card3 > card1 && card3 > card2 && card1 > card3) {
                handValue = (card3 * 100) + (card1 * 10) + card3;
            }
            else if (card3 > card1 && card3 > card2 && card3 > card1) {
                handValue = (card3 * 100) + (card3 * 10) + card1;
            }
            else {
                handValue = 0;
            }
        }
        return handValue;
    }

    public void Bet(Player player, int betAmount) {
        super.changeTablePot(betAmount);
        player.changeBalance(betAmount * -1);
    }

    public void Payout(){
        if(super.getWinner() != null){
            super.getWinner().changeBalance(super.getTablePot());
        }
        System.out.println(getWinner().getName() + " won: " + super.getTablePot());
    }

    public void payAnte() {
        for(int i = 0; i < super.getPlayers().size(); i ++)
        {
            CardPlayer player = super.getPlayers().get(i);
            player.getPlayer().changeBalance(-super.getAnte());
        }
    }

    public void Quit() {
        System.out.println("Play again? Y : or any key to quit.");
        String answer = scanner.next();
        if (answer.equals("Y")){
            StartGame();
        } else {
            console = new Console();
        }
    }

    public void StartGame() {
        // Deck deck = new Deck();     //CREATE deck for game
        setHandSize(3);             //SET Hand Size for game(3)
        payAnte();                  //PAY ante (all players)
        Deal();                     //DEALS cards/ hands to each player
        StartRound();               //METHOD called

    }

    /**
     * Game played in this method by calling the 'gameRound' methods
     */
    public void StartRound() {
        System.out.println("Welcome to Three Card Stud!");
        //for (int i = 0; i < getHandSize() - 1; i++){    //Each player turns a card in hand to face up
        gameRound1();
        gameRound2();
        //}
        lastGameRound();
        determineWinner();
        // Payout();
    }

    /**
     * Plays through rounds that includes flipping cards face up and then betting or folding
     */
    public void gameRound1(){
        for (int j = 0; j < getPlayers().size(); j++) {
            CardPlayer player = super.getPlayers().get(j);                       //GET a player
            playCard(player.getPlayer(), player.getHand().get(0));      //SHOW-PRINT players first CARD
            //roundCount++;
        }
        for (int x = 0; x < getPlayers().size(); x++) {                          //Betting round or fold
            CardPlayer player = super.getPlayers().get(x);
            int bet;
            //ask player to bet and pass amount to Bet(betAmount
            System.out.println("Enter a bet, if 0 is entered you fold");
//TRY- CATCH OR WHILE/IF statement
            bet = Integer.parseInt(scanner.next());
            if (bet == 0){
                System.out.println(player.getPlayer().getName() + " folds.");
                //if fold, player is removed from game
                //if only 1 player game ends
            } else {
                Bet(super.getPlayers().get(x).getPlayer(), bet);
                System.out.println(player.getPlayer().getName() + " bets: " + bet);
            }
        }
    }


    /**
     * Plays through rounds that includes flipping cards face up and then betting or folding
     */
    public void gameRound2(){
        for (int j = 0; j < getPlayers().size(); j++) {
            CardPlayer player = super.getPlayers().get(j);                       //GET a player
            playCard(player.getPlayer(), player.getHand().get(1));      //SHOW-PRINT players first CARD
            //roundCount++;
        }
        for (int x = 0; x < getPlayers().size(); x++) {                          //Betting round or fold
            CardPlayer player = super.getPlayers().get(x);
            int bet;
            //ask player to bet and pass amount to Bet(betAmount
            System.out.println("Enter a bet, if 0 is entered you fold");
//TRY- CATCH OR WHILE/IF statement
            bet = Integer.parseInt(scanner.next());
            if (bet == 0){
                System.out.println(player.getPlayer().getName() + " folds.");
                //if fold, player is removed from game
                //if only 1 player game ends
            } else {
                Bet(super.getPlayers().get(x).getPlayer(), bet);
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
            playCard(player.getPlayer(), player.getHand().get(2));      //SHOW-PRINT players first CARD
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
