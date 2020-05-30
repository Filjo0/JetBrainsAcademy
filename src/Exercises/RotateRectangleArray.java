package Exercises;

import java.util.Scanner;

/*
Given a rectangle array n×m in size.
Rotate it by 90 degrees clockwise, by recording the result into the new array m×n in size.
 */

public class RotateRectangleArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int raw = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[raw][col];
        int[][] rotArr = new int[col][raw];

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                arr[i][k] = scanner.nextInt();
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int k = 0; k < arr.length; k++) {
                rotArr[arr.length - 1 - i][k] = arr[k][i];
            }
        }
        for (int[] ints : rotArr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
