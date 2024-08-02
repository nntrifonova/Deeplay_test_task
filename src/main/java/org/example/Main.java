package org.example;

import org.example.task1.SortArray;
import org.example.task2.MostCommonNumber;
import org.example.task3.DiceGame;
import org.example.task4.SplitArray;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int taskNumber = input.nextInt();

        switch (taskNumber) {
            case 1:
                SortArray.sortArray();
                break;
            case 2:
                MostCommonNumber.mostCommonNumber();
                break;
            case 3:
                DiceGame.diceGame();
                break;
            case 4:
                SplitArray.splitArray();
            default:
                System.out.println("Такого задания нет, небходим ввод от 1 до 4");
                break;
        }
    }
}