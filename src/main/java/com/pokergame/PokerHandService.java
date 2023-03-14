package com.pokergame;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHandService {
    List<String> cardValues= Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    StringBuilder message=new StringBuilder();

    /*public PokerHandService(){

    }

    public StringBuilder getMessage(){
        return message;
    }

    public void setMessage(StringBuilder message){
        this.message=message;
    }*/
    public Map<Character,Long> sortCardsByMap(StringBuilder values){
        Map< Character, Long > result = values
                .chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
    public boolean isFullHouse(StringBuilder values){
        //message.append("full house: ");
        Map<Character,Long> sortedResult=sortCardsByMap(values);

        for(Map.Entry<Character, Long> item : sortedResult.entrySet()) {
            //System.out.println(item.getKey() + ":" + item.getValue());
            if (sortedResult.size() == 2) {
                if (item.getValue() == 3) {
                    message.append("full house: "+item.getKey() + " over ");
                }
                if (item.getValue() == 2) {
                    message.append(item.getKey());
                    return true;
                }
            }
            else
                break;
        }
        return false;
    }

    public boolean isThreeOfAKind(StringBuilder values){
        Map<Character,Long> sortedResult=sortCardsByMap(values);

        for(Map.Entry<Character, Long> item : sortedResult.entrySet()) {
            //System.out.println(item.getKey() + ":" + item.getValue());
            if (sortedResult.size() == 3) {
                if (item.getValue() == 3) {
                    message.append("three of a kind: "+item.getKey());
                    return true;
                }
    }
        }
        return false;
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

    public int getHighCard(StringBuilder values){
        int maxCardValue=-1;
        for(int i=0;i<values.length();i++){
            if(cardValues.indexOf(values.substring(i,i+1)) > maxCardValue){
                maxCardValue=cardValues.indexOf(values.substring(i,i+1));
            }
        }
        return maxCardValue;
    }
}
