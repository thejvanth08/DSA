package com.binarysearch;

import java.util.Arrays;

public class BinarySearch2D {
    public static void main(String[] args) {
        // array must be sorted row-wise + col-wise (not strictly sorted)
        // last element in a row is not less than first element in the next row
        // array must be square matrix
        int[][] arr = new int[][]{
                {10, 23,30, 39},
                {20, 25, 35, 45}, // it  can't have like 20, 21, 23 -> which is not col wise sorted
                {30, 90, 99, 100}
        };
        int target = 99;
        int[] ans = findTarget(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    // returns array of values [row, col]
    static int[] findTarget(int[][] arr, int target) {
        // taking the last element in 1st row
        int row = 0;
        int col = arr[0].length - 1;

        // as we increase row++ & decrease col-- (reducing the search space)
        while(row < arr.length && col >= 0) {
            if(arr[row][col] == target) {
                return new int[]{row, col};
            }
            if(arr[row][col] < target) {
                // as row is in ascending order
                row++;
            } else {
                // arr[row][col] > target
                // as col is also in ascending order -> all elements in that col will also be > target
                col--;
            }
        }
        // if not found
        return new int[]{-1, -1};
    }

}
