package com.pokergame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTests {
    @Test
    public void checkHighCardAsWinner(){
        PokerHand hand=new PokerHand();

        String expected="White wins. - with high card: A";

        assertEquals(expected,hand.getWinner("2H 3D 5S 9C KD 2C 3H 4S 8C AH"));
    }
}
