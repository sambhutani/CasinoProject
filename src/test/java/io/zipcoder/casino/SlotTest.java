package io.zipcoder.casino;


import org.junit.Test;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class SlotTest {

    @Test
    public void testSlotResult1(){
        int betAmount=10;
        String word1="MOUSE";
        String word2="MOUSE";
        String word3="MOUSE";
        //given
        SlotMachine slotmachine = new SlotMachine(betAmount);
        slotmachine.setWord1(word1);
        slotmachine.setWord2(word2);
        slotmachine.setWord3(word3);

        slotmachine.slotResult();
        int payout = slotmachine.getPayoutAmt();
        Assert.assertEquals(30,payout);
    }


    @Test
    public void testSlotResult2(){
        int betAmount=10;
        String word1="MOUSE";
        String word2="MOUSE";
        String word3="CAT";


        //given
        SlotMachine slotmachine = new SlotMachine(betAmount);

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
}
