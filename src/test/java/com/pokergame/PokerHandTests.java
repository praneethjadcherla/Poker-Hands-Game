package com.pokergame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTests {
    @Test
    public void checkHighCardAceAsWinner(){
        PokerHand hand=new PokerHand();

        String expected="White wins. - with high card: A";

        assertEquals(expected,hand.getWinner("2H 3D 5S 9C KD 2C 3H 4S 8C AH"));
    }

    @Test
    public void checkFullHouseAsWinner(){
        PokerHand hand=new PokerHand();

        String expected="Black wins. - with full house: 4 over 2";

        assertEquals(expected,hand.getWinner("2H 4S 4C 2D 4H 2S 8S AS QS 3S"));
    }

    @Test
    public void checkHighCard9AsWinner(){
        PokerHand hand=new PokerHand();

        String expected="Black wins. - with high card: 9";

        assertEquals(expected,hand.getWinner("2H 3D 5S 9C KD 2C 3H 4S 8C KH"));
    }

}
