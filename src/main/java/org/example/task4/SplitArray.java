package org.example.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArray {

    /**
     * Метод для разбиения массива чисел на К сумм
     *
     * @param numbers исходный массив
     * @param numberOfPartitions - K количество сумм
     */
    public static void splitArray(int [] numbers, int numberOfPartitions) {
        System.out.println("Исходный массив: " + Arrays.toString(numbers) + ", K = " + numberOfPartitions);
        splitIntoParts(numbers, numberOfPartitions);
    }

    private static void splitIntoParts(int[] numbers, int k) {
        int totalSum = Arrays.stream(numbers).sum();
        int averageMinSum = (totalSum - (k * (k - 1)) / 2) / k;

        if (averageMinSum < 0 || (totalSum - (k * (k - 1)) / 2) % k != 0) {
            System.out.println("невозможно");
            return;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(new ArrayList<>());
        }

        if (canSplit(numbers, result, 0, averageMinSum, k)) {
            for (int i = 0; i < k; i++) {
                List<Integer> part = result.get(i);
                System.out.println(part + ", " + (averageMinSum + i));
            }
        } else {
            System.out.println("невозможно");
        }
    }

    private static boolean canSplit(int[] numbers, List<List<Integer>> parts, int index, int averageSum, int k) {
        if (index == numbers.length) {
            return checkParts(parts, averageSum, k);
        }

        for (int i = 0; i < k; i++) {
            parts.get(i).add(numbers[index]);
            if (canSplit(numbers, parts, index + 1, averageSum, k)) {
                return true;
            }
            parts.get(i).remove(parts.get(i).size() - 1); // Backtrack
        }

        return false;
    }

    private static boolean checkParts(List<List<Integer>> parts, int L, int K) {
        for (int i = 0; i < K; i++) {
            int sum = parts.get(i).stream().mapToInt(Integer::intValue).sum();
            if (sum != L + i) {
                return false;
            }
        }
        return true;
    }
}
