package io.zipcoder.casino;

import org.junit.Test;

public class StudTest {
    public static void main(String[] args){
        Casino casino = new Casino();
        //get a player
        casino.setPlayer(casino.getConsole().createAccount());
        //player picks game
        casino.chooseGame();
    }

    @Test
    public void thismethod(){

    }
}
