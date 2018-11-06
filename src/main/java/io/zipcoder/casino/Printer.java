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


}
