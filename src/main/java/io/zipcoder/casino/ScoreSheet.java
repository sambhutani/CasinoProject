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

    public void setRow(ROW row, Dice[] cup){

        switch(row) {
            case ACES:
                scores.put(ROW.ACES, calculateScore(ROW.ACES, cup);
                break;
            case TWOS:
                scores.put(ROW.TWOS, calculateScore(ROW.TWOS, cup);
                break;
            case THREES:
                scores.put(ROW.THREES, calculateScore(ROW.THREES, cup);
                break;
            case FOURS:
                scores.put(ROW.FOURS, calculateScore(ROW.FOURS, cup);
                break;
            case FIVES:
                scores.put(ROW.FIVES, calculateScore(ROW.FIVES, cup);
                break;
            case SIXES:
                scores.put(ROW.SIXES, calculateScore(ROW.SIXES, cup);
                break;
            case THREEOFAKIND:
                scores.put(ROW.THREEOFAKIND, calculateScore(ROW.THREEOFAKIND, cup);
                break;
            case FOUROFAKIND:
                scores.put(ROW.FOUROFAKIND, calculateScore(ROW.FOUROFAKIND, cup);
                break;
            case FULLHOUSE:
                scores.put(ROW.FULLHOUSE, calculateScore(ROW.FULLHOUSE, cup);
                break;
            case SMALLSTRAIGHT:
                scores.put(ROW.SMALLSTRAIGHT, calculateScore(ROW.SMALLSTRAIGHT, cup);
                break;
            case LARGESTRAIGHT:
                scores.put(ROW.LARGESTRAIGHT, calculateScore(ROW.LARGESTRAIGHT, cup);
                break;
            case YAHTZEE:
                scores.put(ROW.YAHTZEE, calculateScore(ROW.YAHTZEE, cup);
                break;
            case CHANCE:
                scores.put(ROW.CHANCE, calculateScore(ROW.CHANCE, cup);
                break;
        }

    }

    public void calculateScore(ROW row, Dice[] cup){

    }
}
