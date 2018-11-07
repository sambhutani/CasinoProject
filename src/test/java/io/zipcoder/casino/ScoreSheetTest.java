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

}
