package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void computeBestHandPairs() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.FIVE));

        Hand bestHand = Card.computeBestHand(cards);

        assertEquals(HandType.PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandHighestRank() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.JACK), new Card(Suit.SPADE, Rank.TEN), new Card(Suit.CLUB, Rank.FIVE));

        Hand bestHand = Card.computeBestHand(cards);

        assertEquals(HandType.HIGH_CARD, bestHand.getType());
        assertEquals(Rank.JACK, bestHand.getHighestRank());
    }

    @Test
    void fromString() {
        Card c1 = Card.fromString("2Tr");
        assertEquals(Rank.TWO, c1.getRank());
        assertEquals(Suit.CLUB, c1.getSuit());

        Card c2 = Card.fromString("APi");
        assertEquals(Rank.ACE, c2.getRank());
        assertEquals(Suit.SPADE, c2.getSuit());

        Card c3 = Card.fromString("10Co");
        assertEquals(Rank.TEN, c3.getRank());
        assertEquals(Suit.HEART, c3.getSuit());
    }
}