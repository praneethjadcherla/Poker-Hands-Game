package com.pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHand {

    StringBuilder blackvalues = new StringBuilder();
    StringBuilder blacksuits = new StringBuilder();
    StringBuilder whitevalues = new StringBuilder();
    StringBuilder whitesuits = new StringBuilder();


    public PokerHand(String input) {
        String[] cards = input.split(" ");

        for (int index = 0; index < cards.length; index++) {

            if (index < 5) {
                blackvalues.append(cards[index].charAt(0));
                blacksuits.append(cards[index].charAt(1));
            } else {
                whitevalues.append(cards[index].charAt(0));
                whitesuits.append(cards[index].charAt(1));
            }
        }

    }
    PokerHandService pokerHandService = new PokerHandService();

    public String getWinner() {
        System.out.println(blackvalues + " " + whitevalues);
        int rankOfPlayer1 = getRankOfPlayer(blackvalues, blacksuits);
        String message1 = pokerHandService.message.toString();
        pokerHandService.message = new StringBuilder();
        int rankOfPlayer2 = getRankOfPlayer(whitevalues, whitesuits);
        String message2 = pokerHandService.message.toString();
        if (rankOfPlayer1 > rankOfPlayer2) {
            return "Black wins. - with " + message1;
        } else if (rankOfPlayer1 < rankOfPlayer2) {
            return "White wins. - with " + message2;
        } else {
            return pokerHandService.compareHighCard(blackvalues, whitevalues);
        }

    }

    public int getRankOfPlayer(StringBuilder values, StringBuilder suits) {
        int rank = 0;
        if (pokerHandService.isStraightFlush(values, suits)) {
            rank = 8;
            return rank;
        } else if (pokerHandService.isFourOfAKind(values)) {
            rank = 8;
            return rank;
        } else if (pokerHandService.isFullHouse(values)) {
            rank = 7;
            return rank;
        } else if (pokerHandService.isThreeOfAKind(values)) {
            rank = 4;
            return 4;
        } else if (pokerHandService.isTwoPairs(values)) {
            rank = 3;
            return rank;
        } else if (pokerHandService.isPair(values)) {
            rank = 2;
            return rank;
        } else {
            rank = 1;
            return rank;
        }
    }
}
