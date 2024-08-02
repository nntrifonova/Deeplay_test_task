package org.example.task1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortArray {

    public static void sortArray() {
        List<Integer> numbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            numbers.add(random.nextInt(101) - 50); // случайные числа от -50 до 50
        }

        System.out.println("Исходный массив: " + numbers);

        List<Integer> result = SortArray(numbers);
        System.out.println("Итоговый массив: " + result);

    }

    private static List<Integer> SortArray(List<Integer> list) {
        List<Integer> evenList = IntStream.range(0, list.size())
                .filter(i -> list.get(i) % 2 == 0 && list.get(i) != 0)
                .mapToObj(list::get)
                .sorted(Comparator.reverseOrder())
                .toList();
        List<Integer> oddList = IntStream.range(0, list.size())
                .filter(i -> list.get(i) % 2 != 0)
                .mapToObj(list::get)
                .sorted(Comparator.naturalOrder())
                .toList();
        List<Integer> nullList = IntStream.range(0, list.size())
                .filter(i -> list.get(i) == 0)
                .mapToObj(list::get)
                .toList();
        return Stream.of(oddList, nullList, evenList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
