package com.github.the10xdevs.poker.models;

import com.github.the10xdevs.poker.utils.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Player implements Comparable<Player> {
    private final List<Card> cards;

    public Player(List<Card> cards) {
        this.cards = cards;
    }

    public static Player fromString(String repr) {
        return new Player(Arrays.stream(repr.split("\\s+")).map(Card::fromString).toList());
    }

    public Hand computeBestHand() {
        List<Rank> ranks = cards.stream().map(Card::getRank).toList();
        Map<Integer, Set<Rank>> rankOccurrences = Algorithms.getOccurrences(ranks);

        // Four of a kind
        Set<Rank> fours = rankOccurrences.get(4);
        if (fours != null) {
            Rank bestFour = Collections.max(fours, RankComparator.STRONG_ACE);
            return new Hand(HandType.FOUR_OF_A_KIND, bestFour);
        }

        // Three of a kind
        Set<Rank> threes = rankOccurrences.get(3);
        if (threes != null) {
            Rank bestThree = Collections.max(threes, RankComparator.STRONG_ACE);
            return new Hand(HandType.THREE_OF_A_KIND, bestThree);
        }

        // Pairs and double pairs
        Set<Rank> pairs = rankOccurrences.get(2);
        if (pairs != null) {
            Rank bestPair = Collections.max(pairs, RankComparator.STRONG_ACE);
            return new Hand(pairs.size() >= 2 ? HandType.DOUBLE_PAIR : HandType.PAIR, bestPair);
        }

        // Highest card
        Rank highestRank = Collections.max(ranks, RankComparator.STRONG_ACE);
        return new Hand(HandType.HIGH_CARD, highestRank);
    }

    public static Player readFromTerminal(BufferedReader reader) throws IOException {
        System.out.print("Cartes? ");

        String line = reader.readLine();
        if (line == null) System.exit(0);

        return Player.fromString(line);
    }

    @Override
    public int compareTo(Player other) {
        Hand thisHand = this.computeBestHand();
        Hand otherHand = other.computeBestHand();

        return thisHand.compareTo(otherHand);
    }
}
