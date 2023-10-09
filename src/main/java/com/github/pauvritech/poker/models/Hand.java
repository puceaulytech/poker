package com.github.pauvritech.poker.models;

public class Hand implements Comparable<Hand> {
    private final Rank highestRank;
    private final HandType type;

    public Hand(HandType type, Rank highestRank) {
        this.type = type;
        this.highestRank = highestRank;
    }

    public Rank getHighestRank() {
        return highestRank;
    }

    public HandType getType() {
        return this.type;
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
        return this.type.toString() + " de " + this.highestRank.toString();
    }
}
