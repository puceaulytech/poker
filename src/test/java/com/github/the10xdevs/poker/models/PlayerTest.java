package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
     void computeBestHandFours() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.KING), new Card(Suit.HEART, Rank.KING));

        Hand bestHand = Player.computeBestHand();

        assertEquals(HandType.FOUR_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }
    @Test
    void computeBestHandThrees() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.KING));

        Hand bestHand = Player.computeBestHand();

        assertEquals(HandType.THREE_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandDoublePairs() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.FIVE), new Card(Suit.DIAMOND, Rank.FIVE));

        Hand bestHand = Player.computeBestHand();

        assertEquals(HandType.DOUBLE_PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandPairs() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.FIVE));

        Hand bestHand = Player.computeBestHand();

        assertEquals(HandType.PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandHighestRank() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.JACK), new Card(Suit.SPADE, Rank.TEN), new Card(Suit.CLUB, Rank.FIVE));

        Hand bestHand = Player.computeBestHand();

        assertEquals(HandType.HIGH_CARD, bestHand.getType());
        assertEquals(Rank.JACK, bestHand.getHighestRank());
    }
}