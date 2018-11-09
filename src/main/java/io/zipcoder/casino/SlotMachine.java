package io.zipcoder.casino;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class SlotMachine implements Game, Gamble {
    private int betAmount;
    private int payout=0;

    public SlotMachine(int betAmount) {
        this.betAmount = betAmount;
    }

    @Override
    public void bet(int betAmount) {
        this.betAmount= betAmount;

    }

    @Override
    public void payout(){
        Printer.printMessage("Your payout amount for slot machine is: $" + payout + "\n");
    }

    @Override
    public void startGame() {
        Printer.printMessage("You are all set to play a new slot game..zrrr..! \n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Printer.printMessage("Your slot is in progress"+"\n");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String word="";
        String outputword="";
        String word1="";
        String word2="";
        String word3="";
        //int useramount=0;
        char playAgain= 'y';
        double totalBet=0;

       // while(playAgain=='y'){

            outputword="";

            Random rand = new Random();

            for(int i = 1; i <=3;i++){
                int randnum = rand.nextInt(6);
                //System.out.println(randnum);

                if(randnum == 0) {
                    word = "DOG";
                  //  System.out.println("dog");
                }
                else if(randnum == 1) {
                    word = "CAT";
                  //  System.out.println("cat");
                }
                else if(randnum == 2) {
                    word = "RABBIT";
                  //  System.out.println("kjsd");
                }
                else if(randnum == 3) {
                    word = "SQUIRREL";
                  //  System.out.println("sq");
                }
                else if(randnum == 4) {
                    word = "FISH";
                  //  System.out.println("ff");
                }
                else if(randnum == 5) {
                    word = "MOUSE";
                  //  System.out.println("mm");
                }
                // outputword += word;

                if(i == 1){
                    word1= word;
                //    System.out.println(i);
                }

                else if(i == 2){
                    word2= word;
                  //  System.out.println(i);
                }

                else if(i == 3){
                    word3= word;
                   // System.out.println(word3);
                }
            }
            outputword= "[ " + word1+ " ]" + "   " + "[ " + word2 + " ]" + "   "+ "[ " + word3 + " ]" + "\n" ;

            if(((!word1.equals(word2)) )&& ((!word1.equals(word3))) && ((!word2.equals(word3)))){

                outputword= outputword + "\n"+" You have won $0";
                payout=0;
            }

            else if( ((word1.equals(word2) == true) && (word1.equals(word3)== false )) || ((word1.equals(word3)== true) && (word1.equals(word2)==false)) || ( (word2.equals(word3)==true) && (word2.equals(word1))==false)){

                outputword= outputword + "\n" +" You have won $" + (betAmount*2);
                payout=betAmount*2;
            }


            else if( ((word1.equals(word2)==true) && (word1.equals(word3)==true) ) && ((word2.equals(word1)==true) && (word2.equals(word3)==true)) && ( (word3.equals(word1)==true) && (word3.equals(word2)==true))){

                outputword= outputword + "\n" + "You have won $" + (betAmount*3);
                payout=betAmount*3;
            }

            Printer.printMessage(( outputword + "\n" ));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startRound() {

    }
}

