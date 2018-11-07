package io.zipcoder.casino;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> gameLib = new ArrayList<>();
    private Game game = null;
    private Player player;
    private Player player2;         //need to run createAccount for player two for Stud
    private boolean running = true;


    Console(){
        gameLib.add("yahtzee");
        gameLib.add("war");
        gameLib.add("stud");
    }

    public void createAccount()
    {
        System.out.println("Hello, what is your name?");
        String name = scanner.next();

        System.out.println("How much money are you bringing to the table?");
        int balance = getIntFromUser();

        player = new Player(name, balance);
    }

    /**
     * Currently required to make Stud a 2 player game, could later refactor to declare 'player' in createAccount method and pass to PlayerArray
     */
    public void createAccount2()
    {
        System.out.println("Hello, what is your name?");
        String name = scanner.next();

        System.out.println("How much money are you bringing to the table?");
        int balance = getIntFromUser();

        player2 = new Player(name, balance);
    }

    public void chooseGame()
    {
        //get the command from the user
        String command = continueAskGame();
        //process the command
        switch(command){

            case "war":
                int[] warMinMax = getMinMax();
                Game war = new War(warMinMax[0], warMinMax[1], 10);
                ((War) war).addPlayers(player);
                ((War) war).addNpc();
                war.StartGame();
                break;

            case "stud":
                int[] studMinMax = getMinMax();
                Game stud = new Stud(studMinMax[0], studMinMax[1], 10);
                System.out.println("Three card stud is a two player game.\nPlayer 2:\n");
                createAccount2();
                ((Stud) stud).addPlayers(player);
                ((Stud) stud).addPlayers(player2);
                stud.StartGame();
                break;

            case "yahtzee":
                Game yahtzee = new Yahtzee(player);
                yahtzee.StartGame();
                break;

            default:
                Printer.noMatchingGameName(gameLib);
                break;
        }
    }

    public int getIntFromUser(){
        try{
            int num = scanner.nextInt();
            return num;
        }catch(InputMismatchException err){
            System.out.println("Please enter a number");
            scanner.next();
        }
        return -1;
    }

    public int[] getMinMax(){
        Printer.getBet("minimum bet");
        int min = 0;
        while(min <= 0){
            min = getIntFromUser();
            if(min < 0){
                Printer.unacceptableMinBet();
            }
        }

        Printer.getBet("maximum bet");
        int max = 0;
        while(max < min) {
            max = getIntFromUser();
            if(max < min){
                Printer.unacceptableMaxBet(min);
            }
        }
        int[] minMax = {min, max};
        return minMax;
    }

    public String getCommand() {
        String command = "";
        String input = scanner.next();
        input = input.toLowerCase().trim();

        for(String name : gameLib){
            if(input.equals(name)){
                command = name;
                break;
            }
        }
        command = command.toLowerCase().trim();
        return command;
    }

    public String continueAskGame(){
        String command = "";

        System.out.println("Please choose a game to play!");
        command = getCommand();

        if(gameLib.indexOf(command) == -1)
        {
            while(gameLib.indexOf(command) == -1)
            {
                Printer.noMatchingGameName(gameLib);
                command = getCommand();
            }
        }
        return command;
    }

}
