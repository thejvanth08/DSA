package com.sorting;

import java.util.Arrays;

// Sorting from left to right -> Consider first element (0th index) as sorted array (as no elements are there to compare)
//
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 20, 9, 1, -1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int len = arr.length;
        // array will be sorted in len - 1 steps
        for(int step = 0; step < len - 1; step++) {
            // taking 1st element of unsorted array (1st index)
            // don't need to check till 0th index because there won't any prev. element
            for(int j = step + 1; j > 0; j--) {
                // swap if previous element is greater than current element
                if(arr[j-1] > arr[j]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }

    static void swap (int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


}
