package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;

public class ScoreSheetTest {

    @Test
    public void testCheckThreeOfAKindFalse() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);

        //Then
        Assert.assertFalse(scoreSheet.checkOfaKind(test, 3));

    }

    @Test
    public void testCheckThreeOfAKindTrue() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);

        //Then
        Assert.assertTrue(scoreSheet.checkOfaKind(test, 3));

    }

    @Test
    public void testCheckFourOfAKindFalse() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);

        //Then
        Assert.assertFalse(scoreSheet.checkOfaKind(test, 4));

    }

    @Test
    public void testCheckFourOfAKindTrue() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(2);

        //Then
        Assert.assertTrue(scoreSheet.checkOfaKind(test, 4));

    }

    @Test
    public void testCheckYahtzeeFalse() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);

        //Then
        Assert.assertFalse(scoreSheet.checkOfaKind(test, 5));

    }

    @Test
    public void testCheckYahtzeeTrue() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);

        //Then
        Assert.assertTrue(scoreSheet.checkOfaKind(test, 5));

    }

    @Test
    public void testCheckFullHouseFalse() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);

        //Then
        Assert.assertFalse(scoreSheet.checkFullHouse(test));

    }

    @Test
    public void testCheckFullHouseTrue() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);

        //Then
        Assert.assertTrue(scoreSheet.checkFullHouse(test));

    }

    @Test
    public void testCheckLargeStraightFalse() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);
        Collections.sort(test);

        //Then
        Assert.assertFalse(scoreSheet.checkLargeStraight(test));

    }

    @Test
    public void testCheckLargeStraightTrue() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(1);
        test.add(5);
        test.add(4);
        Collections.sort(test);

        //Then
        Assert.assertTrue(scoreSheet.checkLargeStraight(test));

    }

    @Test
    public void testCheckSmallStraightFalse() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);
        Collections.sort(test);

        //Then
        Assert.assertFalse(scoreSheet.checkSmallStraight(test));

    }

    @Test
    public void testCheckSmallStraightTrue1() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(5);
        test.add(3);
        test.add(5);
        test.add(2);
        test.add(4);
        Collections.sort(test);

        //Then
        Assert.assertTrue(scoreSheet.checkSmallStraight(test));

    }

    @Test
    public void testCheckSmallStraightTrue2() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(3);
        test.add(6);
        test.add(2);
        test.add(4);
        Collections.sort(test);

        //Then
        Assert.assertTrue(scoreSheet.checkSmallStraight(test));

    }

    @Test
    public void testCheckSmallStraightTrue3() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(3);
        test.add(5);
        test.add(6);
        test.add(4);
        Collections.sort(test);

        //Then
        Assert.assertTrue(scoreSheet.checkSmallStraight(test));

    }

    @Test
    public void testScoreNumbers() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);
        int expected = 6;

        //When
        int actual = scoreSheet.scoreNumbers(test, 2);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testScoreTotalDice() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(2);
        test.add(2);
        test.add(3);
        int expected = 12;

        //When
        int actual = scoreSheet.scoreTotalDice(test);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSetRowCHANCE() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }
        int expected = dice1.getValue() + dice2.getValue() + dice3.getValue() + dice4.getValue() + dice5.getValue();

        //When

        scoreSheet.setRow(ScoreSheet.ROW.CHANCE, cup);
        int actual = scoreSheet.getScore(ScoreSheet.ROW.CHANCE);

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSetRowACES() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.ACES, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.ACES) != null));

    }

    @Test
    public void testSetRowTWOS() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.TWOS, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.TWOS) != null));

    }

    @Test
    public void testSetRowTHREES() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.THREES, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.THREES) != null));

    }

    @Test
    public void testSetRowFOURS() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.FOURS, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.FOURS) != null));

    }

    @Test
    public void testSetRowFIVES() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.FIVES, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.FIVES) != null));

    }

    @Test
    public void testSetRowSIXES() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.SIXES, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.SIXES) != null));

    }

    @Test
    public void testSetRowThreeOfAKind() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.THREEOFAKIND, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.THREEOFAKIND) != null));

    }

    @Test
    public void testSetRowFourOfAKind() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.FOUROFAKIND, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.FOUROFAKIND) != null));

    }

    @Test
    public void testSetRowFullHouse() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.FULLHOUSE, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.FULLHOUSE) != null));

    }

    @Test
    public void testSetRowSmallStraight() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.SMALLSTRAIGHT, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.SMALLSTRAIGHT) != null));

    }

    @Test
    public void testSetRowLargeStraight() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.LARGESTRAIGHT, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.LARGESTRAIGHT) != null));

    }

    @Test
    public void testSetRowYahtzee() {
        //Given
        ScoreSheet scoreSheet = new ScoreSheet();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        Dice dice3 = new Dice();
        Dice dice4 = new Dice();
        Dice dice5 = new Dice();
        Dice[] cup = new Dice[5];
        cup[0] = dice1;
        cup[1] = dice2;
        cup[2] = dice3;
        cup[3] = dice4;
        cup[4] = dice5;
        for (Dice d : cup) {
            d.roll();
        }

        //When
        scoreSheet.setRow(ScoreSheet.ROW.YAHTZEE, cup);


        //Then
        Assert.assertTrue((scoreSheet.getScore(ScoreSheet.ROW.YAHTZEE) != null));

    }

    @Test
    public void testGetSize() {
        //Given
        int expected = 13;

        //When
        int actual = ScoreSheet.getSize();

        //Then
        Assert.assertEquals(expected, actual);

    }

}
