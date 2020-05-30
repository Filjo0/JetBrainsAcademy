package Exercises;

import java.util.Scanner;

/*
Write a program that reads an array of lowercase strings
And checks whether the array is in alphabetical order or not.
 */

public class AlphabeticalOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] letters = line.split(" ");
        boolean compare = false;

        for (int i = 0; i < letters.length - 1; i++) {
            int i1 = letters[i].compareTo(letters[i + 1]);
            compare = i1 <= 0;
        }
        System.out.println(compare);
    }
}
