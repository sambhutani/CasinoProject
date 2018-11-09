package io.zipcoder.casino;


import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.Random;


public class SlotTest {
    private int betAmount = 10;
    private SlotMachine slotmachine = new SlotMachine(betAmount);

    @Test
    public void testSlotResult1(){
        String word1="MOUSE";
        String word2="MOUSE";
        String word3="MOUSE";
        //given
        slotmachine.setWord1(word1);
        slotmachine.setWord2(word2);
        slotmachine.setWord3(word3);

        slotmachine.slotResult();
        int payout = slotmachine.getPayoutAmt();
        Assert.assertEquals(30,payout);
    }


    @Test
    public void testSlotResult2(){
        String word1="MOUSE";
        String word2="MOUSE";
        String word3="CAT";


        //given
        slotmachine.setWord1(word1);
        slotmachine.setWord2(word2);
        slotmachine.setWord3(word3);

        slotmachine.slotResult();
        int payout=slotmachine.getPayoutAmt();
        Assert.assertEquals(20,payout);

    }

    @Test
    public void testSlotResult3(){
        int betAmount=10;
        String word1="MOUSE";
        String word2="RABBIT";
        String word3="CAT";

        //given
        SlotMachine slotmachine = new SlotMachine(betAmount);

        slotmachine.setWord1(word1);
        slotmachine.setWord2(word2);
        slotmachine.setWord3(word3);

        slotmachine.slotResult();
        int payout=slotmachine.getPayoutAmt();
        Assert.assertEquals(0,payout);

    }

    @Test
    public void testSetBetAmount(){
        int betAmount=10;
        SlotMachine slotmachine = new SlotMachine(betAmount);

        int newBet = 40;

        slotmachine.bet(newBet);

        int actual = slotmachine.betAmount;

        Assert.assertEquals(newBet, actual);

    }

    @Test
    public void testGenerateWords(){
        Random random = new Random(1);


        String expectedWord1 = "SQUIRREL";
        String expectedWord2 = "FISH";
        String expectedWord3 = "CAT";

        slotmachine.generateWords(random);

        Assert.assertEquals(expectedWord1, slotmachine.word1);

    }

}
