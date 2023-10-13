package com.github.the10xdevs.poker;

import com.github.the10xdevs.poker.models.Card;
import com.github.the10xdevs.poker.models.Hand;
import com.github.the10xdevs.poker.utils.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<Card> readPlayerCards(String ps1, BufferedReader reader) throws IOException {
        List<Card> cards = null;

        for (; ; ) {
            System.out.print(ps1);

            String line = reader.readLine();
            if (line == null) System.exit(0);

            String[] cardsStr = line.split("\\s+");

            try {
                cards = Arrays.stream(cardsStr).map(Card::fromString).toList();
            } catch (IllegalStateException e) {
                System.out.printf("Invalid input: %s%n", e.getMessage());
                continue;
            }

            if (Algorithms.hasDuplicates(cards)) {
                System.out.println("Duplicate cards found");
                continue;
            }

            break;
        }

        return cards;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Card> firstPlayerCards = readPlayerCards("Joueur 1? ", reader);
        List<Card> secondPlayerCards = readPlayerCards("Joueur 2? ", reader);

        Hand firstPlayerBestHand = Card.computeBestHand(firstPlayerCards);
        Hand secondPlayerBestHand = Card.computeBestHand(secondPlayerCards);

        if (firstPlayerBestHand.compareTo(secondPlayerBestHand) > 0) {
            System.out.println("Le joueur 1 gagne avec " + firstPlayerBestHand);
        } else {
            System.out.println("Le joueur 2 gagne avec " + secondPlayerBestHand);
        }
    }
}
