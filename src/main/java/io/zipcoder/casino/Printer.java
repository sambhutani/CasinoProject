package io.zipcoder.casino;

public class Printer {

    public static void noMatchingGameName(String[] gameNames){

        String games = "";

        for(int i = 0; i < gameNames.length; i ++){
            games += gameNames[i] + " ";
        }
        games = games.trim();

        System.out.println("Sorry, there is no game with that name, try one of: " + games);
    }

    public static void getBet(String phrase){
        System.out.println("What is the " + phrase + " at the table you're looking for?");
    }

    public static void unacceptableMaxBet(int minBet){
        System.out.println("Your bet must be above " + minBet);
    }

    public static void unacceptableMinBet(){
        System.out.println("Your bet must be above $0");
    }
}
