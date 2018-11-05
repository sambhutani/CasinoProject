package io.zipcoder.casino;

public class ScoreSheet {
    private int score;

    ScoreSheet(){
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void printScore(){
        System.out.println(score);
    }

    public void setRow(String setRow){

    }
}
