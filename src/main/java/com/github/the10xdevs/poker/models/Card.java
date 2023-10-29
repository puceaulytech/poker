package com.github.the10xdevs.poker.models;

import java.util.Objects;

/**
 * A playing card
 */
public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Compute the best hand possible out of multiples cards
     *
     * @param repr The cards the player has
     * @return The best hand
     */


    public static Card fromString(String repr) {
        if (!Character.isDigit(repr.charAt(0))) {
            Rank rank = Rank.fromString(String.valueOf(repr.charAt(0)));
            Suit suit = Suit.fromString(repr.substring(1));
            return new Card(suit, rank);
        }

        if (Character.isDigit(repr.charAt(1))) {
            Rank rank = Rank.fromString(repr.substring(0, 2));
            Suit suit = Suit.fromString(repr.substring(2));
            return new Card(suit, rank);
        }

        Rank rank = Rank.fromString(String.valueOf(repr.charAt(0)));
        Suit suit = Suit.fromString(repr.substring(1));
        return new Card(suit, rank);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card other) {
            return this.rank == other.rank && this.suit == other.suit;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return this.rank.toString() + this.suit.toString();
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
}
