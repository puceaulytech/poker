package com.github.the10xdevs.poker;

import com.github.the10xdevs.poker.models.Card;
import com.github.the10xdevs.poker.models.Hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<Card> readPlayerCards(BufferedReader reader) throws IOException {
        System.out.print("Cards? ");

        String line = reader.readLine();
        if (line == null) System.exit(0);

        String[] cardsStr = line.split(" ");

        return Arrays.stream(cardsStr).map(Card::fromString).toList();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Card> firstPlayerCards = readPlayerCards(reader);
        List<Card> secondPlayerCards = readPlayerCards(reader);

        Hand firstPlayerBestHand = Card.computeBestHand(firstPlayerCards);
        Hand secondPlayerBestHand = Card.computeBestHand(secondPlayerCards);

        if (firstPlayerBestHand.compareTo(secondPlayerBestHand) > 0) {
            System.out.println("Le joueur 1 gagne avec " + firstPlayerBestHand);
        } else {
            System.out.println("Le joueur 2 gagne avec " + secondPlayerBestHand);
        }
    }
}
