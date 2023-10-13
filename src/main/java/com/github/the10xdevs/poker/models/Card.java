package com.github.the10xdevs.poker.models;

import com.github.the10xdevs.poker.utils.Algorithms;

import java.util.*;

/**
 * A playing card
 */
public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Compute the best hand possible out of multiples cards
     * @param cards The cards the player has
     * @return The best hand
     */
    public static Hand computeBestHand(List<Card> cards) {
        List<Rank> ranks = cards.stream().map(Card::getRank).toList();
        Map<Integer, Set<Rank>> rankOccurrences = Algorithms.getOccurrences(ranks);

        // Pairs
        Set<Rank> pairs = rankOccurrences.get(2);

        if (pairs != null) {
            Rank bestPair = Collections.max(pairs, RankComparator.STRONG_ACE);
            return new Hand(HandType.PAIR, bestPair);
        }

        // Highest card
        Rank highestRank = Collections.max(ranks, RankComparator.STRONG_ACE);
        return new Hand(HandType.HIGH_CARD, highestRank);
    }

    public static Card fromString(String repr) {
        if (!Character.isDigit(repr.charAt(0))) {
            Rank rank = Rank.fromString(String.valueOf(repr.charAt(0)));
            Suit suit = Suit.fromString(repr.substring(1));
            return new Card(suit, rank);
        }

        if (Character.isDigit(repr.charAt(1))) {
            Rank rank = Rank.fromString(repr.substring(0, 2));
            Suit suit = Suit.fromString(repr.substring(2));
            return new Card(suit, rank);
        }

        Rank rank = Rank.fromString(String.valueOf(repr.charAt(0)));
        Suit suit = Suit.fromString(repr.substring(1));
        return new Card(suit, rank);
    }

    @Override
    public String toString() {
        return this.rank.toString() + this.suit.toString();
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
}