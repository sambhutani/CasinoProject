package io.zipcoder.casino;

public class Dice {


    private int value;

    public void roll(){

        value = (int) (Math.random()*6+1);

        //Generate a random number between 1 and 6
        //set value equal to this number

    }

    public int getValue()
    {
        return value;
    }
}
