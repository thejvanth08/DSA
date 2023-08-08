package com.patterns;

public class PatternTwo {
    public static void main(String[] args) {
        pattern6(5);
    }
//    n = 3
//      *     -> 2 spaces
//     * *    -> 1 space
//    * * *   -> 0
//     * *    -> 1
//      *     -> 2
    static void pattern6(int n) {
        int totCols, totSpaces;
        // no. of rows = n * 2 - 1 (for n = 3, rows = 5)
        for(int i = 1; i <= n * 2 -1 ; i++) {

            // print spaces separately
            // if row is <= n -> totSpaces =  n - row(i)
            // else -> totSpaces = row - n
            totSpaces = (i <= n) ? n - i : i - n;
            for(int s = 1; s <= totSpaces; s++) {
                System.out.print(" ");
            }

            // print stars separately
            totCols = (i <= n) ? i : n - (i - n);
            for(int j = 1; j <= totCols; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern7(int n) {
        int totCols;
        // no. of rows = n * 2 - 1 (for n = 3, rows = 5)
        for(int i = 1; i <= n * 2 -1 ; i++) {
            // totCols for each row, totCols when (row) i <= n -> totCols = i
            // else totCols = n - (i- n)
            totCols = (i <= n) ? i : n - (i - n);
            for(int j = 1; j <= totCols; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
