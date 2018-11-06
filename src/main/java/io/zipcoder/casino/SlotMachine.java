package io.zipcoder.casino;

import java.util.Random;
import java.util.Scanner;

public class SlotMachine implements Game, Gamble {


    @Override
    public void Bet(int betAmount) {

    }

    @Override
    public int Payout(int payoutAmount) {
        return 0;
    }

    @Override
    public void Quit() {

    }

    @Override
    public void StartGame() {

    }

    @Override
    public void StartRound() {

    }

    public static void main(String[] args) {


    //System.out.println("Enter the amount of money you wan to enter into the slot machine");
    Scanner scanner = new Scanner(System.in);

    String word="";
    String outputword="";

    Random rand = new Random();

    for(int i = 1; i <=3;i++){
        int randnum = rand.nextInt(6);

        if(randnum ==0) {
            word = "DOG";
        }
        else if(randnum ==1) {
            word = "CAT";
        }
        else if(randnum ==2) {
            word = "RABBIT";
        }
        else if(randnum ==3) {
            word = "SQUIRREL";
        }
        else if(randnum ==4) {
            word = "FISH";
        }
        else if(randnum ==5) {
            word = "MOUSE";
        }
        outputword += word;
    }

    System.out.println(outputword);

        if(){}



}

}

