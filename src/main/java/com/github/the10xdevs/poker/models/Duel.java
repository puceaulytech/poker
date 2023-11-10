package com.github.the10xdevs.poker.models;

import com.github.the10xdevs.poker.utils.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Duel {
    private final Player firstPlayer;
    private final Player secondPlayer;

    private Hand winningHand;
    private int duelResult;

    public Duel(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play() {
        if (this.hasDuplicateCards()) {
            System.out.println("Certaines cartes sont en double");
            return;
        }

        Hand firstPlayerHand = this.firstPlayer.computeBestHand();
        Hand secondPlayerHand = this.secondPlayer.computeBestHand();

        this.duelResult = firstPlayerHand.compareTo(secondPlayerHand);
        if (this.duelResult != 0)
            this.winningHand = this.duelResult >= 1 ? firstPlayerHand : secondPlayerHand;
        System.out.println(this.resultToString());
    }

    private String resultToString() {
        if (this.duelResult == 0) return "Egalité";
        String winnerString = this.duelResult == 1 ? "joueur 1" : "joueur 2";
        return String.join(" ", winnerString, "gagne avec la main suivante :", this.winningHand.toString());
    }

    private boolean hasDuplicateCards() {
        List<Card> allCards = new ArrayList<>(this.firstPlayer.getCards());
        allCards.addAll(this.secondPlayer.getCards());
        return Algorithms.hasDuplicates(allCards);
    }
}
