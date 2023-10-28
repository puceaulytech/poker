package com.github.the10xdevs.poker.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player playerOne;


    @Test
     void computeBestHandFours() {
        Player playerOne= Player.fromString("RCa RPi RCo RTr");
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.KING), new Card(Suit.HEART, Rank.KING));
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.FOUR_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }
    @Test
    void computeBestHandThrees() {

        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.KING));
        Player playerOne= Player.fromString("RCa RPi RCo ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.THREE_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandDoublePairs() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.FIVE), new Card(Suit.DIAMOND, Rank.FIVE));
        Player playerOne= Player.fromString("RCa RPi 5Ca 5Tr");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.DOUBLE_PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandPairs() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.KING), new Card(Suit.SPADE, Rank.KING), new Card(Suit.CLUB, Rank.FIVE));
        Player playerOne= Player.fromString("RCa RPi 5Co ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRank());
    }

    @Test
    void computeBestHandHighestRank() {
        List<Card> cards = Arrays.asList(new Card(Suit.DIAMOND, Rank.JACK), new Card(Suit.SPADE, Rank.TEN), new Card(Suit.CLUB, Rank.FIVE));
        Player playerOne= Player.fromString("VCa 10Pi 5Co ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.HIGH_CARD, bestHand.getType());
        assertEquals(Rank.JACK, bestHand.getHighestRank());
    }
}