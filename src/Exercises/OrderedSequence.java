/*
Write a program that reads a sequence of integer numbers
and outputs true if the sequence is ordered (in ascending or descending order), otherwise, false.
Keep in mind, if a number has the same value as the following number, it does not break the order.

The sequence ends with 0.
Do not consider this number as a part of the sequence.
The sequence always has at least one number (excluding 0).
 */

package Exercises;

import java.util.Scanner;

public class OrderedSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(isOrdered(line));
    }

    public static boolean isOrdered(String line) {
        String[] letters = line.split(" ");
        int[] numbers = new int[letters.length];
        boolean isOrdered = false;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(letters[i]);
        }

        if (numbers.length > 1) {
            if (numbers[numbers.length - 1] == 0) {
                numbers[numbers.length - 1] = numbers[numbers.length - 2];
            }
            if (numbers[0] <= numbers[1]) {
                for (int i = 0; i < numbers.length - 1; i++) {
                    if (numbers[i] <= numbers[i + 1]) {
                        isOrdered = true;
                    } else {
                        isOrdered = false;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < numbers.length - 1; i++) {
                    if (numbers[i] >= numbers[i + 1]) {
                        isOrdered = true;
                    } else {
                        isOrdered = false;
                        break;
                    }
                }
            }
        } else if (numbers.length == 1) {
            isOrdered = true;
        }
        return isOrdered;
    }
}

/*
Sample Input:
9 8 7 6 5 4 3 2 1 0
Sample Output:
true

Sample Input:
1 2 3 3 9 0
Sample Output:
true

Sample Input:
1 2 5 5 2 3 0
Sample Output:
false
 */