package com.patterns;

public class PatternOne {
    public static void main(String[] args) {
//        pattern1(5); // 5 -> no. of rows or lines
//        pattern2(3);
//        pattern3(5);
//        pattern4(5);
        pattern5(5);
    }

//    *
//    * *
//    * * *
    // outer for-loop is for rows
    // inner for-loop is for cols
    static void pattern1(int rows) {
        for(int i = 1; i <= rows; i++) {
            // for each row, it contains row no. of cols like 2nd row has 2 cols (inner loop runs -> i times)
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//    * * * *
//    * * * *
//    * * * *
//    * * * *
    static void pattern2(int rows) {
        for(int i = 1; i <= rows; i++) {
            // inner loop also runs n or rows times -> no. of rows
            for(int j = 1; j <= rows; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//    * * *
//    * *
//    *
    static void pattern3(int rows) {
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= rows + 1 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//    1
//    1 2
//    1 2 3
    static void pattern4(int rows) {
        for(int i = 1; i <= rows; i++) {
            // no. of cols at each row = row order = i (2nd contains 2 cols)
            for(int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

//    for, n = 3
//   1 *
//   2 * *
//   3 * * *
//   4 * *
//   5 *
    static void pattern5(int n) {
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
