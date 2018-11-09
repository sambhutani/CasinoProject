package io.zipcoder.casino;


import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

public class SlotTest {


    @Test
    public void testSlotResult1(){
        int betAmount=10;
        String word1="MOUSE";
        String word2="MOUSE";
        String word3="MOUSE";
        //given
        SlotMachine slotmachine = new SlotMachine(betAmount);

        slotmachine.slotResult();
        int payout=slotmachine.payout;
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

        slotmachine.slotResult();
        int payout=slotmachine.payout;
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

        slotmachine.slotResult();
        int payout=slotmachine.payout;
        Assert.assertEquals(0,payout);

    }



}
