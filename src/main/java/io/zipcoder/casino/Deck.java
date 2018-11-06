package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> deck;

    /**
     * Deck constructor will create an array of all 52 @Card 's
     * Then, they are shuffled
     */
    public Deck(){
        createDeck();
    }

    public void createDeck(){
        this.deck = new ArrayList<>();

        for (int i = 0; i < 13; i++){
            Card.CardValue value = Card.CardValue.values()[i];

            for (int j = 0; j < 4; j++){
                Card card = new Card(value, Card.Suit.values()[j]);
                this.deck.add(card);
            }
        }
        Collections.shuffle(deck);
    }

    /**
     * Will retrieve a card at requested index, but will NOT REMOVE
     * Likely just for testing
     * @param index
     * @return
     */
    public Card getCard(int index){
        return this.deck.get(index);
    }

    /**
     * Will retrieve AND REMOVE card from ZERO INDEX
     * @return
     */
    public Card pullCard(){
        Card tempCard = this.deck.remove(0);
        return tempCard;
    }

    /**
     * Used to retrieve the array with instantiated deck shuffled
     * Will RETURN DECK
     * @return
     */
    public ArrayList<Card> getDeck() {
        return this.deck;
    }
}
