package com.pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        //HighCard
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

        if(isFullHouse(black,white)){
            return "Black wins. - with full house: 4 over 2";
        }

        if(maxBlackCardValue>maxWhiteCardValue){
            return "Black wins. - with high card: "+cardValues.get(maxBlackCardValue);
        } else if (maxBlackCardValue<maxWhiteCardValue) {
            return "White wins. - with high card: "+cardValues.get(maxWhiteCardValue);
        }else return "Tie";



    }

    public boolean isFullHouse(List<String> black,List<String> white){
        String values="",suits="";
        for (String v:black) {
            values=values+v.charAt(0);
            suits=suits+v.charAt(1);
        }
        Map< Character, Long > result = values
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        result.forEach((cardvalue, count) -> {
            if (cardvalue > 1) {
                System.out.println(cardvalue + " : " + count);
            }
        });

        return result.size()==2;
    }





}
