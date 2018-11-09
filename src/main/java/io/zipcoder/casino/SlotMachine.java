package io.zipcoder.casino;

import java.util.Random;

public class SlotMachine implements Game, Gamble {
    private int betAmount;
    private int payoutAmt=0;
    String word="";
    String outputword="";

    String word1="";
    String word2="";
    String word3="";
    double totalBet=0;

    public SlotMachine(int betAmount) {
        this.betAmount = betAmount;
    }

    @Override
    public void bet(int betAmount) {
        this.betAmount= betAmount;
    }

    public void payout(){
        Printer.printMessage("Your payout amount for slot machine is: $" + payoutAmt + "\n");
    }

    @Override
    public void startGame() {
        Printer.printMessage("You are all set to play a new slot game..zrrr..! \n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Printer.printMessage("Your slot is in progress" + "\n");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        outputword = "";

        Random rand = new Random();

        for (int i = 1; i <= 3; i++) {
            int randnum = rand.nextInt(6);


            if (randnum == 0) {
                word = "DOG";

            } else if (randnum == 1) {
                word = "CAT";

            } else if (randnum == 2) {
                word = "RABBIT";

            } else if (randnum == 3) {
                word = "SQUIRREL";

            } else if (randnum == 4) {
                word = "FISH";

            } else if (randnum == 5) {
                word = "MOUSE";

            }

            if (i == 1) {
                word1 = word;
            } else if (i == 2) {
                word2 = word;
            } else if (i == 3) {
                word3 = word;
            }
        }

    }

    public void slotResult()
    {
            outputword= "[ " + word1+ " ]" + "   " + "[ " + word2 + " ]" + "   "+ "[ " + word3 + " ]" + "\n" ;

            if(((!word1.equals(word2)) )&& ((!word1.equals(word3))) && ((!word2.equals(word3)))){

                outputword= outputword + "\n"+" You have won $0";
                payoutAmt=0;
            }
            else if( (word1.equals(word2) && (!word1.equals(word3))) || ((word1.equals(word3)) && (!word1.equals(word2))) || ((word2.equals(word3)) && (!word2.equals(word1)))){

                outputword= outputword + "\n" +" You have won $" + (betAmount*2);
                payoutAmt=betAmount*2;
            }


            else if(word1.equals(word2) && word1.equals(word3)  /*&& ((word2.equals(word1)) && (word2.equals(word3))) && ( (word3.equals(word1)) && (word3.equals(word2)))*/){
                outputword= outputword + "\n" + "You have won $" + (betAmount*3);
                payoutAmt=betAmount*3;
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
    public int getPayoutAmt() {
        return payoutAmt;
    }
    public void setWord1(String word1) {
        this.word1 = word1;
    }

    public void setWord2(String word2) {
        this.word2 = word2;
    }

    public void setWord3(String word3) {
        this.word3 = word3;
    }
}

