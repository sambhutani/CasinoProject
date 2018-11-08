//Lauren

package io.zipcoder.casino;

import com.sun.tools.javac.code.Attribute;

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

        int totalScore = 0;
        totalScore = (totalScore + getScore(ScoreSheet.ROW.ACES) + getScore(ScoreSheet.ROW.TWOS) + getScore(ScoreSheet.ROW.THREES) + getScore(ScoreSheet.ROW.FOURS) + getScore(ScoreSheet.ROW.FIVES) + getScore(ScoreSheet.ROW.SIXES));
        if (totalScore >= 63) {
            totalScore += 35;
        }
        totalScore = (totalScore + getScore(ScoreSheet.ROW.THREEOFAKIND) + getScore(ScoreSheet.ROW.FOUROFAKIND) + getScore(ScoreSheet.ROW.FULLHOUSE) + getScore(ScoreSheet.ROW.SMALLSTRAIGHT) + getScore(ScoreSheet.ROW.LARGESTRAIGHT) + getScore(ScoreSheet.ROW.YAHTZEE) + getScore(ScoreSheet.ROW.CHANCE));

        return totalScore;
    }

    public void printRow(Enum row, String description) {
        System.out.print(String.format("%-35s",description));
        if(getScore(row) != null) {
            System.out.println("** " + getScore(row) + " **");
        } else {
            System.out.println("** open **");
        }
    }

    public void printScoreCard(){
        System.out.print(String.format("%-35s","1. Aces: Totals all Ones"));
        if(getScore(ScoreSheet.ROW.ACES) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.ACES) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s","2. Twos: Totals all Twos"));
        if(getScore(ScoreSheet.ROW.TWOS) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.TWOS) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s", "3. Threes: Totals all Threes"));
        if(getScore(ScoreSheet.ROW.THREES) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.THREES) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s", "4. Fours: Totals all Fours"));
        if(getScore(ScoreSheet.ROW.FOURS) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.FOURS) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s", "5. Fives: Totals all Fives"));
        if(getScore(ScoreSheet.ROW.FIVES) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.FIVES) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s", "6. Sixes: Totals all Sixes"));
        if(getScore(ScoreSheet.ROW.SIXES) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.SIXES) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s", "7. 3 of a Kind"));
        if(getScore(ScoreSheet.ROW.THREEOFAKIND) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.THREEOFAKIND) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s", "8. 4 of a Kind"));
        if(getScore(ScoreSheet.ROW.FOUROFAKIND) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.FOUROFAKIND) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s", "9. Full House"));
        if(getScore(ScoreSheet.ROW.FULLHOUSE) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.FULLHOUSE) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s","10. Small Straight: Sequence of 4"));
        if(getScore(ScoreSheet.ROW.SMALLSTRAIGHT) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.SMALLSTRAIGHT) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s","11. Large Striaght: Sequence of 5"));
        if(getScore(ScoreSheet.ROW.LARGESTRAIGHT) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.LARGESTRAIGHT) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s","12. Yahtzee: 5 of a Kind "));
        if(getScore(ScoreSheet.ROW.YAHTZEE) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.YAHTZEE) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.print(String.format("%-35s", "13. Chance: Sum of Dice"));
        if(getScore(ScoreSheet.ROW.CHANCE) != null) {
            System.out.println("** " + getScore(ScoreSheet.ROW.CHANCE) + " **");
        } else {
            System.out.println("** open **");
        }
        System.out.println();
    }

    public void setRow(ROW row, Dice[] cup){

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
            if (i >= numb) return true;
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
        return scores.get(row);
    }
}
