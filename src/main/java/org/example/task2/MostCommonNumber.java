package org.example.task2;

import java.util.*;

public class MostCommonNumber {

    public static void mostCommonNumber() {
        int[] array = new int[30];
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            array[i] = random.nextInt(101) - 50;
        }
        System.out.println(Arrays.toString(array));
        List<Integer> result = FindMostCommon(array);
        System.out.println(result);
    }

    public static List<Integer> FindMostCommon(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        CountArr(array, map);
        int max = Collections.max(map.values());
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    private static void CountArr(int[] array, HashMap<Integer, Integer> map) {
        for (Integer i : array) {
            Integer value = map.get(i);
            if (value == null) {
                map.put(i, 1);
            } else {
                map.put(i, ++value);  //подумать про значение
            }
        }
    }
}
