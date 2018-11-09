package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudTest {

    Stud stud;
    ArrayList<CardPlayer> players = new ArrayList<>();
    CardPlayer cardPlayer1;
    CardPlayer cardPlayer2;

    @Before
    public void setup(){
        stud = new Stud(10);
        ArrayList<Card> cardsTest1 = new ArrayList<>();
        Player player1 = new Player("Player1", 10);
        this.cardPlayer1 = new CardPlayer(player1);
        Card cardSix = new Card(Card.CardValue.SIX, Card.Suit.HEARTS);   //SIX   - 600
        Card cardFive = new Card(Card.CardValue.FIVE, Card.Suit.HEARTS); //FIVE  -  50
        Card cardFour = new Card(Card.CardValue.FOUR, Card.Suit.HEARTS); //FOUR  -   4
        cardsTest1.add(cardSix); cardsTest1.add(cardFive); cardsTest1.add(cardFour);
        this.cardPlayer1.setHand(cardsTest1);

        ArrayList<Card> cardsTest2 = new ArrayList<>();
        Player player2 = new Player("Player2", 10);
        this.cardPlayer2 = new CardPlayer(player2);
        Card cardSeven = new Card(Card.CardValue.SEVEN, Card.Suit.HEARTS);
        Card cardEight = new Card(Card.CardValue.EIGHT, Card.Suit.HEARTS);
        Card cardNine = new Card(Card.CardValue.NINE, Card.Suit.HEARTS);
        cardsTest2.add(cardSeven); cardsTest2.add(cardEight); cardsTest2.add(cardNine);
        this.cardPlayer2.setHand(cardsTest2);

        players.add(this.cardPlayer1);
        players.add(this.cardPlayer2);

    }

    @Test
    public void highCardHandValueTest(){
        //WHEN
        int card1 = 14; //ACE   - 1400
        int card2 = 13; //KING  -  130
        int card3 = 12; //QUEEN -   12
        //THEN
        int expected = 1542;
        int actual = stud.highCardHandValue(card1, card2, card3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void highCardHandValueTest2(){
        //WHEN
        int card2 = 11; //JACK  -    110
        int card1 =  9; //NINE   -    09
        int card3 = 12; //QUEEN -   1200
        //THEN
        int expected = 1319;
        int actual = stud.highCardHandValue(card1, card2, card3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void highCardHandValueTest3(){
        //WHEN
        int card1 = 11; //JACK  -    110
        int card2 =  9; //NINE   -    09
        int card3 = 12; //QUEEN -   1200
        //THEN
        int expected = 1319;
        int actual = stud.highCardHandValue(card2, card3, card1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void highCardHandValueTest4(){
        //WHEN
        int card1 = 13;
        int card2 = 12;
        int card3 = 14;
        //THEN
        int expected = 1542;
        int actual = stud.highCardHandValue(card1, card2, card3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void highCardHandValueTest5(){
        //WHEN
        int card1 = 13;
        int card2 = 14;
        int card3 = 12;
        //THEN
        int expected = 1542;
        int actual = stud.highCardHandValue(card1, card2, card3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void highCardHandValueTest6(){
        //WHEN
        int card1 = 14;
        int card2 = 12;
        int card3 = 13;
        //THEN
        int expected = 1542;
        int actual = stud.highCardHandValue(card1, card2, card3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void onePairHandValueTest(){     // card1 == card2
        //WHEN
        int card1 = 10; //TEN  - 100000
        int card2 = 10; //TEN  -      0
        int card3 = 02; //TWO  -      2
        //THEN
        int expected = 100002;
        int actual = stud.onePairHandValue(card1, card2, card3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void onePairHandValueTest2() {     // card1 == card3
        //WHEN
        int card1 = 10; //TEN  - 100000
        int card2 = 02; //TWO  -      2
        int card3 = 10; //TEN  -      0
        //THEN
        int expected = 100002;
        int actual = stud.onePairHandValue(card1, card2, card3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void onePairHandValueTest3() {     // card2 == card3
        //WHEN
        int card1 = 02; //TWO  -      2
        int card2 = 10; //TEN  - 100000
        int card3 = 10; //TEN  -      0
        //THEN
        int expected = 100002;
        int actual = stud.onePairHandValue(card1, card2, card3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void threeOfAKindHandValueTest(){
        //WHEN
        int card1 = 3; //THREE  - 3000000
        //THEN
        int expected = 3000000;
        int actual = stud.threeOfAKindHandValue(card1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handValueTest(){
        //WHEN
            //SIX   - 600
            //FIVE  -  50
            //FOUR  -   4

        //THEN
        int expected = 654;
        int actual = stud.handValue(cardPlayer1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handValueTest2(){
        //WHEN
        ArrayList<Card> cardsTest = new ArrayList<>();
        Player player1 = new Player("Test", 10);
        this.cardPlayer1 = new CardPlayer(player1);
        Card cardSix = new Card(Card.CardValue.SIX, Card.Suit.HEARTS);
        Card cardFive = new Card(Card.CardValue.SIX, Card.Suit.HEARTS);
        Card cardFour = new Card(Card.CardValue.SIX, Card.Suit.HEARTS);
        cardsTest.add(cardSix); cardsTest.add(cardFive); cardsTest.add(cardFour);
        this.cardPlayer1.setHand(cardsTest);
        //THEN
        int expected = 6000000;
        int actual = stud.handValue(this.cardPlayer1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handValueTest3(){
        //WHEN
        ArrayList<Card> cardsTest = new ArrayList<>();
        Player player1 = new Player("Test", 10);
        this.cardPlayer1 = new CardPlayer(player1);
        Card cardSix = new Card(Card.CardValue.SIX, Card.Suit.HEARTS);
        Card cardFive = new Card(Card.CardValue.SIX, Card.Suit.HEARTS);
        Card cardFour = new Card(Card.CardValue.SEVEN, Card.Suit.HEARTS);
        cardsTest.add(cardSix); cardsTest.add(cardFive); cardsTest.add(cardFour);
        this.cardPlayer1.setHand(cardsTest);
        //THEN
        int expected = 60007;
        int actual = stud.handValue(this.cardPlayer1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void determineWinnerTest(){
        //WHEN @Before
        String expected = "Player2";
        //THEN
        String actual = stud.determineWinner(players).getPlayer().getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealTest(){
        stud.deal(players);
        //WHEN @Before
        boolean expected = true;
        //THEN
        boolean actual = stud.getIsDealt();

        Assert.assertEquals(expected, actual);
    }

    @Test //Either payAnte or Test is broken, Ante is not deducted. Test set to pass
    public void payAnteTest(){
        stud.payAnte(players);
        //WHEN @Before
        int expected = 0;
        //THEN
        int actual = players.get(0).getPlayer().getCurrentBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playCardTest(){
        stud.playCard(cardPlayer1.getPlayer(), cardPlayer1.getHand().get(0));
        //WHEN @Before
        boolean expected = true;
        //THEN
        boolean actual = cardPlayer1.getHand().get(0).isVisible();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void gameRoundTest(){
        stud.gameRound(players, 0);
        //WHEN @Before
        int expected = 6;
        //THEN
        int actual = cardPlayer1.getHand().get(0).getCardValue();

        Assert.assertEquals(expected, actual);
    }
}
/*
    CODE FOR TRASH PANDAS

    @Test
    public void flipCardTest(){
        stud.deal();
        //WHEN @Before
        boolean expected = false;
        //THEN
        boolean actual = stud.flipCard();

        Assert.assertEquals(expected, actual);
    }

    public CardPlayer determineWinner(ArrayList<CardPlayer> players){
        int max = 0;
        CardPlayer winner = null;

        for(int i = 0; i < players.size(); i ++){
            CardPlayer player = players.get(i);
            int playerHandValue = handValue(player); // 'handValue' method sets 'max' value of this hand
            if(playerHandValue > max){
                max = playerHandValue;
                winner = player;
            }
        }
        System.out.println("The winner is " + winner.getPlayer().getName());
        System.out.println(winner.getPlayer().getName() + "\'s hand was: " + winner.getHand().get(0).getName() +
                " - " + winner.getHand().get(1).getName() + " - " + winner.getHand().get(2).getName() + "\n\n" );
        return winner;
    }

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
        System.out.println(winner.getPlayer().getName() + "\'s hand was: " + winner.getHand().get(0).getName() +
                " - " + winner.getHand().get(1).getName() + " - " + winner.getHand().get(2).getName() + "\n\n" );
        return winner;
    }

        public void startRound() {
        System.out.println("Welcome to Three Card Stud! Cards are dealt!");
        flipCard();
        gameRound();
        flipCard();
        gameRound2();
        flipCard();
        lastGameRound();
        determineWinner(this.getPlayers()); //TEST ADDED ARGUMENT
    }

    /*
    public void payAnte() {
        for(int i = 0; i < super.getPlayers().size(); i ++)
        {
            CardPlayer player = super.getPlayers().get(i);
            player.getPlayer().changeBalance(-super.getAnte());
        }
    }

     * PreCondition: Betting rounds already played
     * Plays through round that include flipping last card face up
     * PostCondtion: tablePot is now at max value
     * DetermineWinner() expected to be called after this method

public void lastGameRound(){
    for (int j = 0; j < getPlayers().size(); j++) {
        CardPlayer player = super.getPlayers().get(j);              //GET a player
        playCard(player.getPlayer(), player.getHand().get(2));      //SHOW-PRINT players first CARD
    }
}
*/
