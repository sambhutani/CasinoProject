package io.zipcoder.casino;
import java.util.Scanner;

public class Console {
    private String[] gameLib = {"yahtzee", "war", "three card stud"};
    private String command = "";
    private Scanner scanner = new Scanner(System.in);
    private Game[] games = {new War(), new Stud(), new Yahtzee()};
    private Player player;
    private boolean running = true;

    Console(){}

    public void createAccount()
    {

        /*
            ask the player for their name.
            ask the player for their starting balance
            create the player.
         */
    }

    public void chooseGame(String gameName)
    {
        String input = scanner.next();
        input = input.toLowerCase().trim();

        for(String name : gameLib){
            if(input.equals(name)){
                command = name;
                break;
            }
        }
        command = command.toLowerCase().trim();
        switch(command){

            case "yahtzee":

                break;

            case "war":

                break;


            case "three card stud":

                break;

            case "3 card stud":

                break;


            default:
                Printer.noMatchingGameName(gameLib);
                break;
        }


        /*
            ask the user for min max bet at the table
            ask the user which game they would like to play
            create a new game with min and max set based
            on user input
         */
    }
}
