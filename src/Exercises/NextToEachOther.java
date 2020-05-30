package Exercises;

import java.util.Scanner;

/*
Write a program that reads an unsorted array of integers and two numbers n and m.
The program must check if n and m occur next to each other in the array (in any order).
 */

public class NextToEachOther {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arraySize = in.nextInt();
        int[] arr = new int[arraySize];
        boolean close = false;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < arr.length - 1; i++) {
            if (n == arr[i] && m == arr[i + 1]) {
                close = true;
            } else if (m == arr[i] && n == arr[i + 1]) {
                close = true;
            }
        }
        System.out.println(close);
    }
}