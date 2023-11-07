package com.github.the10xdevs.poker.models;

/**
 * Represents the rank of a card.
 * <p>
 * Note: The ace is ranked 1 or 14 depending on the context
 */
public enum Rank implements Comparable<Rank> {
    ACE(14),
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2);

    private final int numberRank;

    Rank(int numberRank) {
        this.numberRank = numberRank;
    }

    public static Rank fromString(String repr) {
        try {
            int v = Integer.parseInt(repr);

            return switch (v) {
                case 2 -> Rank.TWO;
                case 3 -> Rank.THREE;
                case 4 -> Rank.FOUR;
                case 5 -> Rank.FIVE;
                case 6 -> Rank.SIX;
                case 7 -> Rank.SEVEN;
                case 8 -> Rank.EIGHT;
                case 9 -> Rank.NINE;
                case 10 -> Rank.TEN;
                default -> throw new IllegalStateException("invalid rank: " + v);
            };

        } catch (NumberFormatException e) {
            return switch (repr) {
                case "A" -> Rank.ACE;
                case "R" -> Rank.KING;
                case "D" -> Rank.QUEEN;
                case "V" -> Rank.JACK;
                default -> throw new IllegalStateException("invalid rank: " + repr);
            };
        }
    }

    public int getNumberRank() {
        return numberRank;
    }

    @Override
    public String toString() {
        return switch (this) {
            case ACE -> "A";
            case KING -> "R";
            case QUEEN -> "D";
            case JACK -> "V";
            case TEN -> "10";
            case NINE -> "9";
            case EIGHT -> "8";
            case SEVEN -> "7";
            case SIX -> "6";
            case FIVE -> "5";
            case FOUR -> "4";
            case THREE -> "3";
            case TWO -> "2";
        };
    }
}

