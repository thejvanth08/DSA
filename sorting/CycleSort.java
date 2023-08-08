package com.sorting;
import java.util.*;

// when the array contains 1 to n elements (n -> length of array) -> Use Cycle Sort
// i-th index contains element whose value is i + 1
// arr[i] must be placed at i - 1 index (1 at 0th index) likewise
// it require n-1 comparisons for worst case
public class CycleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int len = arr.length;
        // start from 0th index element
        // if is present at proper index -> arr[i] at i - 1, no need to swap so move to next index
        // else move arr[i] to i - 1 index by swapping with arr[i - 1]
        int i = 0;
        while(i < len) {
            // correct index for arr[i] is arr[i] - 1 (5 is at 4th index)
            int correct = arr[i] - 1;
            // if not present in proper index

            if (arr[i] != arr[correct]) { // 1 is not at 0
                swap(arr, i, correct);
            } else { // if present at correct index
                i++;
            }
        }
    }

    // for placing arr[i] in it's correct position which is arr[i] - 1
    // 7 is at 6th index
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
