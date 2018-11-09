package io.zipcoder.casino;

import java.util.ArrayList;

public class Printer {

    public static void printMessage(String string) {
        System.out.println(string);
    }

    public static void noMatchingGameName(ArrayList<String> gameNames){

        String games = "";

        for(int i = 0; i < gameNames.size(); i ++){
            games += gameNames.get(i) + " ";
        }
        games = games.trim();

        printMessage("Sorry, there is no game with that name, try one of: " + games);
    }

    public static void showCard(Player player, Card card){
        printMessage(player.getName() + " shows a " + card.getName());
    }

    public static void pickGameMsg(){
        printMessage("Please choose a game to play!");
    }

    public static void closeGameMsg(){
        printMessage("Thanks for your money chump!");
    }

    public static void pleaseEnterNum(){
        printMessage("Please enter a number");
    }
    
    public static void welcomeTo(String gameName){
        printMessage("Welcome to " + gameName + "!");
    }

    public static void printWarTurnResult(String name, String cardName, int handSize){
        printMessage(name + " has played " + cardName + " and has " + handSize + " cards left.");
    }

    public static void playedFaceDown(String name){
        printMessage(name + " has played a card face down.");
    }

}
