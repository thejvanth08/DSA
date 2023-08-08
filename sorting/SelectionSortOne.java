package com.sorting;
import java.util.*;

// Selecting largest element is unsorted array, then placing it in end of unsorted array (front of sorted array)
// while choosing largest element, the array is get sorted from last
public class SelectionSortOne {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 4, 2, 0, -10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int len = arr.length;
        // array is sorted in len - 1 steps or passes
        for(int i = 0; i < len-1; i++) {
            // choosing last index of unsorted array
            // at first step (i = 0), last index will be len - 1 -> len - 1 - i
            int last = len - i - 1;
            // finding max value's index within unsorted array
            int maxIndex = findMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }

    }

    static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    static int findMaxIndex(int[] arr, int start, int end) {
        int max = start; // from 0th index is taken as max value initially
        // only need to check max value within unsorted array
        for(int i = 1; i <= end; i++) {
            if(arr[i] > arr[max]) {
                // we need only max value's index (not value itself)
                max = i;
            }
        }
        return max;
    }
}
