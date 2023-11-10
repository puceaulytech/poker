package com.github.the10xdevs.poker;

import com.github.the10xdevs.poker.models.Duel;
import com.github.the10xdevs.poker.models.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void printUsage() {
        System.out.println("""
                \033[1m---- Bienvenue au jeu de Poker ----\033[0m
                \033[4mComment entrer une valeur:\033[0m
                Nombre ou initiale de la tête (V, D, R, A)
                \033[4mComment entrer une couleur:\033[0m
                \033[1;90m♠\033[0m Piques  : Pi
                \033[1;31m♥\033[0m Coeurs  : Co
                \033[1;90m♣\033[0m Trèfles : Tr
                \033[1;31m♦\033[0m Carreaux: Ca
                \033[4mExemple: 10Pi\033[0m
                """);
    }

    public static void main(String[] args) {
        printUsage();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (; ; ) {
            Player playerOne = Player.readFromTerminal(reader);
            Player playerTwo = Player.readFromTerminal(reader);
            Duel game = new Duel(playerOne, playerTwo);
            game.play();
        }
    }
}
