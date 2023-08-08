package com.sorting;

import java.util.Arrays;

// Selecting the smallest element in unsorted array, placing it after sorted array (from 1st to last)
// array gets sorted from left to right
public class SelectionSortTwo {
    public static void main(String[] args) {
            int[] arr = new int[]{6, 4, 2, 0, -10, 89, 29};
            sort(arr);
            System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int len = arr.length;
        // it also takes len - 1 steps (0 to len - 2)
        for(int i = 0; i < len - 1; i++) {
            // selecting first index of unsorted array
            // initially (i = 0), entire array will be unsorted -> first = 0 = i
            int first = i;
            // as array is sorted from left to right, we need to find min value within unsorted array which will be in right side
            // always first only changes, len is constant
            int minIndex = findMinIndex(arr, first, len);
            swap(arr, minIndex, first);
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int findMinIndex(int[] arr, int start, int end) {
        int minIndex = start;
        for(int i = start + 1; i < end; i++) {
            if(arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
