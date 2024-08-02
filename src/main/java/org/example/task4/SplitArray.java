package org.example.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArray {
    public static void splitArray() {
        int[] numbers1 = {10, 11, 7, 7, 12};
        int k1 = 2;
        System.out.println("Input: " + Arrays.toString(numbers1) + ", K = " + k1);
        splitIntoParts(numbers1, k1);
    }

    private static void splitIntoParts(int[] numbers, int k) {
        int totalSum = Arrays.stream(numbers).sum();
        int averageMinSum = (totalSum - (k * (k - 1)) / 2) / k;

        if (averageMinSum < 0 || (totalSum - (k * (k - 1)) / 2) % k != 0) {
            System.out.println("невозможно");
            return;
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[numbers.length];

        if (findPartitions(numbers, used, result, averageMinSum, k)) {
            for (int i = 0; i < result.size(); i++) {
                List<Integer> part = result.get(i);
                System.out.println(part + ", " + (averageMinSum + i));
            }
        } else {
            System.out.println("невозможно");
        }
    }

    private static boolean findPartitions(int[] numbers, boolean[] used, List<List<Integer>> result,
                                          int averageMinSum, int k) {
        if (result.size() == k) {
            return true;
        }

        List<Integer> currentPart = new ArrayList<>();
        int currentSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (!used[i]) {
                currentPart.add(numbers[i]);
                currentSum += numbers[i];
                used[i] = true;

                if (currentSum == averageMinSum + result.size()) {
                    result.add(currentPart);
                    if (findPartitions(numbers, used, result, averageMinSum, k)) {
                        return true;
                    }
                    result.remove(result.size() - 1);
                } else if (currentSum < averageMinSum + result.size()) {
                    if (findPartitions(numbers, used, result, averageMinSum, k)) {
                        return true;
                    }
                }

                currentPart.remove(currentPart.size() - 1);
                currentSum -= numbers[i];
                used[i] = false;
            }
        }

        return false;
    }
}
