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



    public PokerHand(String input){
        String[] cards = input.split(" ");

        for (String arr : cards) {
            if (Arrays.asList(cards).indexOf(arr) < 5) {
                blackvalues.append(arr.charAt(0));
                blacksuits.append(arr.charAt(1));
            } else {
                whitevalues.append(arr.charAt(0));
                whitesuits.append(arr.charAt(1));
            }
        }

    }



    PokerHandService pokerHandService=new PokerHandService();
    public String getWinner() {

        int rankOfPlayer1 = getRankOfPlayer(blackvalues, blacksuits);
        int rankOfPlayer2 = getRankOfPlayer(whitevalues, whitesuits);
        //System.out.println(rankOfPlayer1+" "+rankOfPlayer2);
        if(rankOfPlayer1>rankOfPlayer2){
            return "Black wins. - with "+pokerHandService.message;
        } else if (rankOfPlayer1<rankOfPlayer2) {
            return "White wins. - with "+pokerHandService.message;
        }else{
            return pokerHandService.compareHighCard(blackvalues,whitevalues);
        }

    }

    public int getRankOfPlayer(StringBuilder values,StringBuilder suits){
        int rank=0;
        if (pokerHandService.isFullHouse(values)) {
            rank=7;
            return rank;
        } else {
            rank=1;
            return rank;
        }
    }

}
