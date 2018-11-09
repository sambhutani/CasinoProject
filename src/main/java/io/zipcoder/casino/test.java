package io.zipcoder.casino;

public class test {
    public static void main(String[] args){
        Player player = new Player("NickTest", 100);
        Game stud = new Stud(10);
        ((Stud) stud).addPlayers(player);
        ((Stud) stud).addNpc();
        stud.startGame();
    }
}