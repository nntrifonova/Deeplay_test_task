package org.example.task3;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    int[] player1Sequence;
    int[] player2Sequence;

    public DiceGame(int[] player1Sequence, int[] player2Sequence) {
        this.player1Sequence = player1Sequence;
        this.player2Sequence = player2Sequence;
    }

    public static void diceGame() {
        int[] player1Sequence = insertPlayersSequence();
        int[] player2Sequence = insertPlayersSequence();

        DiceGame currentGame = new DiceGame(player1Sequence, player2Sequence);
        currentGame.countProbability();
    }

    private static int[] insertPlayersSequence() {
        Scanner input = new Scanner(System.in);
        int[] player = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter number");
            player[i] = input.nextInt();
        }
        return player;
    }

    private void countProbability() {
        int[] player1Sequence = this.player1Sequence;
        int[] player2Sequence = this.player2Sequence;
        int numberOfRolls = 1000;
        int simulations = 10000;

        Random random = new Random();
        int player1Wins = 0;
        int player2Wins = 0;
        int draws = 0;

        for (int i = 0; i < simulations; i++) {
            int player1Score = simulateGame(random, player1Sequence, numberOfRolls);
            int player2Score = simulateGame(random, player2Sequence, numberOfRolls);

            if (player1Score > player2Score) {
                player1Wins++;
            } else if (player2Score > player1Score) {
                player2Wins++;
            } else {
                draws++;
            }
        }

        double player1WinProbability = (double) player1Wins / simulations;
        double player2WinProbability = (double) player2Wins / simulations;
        double drawProbability = (double) draws / simulations;

        System.out.printf("Вероятность победы игрока 1: %.2f%%\n", player1WinProbability * 100);
        System.out.printf("Вероятность победы игрока 2: %.2f%%\n", player2WinProbability * 100);
        System.out.printf("Вероятность ничьей: %.2f%%\n", drawProbability * 100);
    }

    private static int simulateGame(Random random, int[] sequence, int numberOfRolls) {
        int score = 0;
        int[] rolls = new int[numberOfRolls];

        for (int i = 0; i < numberOfRolls; i++) {
            rolls[i] = random.nextInt(6) + 1; // Генерируем число от 1 до 6
        }

        for (int j = 0; j < numberOfRolls - 2; j++) {
            if (rolls[j] == sequence[0] && rolls[j + 1] == sequence[1] && rolls[j + 2] == sequence[2]) {
                score++;
            }
        }

        return score;
    }
}
