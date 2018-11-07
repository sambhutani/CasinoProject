package io.zipcoder.casino;

import java.util.Random;
import java.util.Scanner;

public class SlotMachine implements Game, Gamble {

// implemented from gamble
    @Override
    public void Bet(int betAmount) {

    }

    @Override
    public int Payout(int payoutAmount) {
        return 0;
    }


    // implementd from game

    @Override
    public void Quit() {

    }

    @Override
    public void StartGame() {
        System.out.println("Welcome to Slot Machine!");


    }

    @Override
    public void StartRound() {

    }

    public static void main(String[] args) {


    //System.out.println("Enter the amount of money you wan to enter into the slot machine");
    Scanner scanner = new Scanner(System.in);

    String word="";
    String outputword="";
    String word1="";
    String word2="";
    String word3="";
    int useramount=0;
    char playAgain= 'y';
    double totalBet=0;

    while(playAgain=='y'){

        outputword="";

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
            // outputword += word;

            if(i==1){
                word1= word;
            }

            else if(i==2){
                word2= word;
            }

            else if(i==3){
                word3= word;
            }
        }
        outputword+= "[ " + word1+ " ]" + "   " + "[ " + word2 + " ]" + "   "+ "[ " + word3 + " ]" ;


        if((word1 != word2) && (word1 != word3) && (word2 != word3)){

            outputword= outputword + "/n You have won $0";
        }

        else if( ((word1==word2) && (word1 != word3) ) || ((word1== word3) && (word1 != word2)) || ( (word2== word3) && (word2 != word1))){

            outputword= outputword + "/n You have won $" + (useramount*2);
        }


        else if( ((word1==word2) && (word1 ==word3) ) && ((word2==word1) && (word2 ==word3)) && ( (word3== word1) && (word3 ==word2))){

            outputword= outputword + "/n You have won $" + (useramount*3);
        }

        System.out.println(( outputword + "/n/n/nDo you want to play again? /n/nPress y for yes, any key for no.").charAt(0));

        //System.out.println(outputword);



    }






}

}

