package io.zipcoder.casino;


import java.util.ArrayList;
import java.util.InputMismatchException;

public class Casino {
    public boolean running = true;
    private ArrayList<String> gameLib = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private Console console = new Console();
    private Game game = null;
    private Player player;

    public Casino(){
        gameLib.add("yahtzee");
        gameLib.add("war");
        gameLib.add("stud");
        gameLib.add("slot");
        gameLib.add("quit");
    }

    public static void main(String[] args){
        Casino casino = new Casino();
        //get a player
        casino.setPlayer(casino.getConsole().createAccount());
        //player picks game
        casino.chooseGame();
    }

    public String getGameListing(){
        int i=1;
        String list = "";
        for (String s: gameLib) {
            list += "Enter "+i+ " for : " + s + "\n";
            i++;
        }
        return list;
    }

    public void chooseGame()
    {
        while(running) {

            Printer.printMessage("Please choose a game to play!");
            Printer.printMessage(getGameListing());

            int command = console.getIntFromUser("Please choose a game to play by entering the number next to the game.");

            switch (command) {

                case 2:
                    Game war = new War(10);
                    ((War) war).addPlayers(player);
                    ((War) war).addNpc();
                    game = war;
                    war.startGame();
                    break;

                case 3:
                    Game stud = new Stud(10);
                    ((Stud) stud).addPlayers(player);
                    ((Stud) stud).addNpc();
                    game = stud;
                    stud.startGame();
                    break;

                case 4:
                    int slotBet1= console.getIntFromUser("Enter the amount you want to bet on Slot");
                    if ((slotBet1 < 0) || (slotBet1 >100) )
                    {
                        Printer.printMessage("Invalid bet amount entered, min bet for slot is $1 and max $100 ");
                        break;
                    }
                    Game slot= new SlotMachine(slotBet1);
                    game = slot;
                    slot.startGame();
                    ((SlotMachine) slot).slotResult();
                    ((SlotMachine) slot).payout();
                    break;

                case 1:
                    Game yahtzee = new Yahtzee(player);
                    game = yahtzee;
                    ((Yahtzee) yahtzee).startGame();
                    int betAmount = console.getIntFromUser("How much would you like to bet on this game?");
                    ((Yahtzee) yahtzee).setBid(betAmount);
                    ((Yahtzee) yahtzee).bet(betAmount);
                    yahtzee.startRound();
                    Printer.printMessage("You scored " + ((Yahtzee) yahtzee).getDicePlayer().getScoreSheet().getTotalScore() + " points.");
                    ((Yahtzee) yahtzee).payout();
                    Printer.printMessage(((Yahtzee) yahtzee).getDicePlayer().balanceAtEnd() + "\n");
                    break;

                case 5:
                    running = false;
                    Printer.printMessage("Thanks for the money chump!");
                    break;

                default:
                    Printer.noMatchingGameName(gameLib);
                    break;
            }
        }
    }

    public Console getConsole() {
        return console;
    }

    public int getStudPlayers() {
        int numOfStudPlayers = 0;

        while (numOfStudPlayers <= 1) {

            numOfStudPlayers = console.getIntFromUser("How many players are there?");
        }
        return numOfStudPlayers;
    }

    public void addStudPlayers(Game game){
        int numPlayers = getStudPlayers();

        for(int i = 1; i < numPlayers; i ++) {
            console.createAccount();
            ((Stud) game).addPlayers(players.get(i));
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<String> getGameLib() {
        return gameLib;
    }

    public Game getGame() {
        return game;
    }
    public boolean isRunning() {
        return running;
    }
}
