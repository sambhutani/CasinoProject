//Lauren

package io.zipcoder.casino;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ScoreSheet {

    private enum ROW{
        ACES, TWOS, THREES, FOURS, FIVES, SIXES, THREEOFAKIND, FOUROFAKIND, FULLHOUSE, SMALLSTRAIGHT, LARGESTRAIGHT, YAHTZEE, CHANCE;
    }
    private Map<ROW, Integer> scores = new EnumMap<>(ROW.class);

    ScoreSheet(){

    }

    public int getTotalScore() {

        int topTotalScore = 0;
        int bottomTotalScore = 0;
        int index = 0;
        for(ROW r : ROW.values()) {
            while (index < 6) {
                topTotalScore += scores.get(r);
                index++;
            }
            if (topTotalScore >= 63) {
                topTotalScore += 35;
            }
            while (index >= 6) {
                bottomTotalScore += scores.get(r);
                index++;
            }
        }
        return topTotalScore + bottomTotalScore;
        }


    public void setScore(int score) {

    }

    public void printScore(){

    }

    public void setRow(ROW row){

        switch(row) {
            case ACES:
                break;
            case TWOS:
                break;
            case THREES:
                break;
            case FOURS:
                break;
            case FIVES:
                break;
            case SIXES:
                break;
            case THREEOFAKIND:
                break;
            case FOUROFAKIND:
                break;
            case FULLHOUSE:
                break;
            case SMALLSTRAIGHT:
                break;
            case LARGESTRAIGHT:
                break;
            case YAHTZEE:
                break;
            case CHANCE:
                break;
        }

    }

    public void calculateScore(ROW row, int value){

    }
}
