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
        gameLib.add("slot");
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
            getGameIndex();

            int command = getIntFromUser();

            switch (command) {

                case 2:
                    int[] warMinMax = getMinMax();
                    Game war = new War(warMinMax[0], warMinMax[1], 10);
                    ((War) war).addPlayers(player);
                    ((War) war).addNpc();
                    war.startGame();
                    break;

                case 3:
                    int[] studMinMax = getMinMax();
                    Game stud = new Stud(studMinMax[0], studMinMax[1], 10);
                    ((Stud) stud).addPlayers(player);
                    ((Stud) stud).addNpc();
                    stud.startGame();
                    break;

                case 4:
                    //call the function to get the bet amount
                    int slotBet1= getSlotBet();
                    // call slot machine constructor ie. create object
                    Game slot= new SlotMachine(slotBet1);
                    slot.startGame();
                    // start game
                    ((SlotMachine) slot).payout();
                    break;

                case 1:
                    Game yahtzee = new Yahtzee(player);
                    yahtzee.startGame();
                    break;

                case 5:
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

    //function to get the bet amount for slot game
    public int getSlotBet(){
        System.out.println("Enter the amount you want to bet on Slot");
        int slotBet= scanner.nextInt();
        return slotBet;

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

    public void getGameIndex(){
        int i=1;

        for (String s: gameLib) {
            System.out.println("Enter "+i+ " for : " + s  );
            i++;

        }
    }
}
