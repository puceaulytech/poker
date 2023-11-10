package com.github.the10xdevs.poker.models;

import com.github.the10xdevs.poker.exceptions.EmptyInputException;
import com.github.the10xdevs.poker.exceptions.ParsingException;
import com.github.the10xdevs.poker.utils.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Player {
    private final List<Card> cards;

    public Player(List<Card> cards) {
        this.cards = cards;
    }

    public static Player fromString(String repr) throws ParsingException {
        List<Card> list = new ArrayList<>();
        for (String s : repr.split("\\s+")) {
            Card card = Card.fromString(s);
            list.add(card);
        }
        return new Player(list);
    }

    public static Player readFromTerminal(BufferedReader reader) {
        while (true) {
            System.out.print("Cartes? ");

            try {
                String line = reader.readLine();
                if (line == null) System.exit(0);
                if (line.isBlank()) throw new EmptyInputException();

                return Player.fromString(line.trim());
            } catch (IOException | ParsingException | EmptyInputException error) {
                System.out.println(error.getLocalizedMessage() + ", recommencez svp");
            }
        }
    }

    /**
     * Compute the best hand possible out of multiples cards
     *
     * @return The best hand
     */
    public Hand computeBestHand() {
        List<Rank> ranks = cards.stream().map(Card::getRank).toList();
        Map<Integer, Set<Rank>> rankOccurrences = Algorithms.getOccurrences(ranks);

        Suit flushSuit = flushSuit();
        Rank highStraight = highestInStraight();

        // Straight flush
        if (highStraight != null && flushSuit != null) {
            return new Hand(HandType.STRAIGHT_FLUSH, List.of(highStraight), flushSuit);
        }

        // Straight
        if (highStraight != null) {
            return new Hand(HandType.STRAIGHT, List.of(highStraight));
        }

        // Flush
        if (flushSuit != null) {
            List<Rank> sortedRanks = new ArrayList<>(ranks);
            sortedRanks.sort(RankComparator.STRONG_ACE.reversed());
            return new Hand(HandType.FLUSH, sortedRanks, flushSuit);
        }

        // Four of a kind
        Set<Rank> fours = rankOccurrences.get(4);
        if (fours != null) {
            Rank bestFour = Collections.max(fours, RankComparator.STRONG_ACE);
            return new Hand(HandType.FOUR_OF_A_KIND, List.of(bestFour));
        }

        Set<Rank> threes = rankOccurrences.get(3);
        Set<Rank> pairs = rankOccurrences.get(2);

        // Full house
        if (threes != null && pairs != null) {
            Rank bestThree = Collections.max(threes, RankComparator.STRONG_ACE);
            Rank bestPair = Collections.max(pairs, RankComparator.STRONG_ACE);
            return new Hand(HandType.FULL_HOUSE, List.of(bestThree, bestPair));
        }

        // Three of a kind
        if (threes != null) {
            Rank bestThree = Collections.max(threes, RankComparator.STRONG_ACE);
            return new Hand(HandType.THREE_OF_A_KIND, List.of(bestThree));
        }

        // Pairs and double pairs
        if (pairs != null) {
            Rank bestPair = Collections.max(pairs, RankComparator.STRONG_ACE);
            if (pairs.size() >= 2) {
                Rank bestSubPair = Collections.max(pairs.stream().filter(r -> r != bestPair).toList(), RankComparator.STRONG_ACE);
                return new Hand(HandType.DOUBLE_PAIR, Algorithms.listWithTwoFirst(bestPair, bestSubPair, this.discriminatorRanks(rankOccurrences)));
            }
            return new Hand(HandType.PAIR, Algorithms.listWithFirst(bestPair, this.discriminatorRanks(rankOccurrences)));
        }

        // Highest card
        return new Hand(HandType.HIGH_CARD, ranks);
    }

    private Suit flushSuit() {
        if (this.cards.size() != 5) return null;
        Suit firstCardSuit = cards.get(0).getSuit();

        for (Card card : cards) {
            if (card.getSuit() != firstCardSuit) {
                return null;
            }
        }
        return firstCardSuit;
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
        if (this.cards.size() != 5) return null;

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

    private List<Rank> discriminatorRanks(Map<Integer, Set<Rank>> occurrences) {
        List<Rank> result = new ArrayList<>(occurrences.get(1));
        result.sort(RankComparator.STRONG_ACE);
        return result;
    }

    public List<Card> getCards() {
        return cards;
    }
}