package org.example.task4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SplitArrayTest {

    @Test
    void splitArray() {
        int[] input = {10, 11, 7, 7, 12};
        int k = 2;
        String expectedOutput = "[11, 12], 23\r\n[10, 7, 7], 24";

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        SplitArray.splitArray(input, k);

        String expectedOutputString = "Исходный массив: " + Arrays.toString(input) + ", K = " + k + "\r\n" +
                expectedOutput;
        assertEquals(expectedOutputString, outContent.toString().trim());
    }
}