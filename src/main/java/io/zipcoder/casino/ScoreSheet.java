//Lauren

package io.zipcoder.casino;

import java.util.*;

public class ScoreSheet {

    public enum ROW{
        ACES, TWOS, THREES, FOURS, FIVES, SIXES, THREEOFAKIND, FOUROFAKIND, FULLHOUSE, SMALLSTRAIGHT, LARGESTRAIGHT, YAHTZEE, CHANCE;
    }
    private Map<ROW, Integer> scores = new EnumMap<>(ROW.class);
    private static final int size = ROW.values().length;

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

    public void printScoreCard(){
        System.out.println(
                "1. Aces: Totals all Ones ** Score **" + getScore(ScoreSheet.ROW.ACES) + "\n" +
                "2. Twos: Totals all Twos ** Score **" + getScore(ScoreSheet.ROW.TWOS) + "\n" +
                "3. Threes: Totals all Threes ** Score **" + getScore(ScoreSheet.ROW.THREES) + "\n" +
                "4. Fours: Totals all Fours ** Score **" + getScore(ScoreSheet.ROW.FOURS) + "\n" +
                "5. Fives: Totals all Fives ** Score **" + getScore(ScoreSheet.ROW.FIVES) + "\n" +
                "6. Sixes: Totals all Sixes ** Score **" + getScore(ScoreSheet.ROW.SIXES) + "\n" +
                "7. 3 of a Kind ** Score **" + getScore(ScoreSheet.ROW.THREEOFAKIND) + "\n" +
                "8. 4 of a Kind ** Score **" + getScore(ScoreSheet.ROW.FOUROFAKIND) + "\n" +
                "9. Full House ** Score **" + getScore(ScoreSheet.ROW.FULLHOUSE) + "\n" +
                "10. Small Straight: Sequence of 4 ** Score **" + getScore(ScoreSheet.ROW.SMALLSTRAIGHT) + "\n" +
                "11. Large Striaght: Sequence of 5 ** Score **" + getScore(ScoreSheet.ROW.LARGESTRAIGHT) + "\n" +
                "12. Yahtzee: 5 of a Kind ** Score **" + getScore(ScoreSheet.ROW.YAHTZEE) + "\n" +
                "13. Chance: Sum of Dice ** Score **" + getScore(ScoreSheet.ROW.CHANCE) + "\n" +
                "****************** TOTAL SCORE ******************" + getTotalScore());

    }

    public void setRow(ROW row, Dice[] cup){

        if(scores.get(row) != null) {
            System.out.println("Error, you have already filled that row");
        } else {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (Dice d : cup) {
                numbers.add(d.getValue());
            }
            Collections.sort(numbers);

            switch (row) {
                case ACES:
                    scores.put(ROW.ACES, scoreNumbers(numbers, 1));
                    break;
                case TWOS:
                    scores.put(ROW.TWOS, scoreNumbers(numbers, 2));
                    break;
                case THREES:
                    scores.put(ROW.THREES, scoreNumbers(numbers, 3));
                    break;
                case FOURS:
                    scores.put(ROW.FOURS, scoreNumbers(numbers, 4));
                    break;
                case FIVES:
                    scores.put(ROW.FIVES, scoreNumbers(numbers, 5));
                    break;
                case SIXES:
                    scores.put(ROW.SIXES, scoreNumbers(numbers, 6));
                    break;
                case THREEOFAKIND:
                    if (checkOfaKind(numbers, 3)) {
                        scores.put(ROW.THREEOFAKIND, scoreTotalDice(numbers));
                    } else {
                        scores.put(ROW.THREEOFAKIND, 0);
                    }
                    break;
                case FOUROFAKIND:
                    if (checkOfaKind(numbers, 4)) {
                        scores.put(ROW.FOUROFAKIND, scoreTotalDice(numbers));
                    } else {
                        scores.put(ROW.FOUROFAKIND, 0);
                    }
                    break;
                case FULLHOUSE:
                    if (checkOfaKind(numbers, 5) || checkFullHouse(numbers)) {
                        scores.put(ROW.FULLHOUSE, 25);
                    } else {
                        scores.put(ROW.FULLHOUSE, 0);
                    }
                    break;
                case SMALLSTRAIGHT:
                    if (checkSmallStraight(numbers)) {
                        scores.put(ROW.SMALLSTRAIGHT, 30);
                    } else {
                        scores.put(ROW.SMALLSTRAIGHT, 0);
                    }
                    break;
                case LARGESTRAIGHT:
                    if (checkLargeStraight(numbers)) {
                        scores.put(ROW.LARGESTRAIGHT, 40);
                    } else {
                        scores.put(ROW.LARGESTRAIGHT, 0);
                    }
                    break;
                case YAHTZEE:
                    if (checkOfaKind(numbers, 5)) {
                        scores.put(ROW.YAHTZEE, 50);
                    } else {
                        scores.put(ROW.YAHTZEE, 0);
                    }
                    break;
                case CHANCE:
                    scores.put(ROW.CHANCE, scoreTotalDice(numbers));
                    break;
            }
        }

    }

    public boolean checkFullHouse(ArrayList<Integer> numbers) {

        boolean check2 = checkOfaKind(numbers, 2);
        boolean check3 = checkOfaKind(numbers, 3);

        return (check2 && check3);
    }

    public boolean checkSmallStraight(ArrayList<Integer> numbers) {

        for(int i = 0; i < numbers.size() - 1; i++) {
            if(numbers.get(i) == numbers.get(i+1)) {
                numbers.remove(i);
            }
        }

        while(numbers.size() > 4) {
            if (numbers.get(0) + 1 != numbers.get(1)) {
                numbers.remove(0);
            } else {
                numbers.remove(4);
            }
        }
        if(numbers.size() < 4) return false;

        boolean check = false;
        if(numbers.toString().equals("[1, 2, 3, 4]") ||
                numbers.toString().equals("[2, 3, 4, 5]") ||
                numbers.toString().equals("[3, 4, 5, 6]")) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public boolean checkLargeStraight(ArrayList<Integer> numbers) {

        boolean check = false;
        for(int i = 0; i < numbers.size() - 1; i++) {
            if((numbers.get(i) + 1) == numbers.get(i + 1)) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    public boolean checkOfaKind(ArrayList<Integer> numbers, int numb) {

        int[] counts = new int[6];

        for (int i = 0; i < numbers.size(); i++)
            counts[numbers.get(i) - 1]++;

        for (int i: counts) {
            if (i == numb) return true;
        }
        return false;
    }

    public int scoreNumbers(ArrayList<Integer> numbers, int numb){

        int count = 0;
        for(Integer i : numbers) {
            if(i == numb) {
                count++;
            }
        }
        return count * numb;
    }

    public int scoreTotalDice(ArrayList<Integer> numbers) {

        int score = 0;
        for(Integer i : numbers) {
            score += i;
        }
        return score;
    }

    public static int getSize() {
        return size;
    }

    public Integer getScore(ROW row) {
        return this.scores.get(row);
    }
}
