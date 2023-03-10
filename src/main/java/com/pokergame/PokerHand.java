package com.pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerHand {

    List<String> cardValues=Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    public String getWinner(String input) {

        String[] cards = input.split(" ");
        List<String> black = new ArrayList<>();
        List<String> white = new ArrayList<>();


        for (String arr : cards) {
            if (Arrays.asList(cards).indexOf(arr) < 5) {
                black.add(arr);
            } else {
                white.add(arr);
            }
        }

        StringBuilder blackvalues = new StringBuilder();
        StringBuilder blacksuits = new StringBuilder();
        for (String v : black) {
            blackvalues.append(v.charAt(0));
            blacksuits.append(v.charAt(1));
        }

        StringBuilder whitevalues = new StringBuilder();
        StringBuilder whitesuits = new StringBuilder();
        for (String w : white) {
            whitevalues.append(w.charAt(0));
            whitesuits.append(w.charAt(1));
        }


        //Full House
        if (isFullHouse(blackvalues)) {
            return "Black wins. - with full house: 4 over 2";
        } else {
            return compareHighCard(blackvalues,whitevalues);

        }


    }

    public boolean isFullHouse(StringBuilder values){

        Map< Character, Long > result = values
                .chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        result.forEach((cardvalue, count) -> {
            if (cardvalue > 1) {
                System.out.println(cardvalue + " : " + count);
            }
        });

        return result.size()==2;
    }

    public int getHighCard(StringBuilder values){
        int maxCardValue=-1;
        for(int i=0;i<values.length();i++){
            if(cardValues.indexOf(values.substring(i,i+1)) > maxCardValue){
                maxCardValue=cardValues.indexOf(values.substring(i,i+1));
            }
        }
        return maxCardValue;
    }

    public String compareHighCard(StringBuilder blackvalues,StringBuilder whitevalues){
        if (getHighCard(blackvalues) > getHighCard(whitevalues)) {
            return "Black wins. - with high card: " + cardValues.get(getHighCard(blackvalues));
        } else if (getHighCard(blackvalues) < getHighCard(whitevalues)) {
            return "White wins. - with high card: " + cardValues.get(getHighCard(whitevalues));
        } else {
            blackvalues.deleteCharAt(blackvalues.indexOf(cardValues.get(getHighCard(blackvalues))));
            whitevalues.deleteCharAt(whitevalues.indexOf(cardValues.get(getHighCard(whitevalues))));
            return compareHighCard(blackvalues,whitevalues);
        }
    }





}
