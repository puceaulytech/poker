package com.github.the10xdevs.poker.models;

import java.util.List;
import java.util.Objects;

public class Hand implements Comparable<Hand> {
    private final List<Rank> highestRanks;
    private final Suit suit;
    private final HandType type;


    public Hand(HandType type, List<Rank> highestRanks) {
        this(type, highestRanks, null);
    }

    public Hand(HandType type, List<Rank> highestRanks, Suit suit) {
        this.type = type;
        this.highestRanks = highestRanks;
        this.suit = suit;
    }

    public List<Rank> getHighestRanks() {
        return highestRanks;
    }

    public HandType getType() {
        return this.type;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(highestRanks, suit, type);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Hand otherHand) {
            return this.suit == otherHand.suit && this.type == otherHand.type && this.highestRanks.equals(otherHand.highestRanks);
        }

        return false;
    }

    @Override
    public int compareTo(Hand other) {
        int scoreComparison = Integer.compare(this.type.getScore(), other.type.getScore());

        if (scoreComparison != 0) {
            return scoreComparison;
        } else {
            // Compare the highest ranks of the two hands one by one
            for (int i = 0; i < this.highestRanks.size(); i++) {
                Rank thisRank = this.highestRanks.get(i);
                Rank otherRank = other.highestRanks.get(i);

                int rankComparison = RankComparator.STRONG_ACE.compare(thisRank, otherRank);

                // There is a winning rank
                if (rankComparison != 0)
                    return rankComparison;
            }

            // All five ranks were equal
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.type + " " + switch (this.type) {
            case STRAIGHT_FLUSH -> String.format("au %s à %s", this.highestRanks.get(0), this.suit);
            case FULL_HOUSE -> String.format("aux %s par les %s", this.highestRanks.get(0), this.highestRanks.get(1));
            case FLUSH -> String.format("au %s de %s", this.highestRanks.get(0), this.suit);
            case STRAIGHT -> String.format("au %s", this.highestRanks.get(0));
            case DOUBLE_PAIR -> String.format("de %s par les %s", this.highestRanks.get(0), this.highestRanks.get(1));
            case HIGH_CARD -> String.format("par le %s", this.highestRanks.get(0));
            default -> String.format("de %s", this.highestRanks.get(0));
        };
    }
}
