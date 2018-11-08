package io.zipcoder.casino;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> gameLib = new ArrayList<>();
    private Game game = null;
    private Player player;
    public boolean running = true;

    private ArrayList<Player> players = new ArrayList<>();



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

        Player player = new Player(name, balance);
        players.add(player);
    }

    /**
     * Currently required to make Stud a 2 player game, could later refactor to declare 'player' in createAccount method and pass to PlayerArray
     */

    public void chooseGame()
    {
        while(running) {
            System.out.println("Please choose a game to play!");
            String command = getCommand();

            switch (command) {

                case "war":
                    Game war = new War(10);
                    ((War) war).addPlayers(players.get(0));
                    ((War) war).addNpc();
                    war.startGame();
                    break;

                case "stud":
                    Game stud = new Stud( 10);
                    ((Stud) stud).addPlayers(players.get(0));
                    addStudPlayers(stud);
                    stud.startGame();
                    break;

                case "yahtzee":
                    Game yahtzee = new Yahtzee(players.get(0));
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

    public int getStudPlayers() {
        int numOfStudPlayers = 0;

        while (numOfStudPlayers <= 1) {

            System.out.println("How many players are there?");
            try {
                numOfStudPlayers = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number");
            }
        }

        return numOfStudPlayers;
    }

    public void addStudPlayers(Game game){
        int numPlayers = getStudPlayers();

        for(int i = 1; i < numPlayers; i ++) {
            createAccount();
            ((Stud) game).addPlayers(players.get(i));
        }
    }
}
