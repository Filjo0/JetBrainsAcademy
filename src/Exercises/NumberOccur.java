package Exercises;

import java.util.Scanner;

/*
Write a program that read an array of ints and an integer number n.
The program must check how many times n occurs in the array.
*/

public class NumberOccur {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arraySize = in.nextInt();
        int[] array = new int[arraySize];

        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        int occurrence = in.nextInt();

        for (int value : array) {
            if (occurrence == value) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
