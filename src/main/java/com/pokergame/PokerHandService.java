package com.pokergame;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHandService {
    List<String> cardValues = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    StringBuilder message = new StringBuilder();

    public Map<Character, Long> sortCardsByMap(StringBuilder values) {
        Map<Character, Long> result = values
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public boolean isStraightFlush(StringBuilder values, StringBuilder suits) {
        ArrayList<Integer> sortedvalues = new ArrayList<>();
        for (int v = 0; v < values.length(); v++) {
            sortedvalues.add(cardValues.indexOf(values.substring(v, v + 1)));
        }
        Collections.sort(sortedvalues);
        for (int cardrank = 1; cardrank < sortedvalues.size(); cardrank++) {
            if (sortedvalues.get(cardrank) == sortedvalues.get(cardrank - 1) && suits.charAt(cardrank) == suits.charAt(cardrank - 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isFourOfAKind(StringBuilder values) {
        Map<Character, Long> sortedResult = sortCardsByMap(values);

        for (Map.Entry<Character, Long> item : sortedResult.entrySet()) {
            if (sortedResult.size() == 2) {
                if (item.getValue() == 4) {
                    message.append("four of a kind: ").append(item.getKey());
                    return true;
                }
            } else
                break;
        }
        return false;
    }

    public boolean isFullHouse(StringBuilder values) {
        Map<Character, Long> sortedResult = sortCardsByMap(values);

        for (Map.Entry<Character, Long> item : sortedResult.entrySet()) {
            if (sortedResult.size() == 2) {
                if (item.getValue() == 3) {
                    message.append("full house: ").append(item.getKey()).append(" over ");
                }
                if (item.getValue() == 2) {
                    message.append(item.getKey());
                    return true;
                }
            } else
                break;
        }
        return false;
    }

    public boolean isThreeOfAKind(StringBuilder values) {
        Map<Character, Long> sortedResult = sortCardsByMap(values);

        for (Map.Entry<Character, Long> item : sortedResult.entrySet()) {
            if (sortedResult.size() == 3) {
                if (item.getValue() == 3) {
                    message.append("three of a kind: " + item.getKey());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTwoPairs(StringBuilder values) {
        Map<Character, Long> sortedResult = sortCardsByMap(values);
        int i = 1;
        for (Map.Entry<Character, Long> item : sortedResult.entrySet()) {

            if (sortedResult.size() == 3) {

                if (item.getValue() == 2 && i == 1) {
                    message.append("two pairs: ").append(item.getKey());
                    i++;
                } else if (item.getValue() == 2 && i == 2) {
                    message.append(" and ").append(item.getKey());
                    return true;
                }
            } else
                break;
        }
        return false;
    }

    public boolean isPair(StringBuilder values) {
        Map<Character, Long> sortedResult = sortCardsByMap(values);
        for (Map.Entry<Character, Long> item : sortedResult.entrySet()) {
            if (sortedResult.size() == 4) {
                if (item.getValue() == 2) {
                    message.append("pair: ").append(item.getKey());
                    return true;
                }
            } else
                break;
        }
        return false;
    }

    public String compareHighCard(StringBuilder blackvalues, StringBuilder whitevalues) {
        if (!blackvalues.isEmpty()) {
            if (getHighCard(blackvalues) > getHighCard(whitevalues)) {
                return "Black wins. - with high card: " + cardValues.get(getHighCard(blackvalues));
            } else if (getHighCard(blackvalues) < getHighCard(whitevalues)) {
                return "White wins. - with high card: " + cardValues.get(getHighCard(whitevalues));
            } else {
                blackvalues.deleteCharAt(blackvalues.indexOf(cardValues.get(getHighCard(blackvalues))));
                whitevalues.deleteCharAt(whitevalues.indexOf(cardValues.get(getHighCard(whitevalues))));
                return compareHighCard(blackvalues, whitevalues);
            }
        } else
            return "Tie.";
    }

    public int getHighCard(StringBuilder values) {
        int maxCardValue = -1;
        for (int i = 0; i < values.length(); i++) {
            if (cardValues.indexOf(values.substring(i, i + 1)) > maxCardValue) {
                maxCardValue = cardValues.indexOf(values.substring(i, i + 1));
            }
        }
        return maxCardValue;
    }
}
