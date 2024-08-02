package org.example.task2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MostCommonNumberTest {

    @Test
    void singleMostCommonNumber() {

        int[] input = {5, 0, 3, 2, 0, 8, 2, 1, 4, 2};
        int[] expectedOutput = {2};

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        MostCommonNumber.mostCommonNumber(input);

        String expectedOutputString = "Исходный массив: " + Arrays.toString(input) +
                "\r\n" + Arrays.toString(expectedOutput);
        assertEquals(expectedOutputString, outContent.toString().trim());

    }
    @Test
    void twoMostCommonNumbers() {

        int[] input = {5, 0, 3, 0, 8, 2, 1, 4, 2};
        int[] expectedOutput = {0, 2};

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        MostCommonNumber.mostCommonNumber(input);

        String expectedOutputString = "Исходный массив: " + Arrays.toString(input) +
                "\r\n" + Arrays.toString(expectedOutput);
        assertEquals(expectedOutputString, outContent.toString().trim());

    }
    @Test
    void noMostCommonNumber() {

        int[] input = {5, 0, 3, 2, 8, 6, 1, 4, 7};
        int[] expectedOutput = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        MostCommonNumber.mostCommonNumber(input);

        String expectedOutputString = "Исходный массив: " + Arrays.toString(input) +
                "\r\n" + Arrays.toString(expectedOutput);
        assertEquals(expectedOutputString, outContent.toString().trim());

    }

}