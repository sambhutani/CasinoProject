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

    public static void getBet(String phrase){
        printMessage("What is the " + phrase + " at the table you're looking for?");
    }

    public static void unacceptableMaxBet(int minBet){
        printMessage("Your bet must be above " + minBet);
    }

    public static void unacceptableMinBet(){
        printMessage("Your bet must be above $0");
    }

    public static void studHandsDealt(){
        printMessage("Each player Dealt 3 cards");
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
    
    public static void wrongCommand(){
        printMessage("Sorry, there is no game with that name.");
    }

    public static void printWarTurnResult(String name, String cardName, int handSize){
        printMessage(name + " has played " + cardName + " and has " + handSize + " cards left.");
    }

    public static void playedFaceDown(String name){
        printMessage(name + " has played a card face down.");
    }

    public static void startSlots(){
        printMessage("You are all set to play a new slot game..zrrr..! \n");
    }

    public static void payOut(int payout){
        printMessage("Your payout amount for slot machine is: $" + payout + "\n");
    }


}
