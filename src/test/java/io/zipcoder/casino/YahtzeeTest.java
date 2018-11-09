package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class YahtzeeTest {

    Player player = new Player("Dan", 1000);
    Yahtzee yahtzee = new Yahtzee(player);

    @Test
    public void testBet() {
        //When
        yahtzee.bet(400);
        int expected = 600;
        int actual = player.getCurrentBalance();

        //Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testSetBidGetBid() {
        //When
        yahtzee.setBid(400);
        int expected = 400;
        int actual = yahtzee.getBid();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateGame() {
        //When
        yahtzee.startGame();
        int expected = 5;
        int actual = yahtzee.getDicePlayer().getCup().length;

        //Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testRollOptionsNoRoll() {
        //When
        yahtzee.startGame();
        String expected = yahtzee.getDicePlayer().cupToString();
        yahtzee.rollOptions(3);
        String actual = yahtzee.getDicePlayer().cupToString();

        //Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testRollOptionsRollAll() {
        //When
        yahtzee.startGame();
        String expected = yahtzee.getDicePlayer().cupToString();
        yahtzee.rollOptions(1);
        String actual = yahtzee.getDicePlayer().cupToString();

        //Then
        Assert.assertNotEquals(expected, actual);


    }

    @Test
    public void testReRoll() {
        //When
        yahtzee.startGame();
        int diceOneValue = yahtzee.getDicePlayer().getCup()[0].getValue();
        int diceTwoValue = yahtzee.getDicePlayer().getCup()[1].getValue();
        yahtzee.reRoll(Integer.toString(diceTwoValue));
        int actual = yahtzee.getDicePlayer().getCup()[0].getValue();

        //Then
        Assert.assertNotEquals(diceOneValue, actual);


    }

    @Test
    public void testEmptyRowTrue() {
        //When
        yahtzee.startGame();

        //Then
        Assert.assertTrue(yahtzee.checkEmptyRow(ScoreSheet.ROW.CHANCE));


    }

    @Test
    public void testEmptyRowFalse() {
        //When
        yahtzee.startGame();
        yahtzee.rollAll();
        yahtzee.getDicePlayer().getScoreSheet().setRow(ScoreSheet.ROW.CHANCE, yahtzee.getDicePlayer().getCup());

        //Then
        Assert.assertFalse(yahtzee.checkEmptyRow(ScoreSheet.ROW.CHANCE));


    }


}
