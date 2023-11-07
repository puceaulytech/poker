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

    public static Player readFromTerminal(BufferedReader reader) throws IOException {
        System.out.print("Cartes? ");

        String line = reader.readLine();
        if (line == null) System.exit(0);

        return Player.fromString(line);
    }

    /**
     * Compute the best hand possible out of multiples cards
     *
     * @return The best hand
     */
    public Hand computeBestHand() {
        List<Rank> ranks = cards.stream().map(Card::getRank).toList();
        Map<Integer, Set<Rank>> rankOccurrences = Algorithms.getOccurrences(ranks);

        // Four of a kind
        Set<Rank> fours = rankOccurrences.get(4);
        if (fours != null) {
            Rank bestFour = Collections.max(fours, RankComparator.STRONG_ACE);
            return new Hand(HandType.FOUR_OF_A_KIND, bestFour);
        }

        Set<Rank> threes = rankOccurrences.get(3);
        Set<Rank> pairs = rankOccurrences.get(2);

        // Full house
        if (threes != null && pairs != null) {
            Rank bestThree = Collections.max(threes, RankComparator.STRONG_ACE);
            return new Hand(HandType.FULL_HOUSE, bestThree);
        }

        // Three of a kind
        if (threes != null) {
            Rank bestThree = Collections.max(threes, RankComparator.STRONG_ACE);
            return new Hand(HandType.THREE_OF_A_KIND, bestThree);
        }

        // Pairs and double pairs
        if (pairs != null) {
            Rank bestPair = Collections.max(pairs, RankComparator.STRONG_ACE);
            return new Hand(pairs.size() >= 2 ? HandType.DOUBLE_PAIR : HandType.PAIR, bestPair);
        }

        // Straight
        Rank highStraight = highestInStraight();
        if (highStraight != null) {
            return new Hand(HandType.STRAIGHT, highStraight);
        }

        // Highest card
        Rank highestRank = Collections.max(ranks, RankComparator.STRONG_ACE);
        return new Hand(HandType.HIGH_CARD, highestRank);
    }

    /**
     * Creates a mutable copy of the list of cards.
     * Then sorts this list according to cards' rank.
     * If the first card is a two and the last one is an ace removes the ace of the list,
     * this is done so that the jump from 5 to Ace doesn't fail the algo.
     * Then iterates over every card checking if its rank number is higher by one than the previous.
     * Because the list is sorted by rank, the last card in it is the highest
     *
     * @return The highest rank in straight or null if the hand is not a straight
     */
    private Rank highestInStraight() {
        List<Card> modifiableCards = new ArrayList<>(cards);
        modifiableCards.sort(Comparator.comparing(Card::getRank, RankComparator.STRONG_ACE));

        Rank previousCardRank = modifiableCards.get(0).getRank();

        int lastIndex = modifiableCards.size() - 1;
        if (previousCardRank == Rank.TWO && modifiableCards.get(lastIndex).getRank() == Rank.ACE) {
            modifiableCards.remove(lastIndex);
        }

        lastIndex = modifiableCards.size() - 1;
        for (int i = 1; i <= lastIndex; i++) {
            Rank currentCardRank = modifiableCards.get(i).getRank();
            if (currentCardRank.getNumberRank() != previousCardRank.getNumberRank() + 1) {
                return null;
            }
            previousCardRank = currentCardRank;
        }
        return modifiableCards.get(lastIndex).getRank();
    }

    @Override
    public int compareTo(Player other) {
        Hand thisHand = this.computeBestHand();
        Hand otherHand = other.computeBestHand();

        return thisHand.compareTo(otherHand);
    }
}
