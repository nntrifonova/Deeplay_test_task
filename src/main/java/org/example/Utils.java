package org.example;

import java.util.Random;
import java.util.Scanner;

public final class Utils {
    public static int[] generateData(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(101);
        }
        return numbers;
    }

    public static int generateNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;

    }

    public static int[] insertPlayersSequence() {
        Scanner input = new Scanner(System.in);
        int[] player = new int[3];
        System.out.println("Введите 3 числа от 1 до 6 через пробел");
        try {
            for (int i = 0; i < 3; i++) {
                int number = input.nextInt();
                if (number >= 1 && number <= 6) {
                    player[i] = number;
                } else {
                    System.out.println("Invalid range input");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer input");
        }

        return player;
    }
}
