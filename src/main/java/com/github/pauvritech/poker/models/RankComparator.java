package com.github.pauvritech.poker.models;

import java.util.Comparator;


public class RankComparator implements Comparator<Rank> {
    private final boolean isAceWeak;

    /**
     * Compare ranks considering the ace as the strongest card
     */
    public static final RankComparator STRONG_ACE = new RankComparator(false);

    /**
     * Compare ranks considering the ace as the weakest card
     */
    public static final RankComparator WEAK_ACE = new RankComparator(true);

    private RankComparator(boolean isAceWeak) {
        this.isAceWeak = isAceWeak;
    }

    @Override
    public int compare(Rank firstRank, Rank secondRank) {
        int firstRankNumber = firstRank.getNumberRank();
        int secondRankNumber = secondRank.getNumberRank();

        if (this.isAceWeak) {
            if (firstRank == Rank.ACE) {
                firstRankNumber = 1;
            }

            if (secondRank == Rank.ACE) {
                secondRankNumber = 1;
            }
        }

        return Integer.compare(firstRankNumber, secondRankNumber);
    }
}
