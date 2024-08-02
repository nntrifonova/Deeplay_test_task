package org.example.task1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortArray {

    /**
     * Метод для сортировки массива и вывода результата
     *
     * @param numbers исходный массив данных
     */
    public static void sortArray(List<Integer> numbers) {
        System.out.println("Исходный массив: " + numbers);

        List<Integer> result = sortArrayByEvenAndOdd(numbers);
        System.out.println("Итоговый массив: " + result );
    }

    private static List<Integer> sortArrayByEvenAndOdd(List<Integer> list) {
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
