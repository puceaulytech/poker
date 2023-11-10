package com.github.the10xdevs.poker.models;

import com.github.the10xdevs.poker.exceptions.ParsingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    Player playerOne;

    @Test
    void computeBestHandFlush() throws ParsingException {
        playerOne = Player.fromString("4Co 6Co 8Co VCo ACo");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.FLUSH, bestHand.getType());
        assertEquals(Rank.ACE, bestHand.getHighestRanks().get(0));
    }

    @Test
    void computeBestHandFours() throws ParsingException {
        playerOne = Player.fromString("RCa RPi RCo RTr");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.FOUR_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRanks().get(0));
    }

    @Test
    void computeBestHandFull() throws ParsingException {
        playerOne = Player.fromString("RPi RCa RCo 3Co 3Ca");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.FULL_HOUSE, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRanks().get(0));

        Player playerTwo = Player.fromString("DCo DPi DTr ACo APi");
        // assertEquals(1, playerOne.compareTo(playerTwo));
    }

    @Test
    void computeBestHandThrees() throws ParsingException {

        playerOne = Player.fromString("RCa RPi RCo ");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.THREE_OF_A_KIND, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRanks().get(0));
    }

    @Test
    void computeBestHandDoublePairs() throws ParsingException {
        playerOne = Player.fromString("RCa RPi 5Ca 5Tr 3Tr");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.DOUBLE_PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRanks().get(0));
    }

    @Test
    void computeBestHandPairs() throws ParsingException {
        playerOne = Player.fromString("RCa RPi 5Co 4Co 10Ca");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.PAIR, bestHand.getType());
        assertEquals(Rank.KING, bestHand.getHighestRanks().get(0));
    }

    @Test
    void computeBestHandHighestRank() throws ParsingException {
        playerOne = Player.fromString("VCa 10Pi 5Co 2Co 3Tr");
        Hand bestHand = playerOne.computeBestHand();

        assertEquals(HandType.HIGH_CARD, bestHand.getType());
        assertEquals(Rank.JACK, bestHand.getHighestRanks().get(0));
    }

    @Test
    void computeBestHandStraightTest() throws ParsingException {
        playerOne = Player.fromString("RPi DCa VPi ACo 10Co");
        Hand bestHand = playerOne.computeBestHand();
        assertEquals(HandType.STRAIGHT, bestHand.getType());
        assertEquals(Rank.ACE, bestHand.getHighestRanks().get(0));

        playerOne = Player.fromString("4Ca 7Pi 8Tr 6Tr 5Ca");
        bestHand = playerOne.computeBestHand();
        assertEquals(HandType.STRAIGHT, bestHand.getType());
        assertEquals(Rank.EIGHT, bestHand.getHighestRanks().get(0));

        playerOne = Player.fromString("3Ca APi 2Tr 5Tr 4Ca");
        bestHand = playerOne.computeBestHand();
        assertEquals(HandType.STRAIGHT, bestHand.getType());
        assertEquals(Rank.FIVE, bestHand.getHighestRanks().get(0));

        playerOne = Player.fromString("3Ca APi 2Tr 7Tr 4Ca");
        bestHand = playerOne.computeBestHand();
        assertEquals(HandType.HIGH_CARD, bestHand.getType());
    }

    @Test
    void computeBestHandStraightFlushTest() throws ParsingException {
        playerOne = Player.fromString("RPi DPi VPi APi 10Pi");
        Hand bestHand = playerOne.computeBestHand();
        assertEquals(HandType.STRAIGHT_FLUSH, bestHand.getType());
        assertEquals(Rank.ACE, bestHand.getHighestRanks().get(0));
    }
}