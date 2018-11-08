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
        yahtzee.createGame();
        int expected = 5;
        int actual = yahtzee.getDicePlayer().getCup().length;

        //Then
        Assert.assertEquals(expected, actual);


    }


}
