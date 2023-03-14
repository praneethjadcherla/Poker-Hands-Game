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

        for (int index=0;index< cards.length;index++) {

            if (index < 5) {
                //System.out.println(index+" ");
                blackvalues.append(cards[index].charAt(0));
                blacksuits.append(cards[index].charAt(1));
            } else {
                whitevalues.append(cards[index].charAt(0));
                whitesuits.append(cards[index].charAt(1));
            }
        }

    }



    PokerHandService pokerHandService=new PokerHandService();
    public String getWinner() {
        System.out.println(blackvalues+" "+whitevalues);
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
        } else if (pokerHandService.isThreeOfAKind(values)) {
            rank=4;
            return 4;
        } else if (pokerHandService.isTwoPairs(values)) {
            rank=3;
            return rank;
        } else {
            rank=1;
            return rank;
        }
    }

}
