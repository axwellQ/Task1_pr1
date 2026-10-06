package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Main {

    @ParameterizedTest
    @MethodSource("testBubbleSortData")
    void testBubbleSort(int N) {
        //Random random = new Random(7777);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i+1;//random.nextInt(100);

        long start = System.nanoTime();
        Main.selectionSort(arr);
        System.out.println(System.nanoTime() - start);

        for (int i = 0; i < arr.length - 1; i++) {
            Assertions.assertTrue(arr[i] <= arr[i + 1]);
        }
    }


    public static void selectionSort(int[] a) {
            for (int i = 0; i < a.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] < a[min]) min = j;
                }
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
    }

    static Stream<Arguments> testBubbleSortData() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(10),
                Arguments.of(100),
                Arguments.of(1000),
                Arguments.of(2000),
                Arguments.of(4000),
                Arguments.of(8000),
                Arguments.of(16000),
                Arguments.of(32000),
                Arguments.of(64000),
                Arguments.of(128000)
        );
    }
}
