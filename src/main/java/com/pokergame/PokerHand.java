package com.pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerHand {
    public String getWinner(String input){

        String[] cards=input.split(" ");
        List<String> black=new ArrayList<>();
        List<String> white=new ArrayList<>();
        List<String> cardValues=Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

        for (String arr:cards) {
            if(Arrays.asList(cards).indexOf(arr)<5){
                black.add(arr);
            }else {
                white.add(arr);
            }
        }

        int maxBlackCardValue=-1;
        for(String blackCard:black){
            if(cardValues.indexOf(blackCard.substring(0,1)) > maxBlackCardValue){
                maxBlackCardValue=cardValues.indexOf(blackCard.substring(0,1));
            }
            }

        int maxWhiteCardValue=-1;
        for(String whiteCard:white){
            if(cardValues.indexOf(whiteCard.substring(0,1)) > maxWhiteCardValue){
                maxWhiteCardValue=cardValues.indexOf(whiteCard.substring(0,1));
            }
        }

        if(maxBlackCardValue>maxWhiteCardValue){
            return "Black wins. - with high card: "+cardValues.get(maxBlackCardValue);
        } else if (maxBlackCardValue<maxWhiteCardValue) {
            return "White wins. - with high card: "+cardValues.get(maxWhiteCardValue);
        }else return "Tie";


    }
}
