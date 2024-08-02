package org.example.task2;

import java.util.*;

public class MostCommonNumber {

    /**
     * Метод для поиска наиболее часто встречающегося числа в массиве
     * @param array исходный массив
     */
    public static void mostCommonNumber(int[] array) {
        System.out.println("Исходный массив: " + Arrays.toString(array));
        List<Integer> result = findMostCommon(array);
        System.out.println(result);
    }

    private static List<Integer> findMostCommon(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        countFrequencyOfArray(array, map);
        int max = Collections.max(map.values());
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    private static void countFrequencyOfArray(int[] array, HashMap<Integer, Integer> map) {
        for (Integer i : array) {
            Integer value = map.get(i);
            if (value == null) {
                map.put(i, 1);
            } else {

                map.put(i, ++value);
            }
        }
    }
}
