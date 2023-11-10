package com.github.the10xdevs.poker.models;

public class Hand implements Comparable<Hand> {
    private final Rank highestRank;
    private final Suit suit;
    private final HandType type;

    public Hand(HandType type, Rank highestRank, Suit suit) {
        this.type = type;
        this.highestRank = highestRank;
        this.suit = suit;
    }

    public Hand(HandType type, Rank highestRank) {
        this(type, highestRank, null);
    }

    public Rank getHighestRank() {
        return highestRank;
    }

    public HandType getType() {
        return this.type;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Hand other) {
        int scoreComparison = Integer.compare(this.type.getScore(), other.type.getScore());

        if (scoreComparison != 0) {
            return scoreComparison;
        } else {
            return RankComparator.STRONG_ACE.compare(this.highestRank, other.highestRank);
        }
    }

    @Override
    public String toString() {
        return this.type + " " + switch (this.type) {
            case STRAIGHT_FLUSH -> String.format("au %s à %s", this.highestRank, this.suit);
            case FULL_HOUSE -> String.format("aux %s par les xxx", this.highestRank);
            case FLUSH -> String.format("au %s de %s", this.highestRank, this.suit);
            case STRAIGHT -> String.format("au %s", this.highestRank);
            case DOUBLE_PAIR -> String.format("de %s par les xxx", this.highestRank);
            case HIGH_CARD -> String.format("par le %s", this.highestRank);
            default -> String.format("de %s", this.highestRank);
        };
    }
}
