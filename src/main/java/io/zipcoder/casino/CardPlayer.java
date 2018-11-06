package io.zipcoder.casino;

import java.util.ArrayList;

public class CardPlayer {
    private Player player;
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> discard = new ArrayList<>();

    public CardPlayer(Player player){
        this.player = player;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public Player getPlayer() {
        return player;
    }

    public Card playCard(){

        if(hand.size() > 0){
            Card card = hand.get(hand.size()-1);
            hand.remove(hand.size()-1);

            return card;
        }

        return null;
    }
}
