package com.sorting;

import java.util.Arrays;

// In bubble sort, each element is compared with adjacent elements & swapped correspondingly
// Time complexity: O(n^2); Space complexity: O(1) -> constant
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 6, 4, 2, 0};
        // as arr is an object, it does not pass by value -> it pass by reference, so it also changes the value of orginal array in sort()
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int len = arr.length;
        // It takes len - 1 no. of steps or passes to sort the array
        // in each step, the each largest element is placed in last index -> so array is getting sorted from the end
        // in step 1 (i = 0), 1st largest element is placed at last index (len -1)
        // in step 2 (i = 1), 2st largest element is placed at last before index (len -2)
        for(int step = 0; step < len - 1; step++) {
            // as the array is sorted from end, last elements need not to be compared
            for(int j = 1; j < len - step; j++) {
                // comparing with previous adjacent element
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
//        return arr;
    }
}
