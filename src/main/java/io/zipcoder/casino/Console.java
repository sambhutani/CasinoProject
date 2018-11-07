package io.zipcoder.casino;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> gameLib = new ArrayList<>();
    private Game game = null;
    private Player player;
    private boolean running = true;

    Console(){
        gameLib.add("yahtzee");
        gameLib.add("war");
        gameLib.add("stud");
        gameLib.add("quit");
    }

    public void createAccount()
    {
        System.out.println("Hello, what is your name?");
        String name = scanner.next();

        System.out.println("How much money are you bringing to the table?");
        int balance = getIntFromUser();

        player = new Player(name, balance);
    }

    public void chooseGame()
    {
        while(running) {
            System.out.println("Please choose a game to play!");
            String command = getCommand();

            switch (command) {

                case "war":
                    int[] warMinMax = getMinMax();
                    Game war = new War(warMinMax[0], warMinMax[1], 10);
                    ((War) war).addPlayers(player);
                    ((War) war).addNpc();
                    war.startGame();
                    break;

                case "three card stud":
                    int[] studMinMax = getMinMax();
                    Game stud = new Stud(studMinMax[0], studMinMax[1], 10);
                    ((Stud) stud).addPlayers(player);
                    ((Stud) stud).addNpc();
                    stud.startGame();
                    break;

                case "yahtzee":
                    Game yahtzee = new Yahtzee(player);
                    yahtzee.startGame();
                    break;

                case "quit":
                    System.out.println("Thanks for your money chump!");
                    running = false;
                    break;

                default:
                    Printer.noMatchingGameName(gameLib);
                    break;
            }
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
