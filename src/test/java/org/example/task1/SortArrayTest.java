package org.example.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayTest {

    @Test
    public void testSortArray() {
        List<Integer> input = Arrays.asList(5, 0, 3, 2, 0, 8, 1, 4);
        List<Integer> expectedOutput = Arrays.asList(1, 3, 5, 0, 0, 8, 4, 2);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        SortArray.sortArray(input);

        String expectedOutputString = "Исходный массив: " + input + "\r\n" +
                "Итоговый массив: " + expectedOutput;
        assertEquals(expectedOutputString, outContent.toString().trim());
    }

    @Test
    void sortEmptyArray() {
        List<Integer> input = List.of();
        List<Integer> expectedOutput = List.of();

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        SortArray.sortArray(input);

        String expectedOutputString = "Исходный массив: " + input + "\r\n" +
                "Итоговый массив: " + expectedOutput;
        assertEquals(expectedOutputString, outContent.toString().trim());
    }

    @Test
    void sortOddArray() {
        List<Integer> input = Arrays.asList(5, 3, -3, 1, 3);
        List<Integer> expectedOutput = Arrays.asList(-3, 1, 3, 3, 5);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        SortArray.sortArray(input);

        String expectedOutputString = "Исходный массив: " + input + "\r\n" +
                "Итоговый массив: " + expectedOutput;
        assertEquals(expectedOutputString, outContent.toString().trim());
    }

    @Test
    void sortEvenArray() {
        List<Integer> input = Arrays.asList(2, 8, -6, 4);
        List<Integer> expectedOutput = Arrays.asList(8, 4, 2, -6);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        SortArray.sortArray(input);

        String expectedOutputString = "Исходный массив: " + input + "\r\n" +
                "Итоговый массив: " + expectedOutput;
        assertEquals(expectedOutputString, outContent.toString().trim());
    }

    @Test
    void sortNullArray() {
        List<Integer> input = Arrays.asList(0, 0);
        List<Integer> expectedOutput = Arrays.asList(0, 0);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        SortArray.sortArray(input);

        String expectedOutputString = "Исходный массив: " + input + "\r\n" +
                "Итоговый массив: " + expectedOutput;
        assertEquals(expectedOutputString, outContent.toString().trim());
    }
}