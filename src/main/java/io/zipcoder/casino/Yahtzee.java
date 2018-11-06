package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee extends DiceGame implements Game{

    private Dice[] cup;
    DicePlayer dicePlayer;
    private Scanner scanner = new Scanner(System.in);

    public Yahtzee(Player player) {
        this.dicePlayer = new DicePlayer(player);
    }

    public void compareScore(DicePlayer player1, DicePlayer player2){

        player1.getScoreSheet().getTotalScore();
    }

    public void reRoll(String diceToRoll){

        String[] numbersString = diceToRoll.replace(",", "").split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for(String s: numbersString) {
            numbers.add(Integer.parseInt(s));
        }
        for(Integer i : numbers) {
            for(int j = 0; j < 5; j++) {
                if(i == dicePlayer.getCup()[j].getValue()) {
                    dicePlayer.getCup()[j].roll();
                    break;
                }
            }
        }
    }

    /**
     * implemented from 'Game'
     */
    public void Quit() {

    }

    public void StartGame() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();

        dicePlayer.getCup()[0] = dice1;
        dicePlayer.getCup()[1] = dice2;
        dicePlayer.getCup()[2] = dice3;
        dicePlayer.getCup()[3] = dice4;
        dicePlayer.getCup()[4] = dice5;
    }

    public void StartRound() {

        for(int i = 0; i < ScoreSheet.getSize(); i++) {
            for (Dice d : dicePlayer.getCup()) {
                d.roll();
            }
            dicePlayer.printCup();

            roundRoutine();
            recordingScore();
        }

    }

    public void recordingScore() {
            System.out.println("Which row would you like to apply your turn to on the scoresheet?.\n" +
                    "Remember you can only use each row once!");
            dicePlayer.getScoreSheet().printScoreCard();

            int choice = scanner.nextInt();
            ScoreSheet.ROW row = ScoreSheet.ROW.CHANCE;
            switch(choice) {
                case 1: row = ScoreSheet.ROW.ACES;
                    break;
                case 2: row = ScoreSheet.ROW.TWOS;
                    break;
                case 3: row = ScoreSheet.ROW.THREES;
                    break;
                case 4: row = ScoreSheet.ROW.FOURS;
                    break;
                case 5: row = ScoreSheet.ROW.FIVES;
                    break;
                case 6: row = ScoreSheet.ROW.SIXES;
                    break;
                case 7: row = ScoreSheet.ROW.THREEOFAKIND;
                    break;
                case 8: row = ScoreSheet.ROW.FOUROFAKIND;
                    break;
                case 9: row = ScoreSheet.ROW.FULLHOUSE;
                    break;
                case 10: row = ScoreSheet.ROW.SMALLSTRAIGHT;
                    break;
                case 11: row = ScoreSheet.ROW.LARGESTRAIGHT;
                    break;
                case 12: row = ScoreSheet.ROW.YAHTZEE;
                    break;
                case 13: row = ScoreSheet.ROW.CHANCE;
                    break;
            }
            dicePlayer.getScoreSheet().setRow(row, dicePlayer.getCup());
        }


    public void roundRoutine(){

        for(int i = 0; i < 2; i++) {
            System.out.println("Would you like to:\n1. Roll all dice again.\n2. Roll some dice again.\n3.Stop rolling and score.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (Dice d : dicePlayer.getCup()) {
                        d.roll();
                    }
                    dicePlayer.printCup();
                    break;

                case 2:
                    System.out.println("Which numbers would you like to reroll?");
                    String diceToRoll = scanner.next();
                    reRoll(diceToRoll);
                    dicePlayer.printCup();
                    break;

                case 3:
                    break;
            }
        }

    }
}
