package com.binarysearch;

import java.util.Arrays;

// binary search in strictly sorted 2D-array
public class BinarySearch2DSorted {
    public static void main(String[] args) {
        // strictly sorted matrix
        // in each row, the last element is less than or equal to first element in next row
        // the order may N x M
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int target = 14;
        int[] ans = findTarget(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] findTarget(int[][] arr, int target) {
        // first reduce the entire matrix into 2 rows

        int rows = arr.length; // each element is an array -> each row
        int cols = arr[0].length;
        // if there is no element -> {{}}
        if(cols == 0) {
            return new int[]{-1, -1};
        }
        // only 1 row -> {{1, 2, 3, 4, 5, 6}}
        if(rows == 1) {
            return binarySearch(arr, 0, 0, cols - 1, target);
        }

        // for selecting the element which is in mid col & mid row
        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        // loop breaks when there are only 2 rows -> rStart == rEnd - 1
        // rStart != (rEnd - 1)
        while(rStart < (rEnd - 1)) {
            // to find mid row
            int mid = rStart + (rEnd - rStart)/2;
            if(arr[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }

            if(arr[mid][cMid] < target) {
                // ignore the above rows
                // if element is lesser than target, above elements will also be lesser
                rStart = mid;
            } else {
                // ignore the below rows
                // if element is greater than target, below elements will also be greater
                rEnd = mid;
            }
        }
//        System.out.println(rEnd); 3

        // now, matrix has only 2 rows

        // check in the middle col in each row - 1st & 2nd
        if(arr[rStart][cMid] == target) return new int[]{rStart, cMid};
        // don't use rEnd which will be equal to 3
        if(arr[rStart + 1][cMid] == target) return new int[]{rStart + 1, cMid};

        // check in other 4 parts
        // 1st part
        if(arr[rStart][cMid - 1] >= target) {
            return binarySearch(arr, rStart, 0, cMid - 1, target);
        }
        // 2nd part
        // && .. because even if it is larger than cMid + 1 ele.,
        // there might be possibility rEnd or rStart + 1 can have that target ele. (in 3rd part)
        if(arr[rStart][cMid + 1] <= target && arr[rEnd][0] > target) {
            return binarySearch(arr, rStart, cMid + 1, cols - 1, target);
        }
        // 3rd part
        // no need to check again -> as LHS < RHS -> RHS > LHS
        if(arr[rStart + 1][cMid - 1] >= target) {
            return binarySearch(arr, rStart + 1, 0, cMid - 1, target);
        }
        // 4th part
        else {
            return binarySearch(arr, rStart + 1, cMid + 1, cols - 1, target);
        }
    }

    // for searching in particular given row in the matrix
    // row -> row index
    static int[] binarySearch(int[][] arr, int row, int cStart, int cEnd, int target) {

        while(cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart)/2;

            if(arr[row][mid] == target) {
                return new int[]{row, mid};
            }
            if(arr[row][mid] < target) {
                // present in right
                cStart = mid + 1;
            } else {
                // present in left
                cEnd = mid - 1;
            }
        }
        // if not found, in any of the part -> target is not found in the given matrix
        return new int[]{-1, -1};
    }

}
