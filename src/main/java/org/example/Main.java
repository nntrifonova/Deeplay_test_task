package org.example;

import org.example.task1.SortArray;
import org.example.task2.MostCommonNumber;
import org.example.task3.DiceGame;
import org.example.task4.SplitArray;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите число от 1 до 4");
        Scanner input = new Scanner(System.in);
        int taskNumber = input.nextInt();

        switch (taskNumber) {
            case 1:
                List<Integer> dataForSortArray = Arrays.stream(Utils.generateData(30)).boxed().toList();
                SortArray.sortArray(dataForSortArray);
                break;
            case 2:
                int[] dataForMostCommonNumber = Utils.generateData(30);
                MostCommonNumber.mostCommonNumber(dataForMostCommonNumber);
                break;
            case 3:
                int[] player1Sequence = Utils.insertPlayersSequence();
                int[] player2Sequence = Utils.insertPlayersSequence();
                DiceGame currentGame = new DiceGame(player1Sequence, player2Sequence);
                currentGame.countProbability();
                break;
            case 4:
                int[] dataForSplitArray = Utils.generateData(7);
                int numberOfPartitions = Utils.generateNumber();
                SplitArray.splitArray(dataForSplitArray, numberOfPartitions);
                break;
            default:
                System.out.println("Такого задания нет, небходим ввод от 1 до 4");
                break;
        }
    }
}