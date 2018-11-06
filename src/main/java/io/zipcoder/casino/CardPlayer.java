package io.zipcoder.casino;

import java.util.ArrayList;

public class CardPlayer {
    private Player player;
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> discard = new ArrayList<>();

    public ArrayList<Card> getHand(){
        return hand;
    }

    public Player getPlayer() {
        return player;
    }
}
