package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee extends DiceGame implements Game, Gamble {

    DicePlayer dicePlayer;
    private Scanner scanner = new Scanner(System.in);
    int betAmount = 0;

    public Yahtzee(Player player) {
        this.dicePlayer = new DicePlayer(player);
    }

    public int getBid() {
        return betAmount;
    }

    public void setBid(int bid) {
        this.betAmount = bid;
    }

    public void startGame() {
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

        System.out.println("How much would you like to bet on this game?");
        int betAmount = scanner.nextInt();
        setBid(betAmount);
        bet(betAmount);

        startRound();
        System.out.println("You scored " + dicePlayer.getScoreSheet().getTotalScore() + " points.");
        payout();
        dicePlayer.printBalanceAtEnd();
        System.out.println();

    }

    public void startRound() {

        for (int i = 0; i < ScoreSheet.getSize(); i++) {
            for (Dice d : dicePlayer.getCup()) {
                d.roll();
            }
            System.out.println("\nYou rolled:");
            dicePlayer.printCup();
            System.out.println();

            roundRoutine();
            recordingScore();
        }

    }

    public void roundRoutine() {

        giveOptions();
        giveOptions();

    }

    public void giveOptions() {
        int choice = 0;
        System.out.print("Would you like to:\n1. Roll all dice again.\n2. Roll some dice again.\n3. Stop rolling and score.\nNumber of Selection: ");

        Scanner in = new Scanner(System.in);
        choice = in.nextInt();

        switch (choice) {
            case 1:
                for (Dice d : dicePlayer.getCup()) {
                    d.roll();
                }
                System.out.println("\nYou rolled:");
                dicePlayer.printCup();
                System.out.println();
                break;

            case 2:
                System.out.println("Which numbers would you like to reroll? List the numbers separated by spaces.");
                Scanner in2 = new Scanner(System.in);
                String diceToRoll = in2.nextLine();
                reRoll(diceToRoll);
                System.out.println("\nYou rolled:");
                dicePlayer.printCup();
                System.out.println();
                break;

            case 3:
                break;
        }
    }

    public void reRoll(String diceToRoll) {

        String[] numbersString = diceToRoll.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : numbersString) {
            numbers.add(Integer.parseInt(s));
        }

        for (Integer i : numbers) {
            for (int j = 0; j < 5; j++) {
                if (i == dicePlayer.getCup()[j].getValue()) {
                    dicePlayer.getCup()[j].roll();
                    break;
                }
            }
        }
    }

    public void recordingScore() {

        boolean validEntry = true;
        int choice = 13;
        ScoreSheet.ROW row = ScoreSheet.ROW.CHANCE;

        while (validEntry) {
            dicePlayer.getScoreSheet().printScoreCard();
            System.out.println();
            System.out.println("Which row would you like to apply your turn to on the scoresheet?.\n" +
                    "Remember you can only use each row once!");
            System.out.print("Row:");

            Scanner scanner2 = new Scanner(System.in);
            choice = scanner2.nextInt();

            switch (choice) {
                case 1:
                    row = ScoreSheet.ROW.ACES;
                    break;
                case 2:
                    row = ScoreSheet.ROW.TWOS;
                    break;
                case 3:
                    row = ScoreSheet.ROW.THREES;
                    break;
                case 4:
                    row = ScoreSheet.ROW.FOURS;
                    break;
                case 5:
                    row = ScoreSheet.ROW.FIVES;
                    break;
                case 6:
                    row = ScoreSheet.ROW.SIXES;
                    break;
                case 7:
                    row = ScoreSheet.ROW.THREEOFAKIND;
                    break;
                case 8:
                    row = ScoreSheet.ROW.FOUROFAKIND;
                    break;
                case 9:
                    row = ScoreSheet.ROW.FULLHOUSE;
                    break;
                case 10:
                    row = ScoreSheet.ROW.SMALLSTRAIGHT;
                    break;
                case 11:
                    row = ScoreSheet.ROW.LARGESTRAIGHT;
                    break;
                case 12:
                    row = ScoreSheet.ROW.YAHTZEE;
                    break;
                case 13:
                    row = ScoreSheet.ROW.CHANCE;
                    break;
            }
            if (dicePlayer.getScoreSheet().getScore(row) == null) {
                validEntry = false;
            } else {
                System.out.println("Error, you have already filled that row");
            }
        }

        dicePlayer.getScoreSheet().setRow(row, dicePlayer.getCup());
        System.out.println();
        dicePlayer.getScoreSheet().printScoreCard();
    }

    @Override
    public void bet(int betAmount) {
        dicePlayer.getPlayer().changeBalance(betAmount * -1);
    }

    @Override
    public void payout() {
        int score = dicePlayer.getScoreSheet().getTotalScore();
        int payOut = 0;
        if (score == 1575) {
            payOut = getBid() * 100;
        } else if (score > 1000) {
            payOut = getBid() * 20;
        } else if (score > 500) {
            payOut = getBid() * 10;
        } else if (score > 400) {
            payOut = getBid() * 5;
        } else if (score > 300) {
            payOut = getBid() * 3;
        } else if (score > 200) {
            payOut = getBid() * 2;
        } else {
            payOut = 0;
        }
        dicePlayer.getPlayer().changeBalance(payOut);
        System.out.println("You won $" + payOut);
    }

    @Override
    public void quit() {

    }

}