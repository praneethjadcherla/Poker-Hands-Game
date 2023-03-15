package com.pokergame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTests {
    @Test
    public void checkHighCardAceAsWinner() {
        PokerHand hand = new PokerHand("2H 3D 5S 9C KD 2C 3H 4S 8C AH");

        String expected = "White wins. - with high card: A";

        assertEquals(expected, hand.getWinner());
    }

    @Test
    public void checkFullHouseAsWinner() {
        PokerHand hand = new PokerHand("4S 4C 2D 4H 2H 2S 8S AS QS 3S");

        String expected = "Black wins. - with full house: 4 over 2";

        assertEquals(expected, hand.getWinner());
    }

    @Test
    public void checkHighCard9AsWinner() {
        PokerHand hand = new PokerHand("2H 3D 5S 9C KD 2C 3H 4S 8C KH");

        String expected = "Black wins. - with high card: 9";

        assertEquals(expected, hand.getWinner());
    }

    @Test
    public void testThreeOfAKindHandAsWinner() {
        PokerHand hand = new PokerHand("2H 3D 3S 5C KD 2C 3H 3S 8C 3H");

        String expected = "White wins. - with three of a kind: 3";

        assertEquals(expected, hand.getWinner());
    }

    @Test
    public void testTwoPairsHandAsWinner() {
        PokerHand hand = new PokerHand("2H 3D 2S 3C KD 2C 3H 3S 5C AH");

        String expected = "Black wins. - with two pairs: 2 and 3";

        assertEquals(expected, hand.getWinner());
    }

    @Test
    public void testGameIsTie() {
        PokerHand hand = new PokerHand("2H 3D 5S 9C KD 2D 3H 5C 9S KH");

        String expected = "Tie.";

        assertEquals(expected, hand.getWinner());
    }

    @Test
    public void testFourOfAKindVsTwopairs() {
        PokerHand hand = new PokerHand("AH 3D AS 2C 3D JC JH JS AC JH");

        String expected = "White wins. - with four of a kind: J";

        assertEquals(expected, hand.getWinner());
    }

    @Test
    public void testPairVsHighCard() {
        PokerHand hand = new PokerHand("AH 3D 4S AC 5D JC 3H KS AC 2H");

        String expected = "Black wins. - with pair: A";

        assertEquals(expected, hand.getWinner());
    }

    @Test
    public void testPairVsPairHighCard() {
        PokerHand hand = new PokerHand("KH 3D 4S KC 5D JC 3H KS AC AH");

        String expected = "White wins. - with high card: A";

        assertEquals(expected, hand.getWinner());
    }


}
