package Exercises;

import java.util.Scanner;

/*
Given a two-dimensional array (matrix) and the two numbers: i and j.
Swap the columns with indexes i and j within the matrix.
Input contains matrix dimensions n and m, not exceeding 100
-> then the elements of the matrix,
-> then the indexes i and j.
 */

public class SwapColumns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int raw = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[raw][col];

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                arr[i][k] = scanner.nextInt();
            }
        }

        int index1ToSwap = scanner.nextInt();
        int index2ToSwap = scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][index1ToSwap];
            arr[i][index1ToSwap] = arr[i][index2ToSwap];
            arr[i][index2ToSwap] = temp;
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
