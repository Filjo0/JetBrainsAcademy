package Exercises;

import java.util.Scanner;

/*
The cinema has n rows, each row consists of m seats (n and m do not exceed 20).
The two-dimensional matrix stores the information on the sold tickets.
Number 1 means that the ticket for this place is already sold, the number 0 means that the place is available.
You want to buy k tickets to the neighboring seats in the same row. Find whether it can be done.
 */

public class Cinema {

   private static final Scanner scanner = new Scanner(System.in);
   private static final int rows = scanner.nextInt();
   private static final int seats = scanner.nextInt();
   private static final int[][] ARR = new int[rows][seats];


    public static void main(String[] args) {
        fillArr();
        checkArr();
    }

    public static void fillArr() {
        for (int i = 0; i < ARR.length; i++) {
            for (int k = 0; k < ARR[i].length; k++) {
                ARR[i][k] = scanner.nextInt();
            }
        }
    }

    public static void checkArr() {
        int numberOfSeatsWanted = scanner.nextInt();
        int count = 0;
        int row = 0;

        outerLoop:
        for (int i = 0; i < ARR.length; i++) {
            for (int k = 0; k < ARR[i].length; k++) {
                if (ARR[i][k] == 0) {
                    for (int l = 0; l < numberOfSeatsWanted && ARR[i].length - k >= numberOfSeatsWanted; l++) {
                        if (ARR[i][k + l] == 0) {
                            count++;
                            if (count >= numberOfSeatsWanted) {
                                row = i + 1;
                                break outerLoop;
                            }
                        } else {
                            count = 0;
                        }
                    }
                } else {
                    count = 0;
                }
            }
        }
        System.out.println(row);
    }
}