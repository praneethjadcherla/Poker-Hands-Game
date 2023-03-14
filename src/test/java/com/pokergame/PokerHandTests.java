package com.pokergame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTests {
    @Test
    public void checkHighCardAceAsWinner(){
        PokerHand hand=new PokerHand("2H 3D 5S 9C KD 2C 3H 4S 8C AH");

        String expected="White wins. - with high card: A";

        assertEquals(expected,hand.getWinner());
    }

    @Test
    public void checkFullHouseAsWinner(){
        PokerHand hand=new PokerHand("4S 4C 2D 4H 2H 2S 8S AS QS 3S");

        String expected="Black wins. - with full house: 4 over 2";

        assertEquals(expected,hand.getWinner());
    }

    @Test
    public void checkHighCard9AsWinner(){
        PokerHand hand=new PokerHand("2H 3D 5S 9C KD 2C 3H 4S 8C KH");

        String expected="Black wins. - with high card: 9";

        assertEquals(expected,hand.getWinner());
    }

}
