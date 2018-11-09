package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class WarTest {

    @Test
    public void warTest01(){
        War war = new War(10);
        war.addNpc();
        war.addNpc();

        Assert.assertEquals(2, war.getPlayers().size());
    }

    @Test
    public void playCardPileTest(){
        Deck deck = new Deck();
        War war = new War(10);
        Player player = new Player("Jon", 100);
        war.addPlayers(player);
        war.chooseStatingPlayer();
        war.deal();
        war.getPlayers().get(0).setDiscard(deck);

        war.playCardFromPile(false);

        Assert.assertEquals(103, war.getPlayers().get(0).getHand().size());
    }

    @Test
    public void playCardTest() {
        War war = new War(10);
        Player player = new Player("Jon", 100);
        war.addPlayers(player);
        war.chooseStatingPlayer();
        war.playCard(false);

        Assert.assertEquals(war.getLoser(), player);
    }

}
