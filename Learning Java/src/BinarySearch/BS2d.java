package BinarySearch;

import java.util.Arrays;

public class BS2d {
    public static void main(String[] args) {
        int[][] arrAll = new int[][]{
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
//        int[][] arrSortedStrictly = new int[][]{
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

        int[][] arrSortedStrictly = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };

        System.out.println("not strictly sorted element index: " + Arrays.toString(bs2d(arrAll, 37)));
        System.out.println("strictly sorted element index: " + Arrays.toString(bs2dStrictlySorted(arrSortedStrictly, 23)));
    }

    static int[] binarySearch1d(int[][] matrix, int target, int row, int cStart, int cEnd){
        while(cStart<=cEnd){
            int midCol = cStart + (cEnd - cStart) / 2;
            if(matrix[row][midCol]==target){
                return new int[]{row, midCol};
            }else if(matrix[row][midCol]>target){
                cEnd = midCol-1;
            }else{
                cStart = midCol+1;
            }
        }
        return new int[] {-1,-1};
    }

    static int[] bs2dStrictlySorted(int[][] matrix, int target){
//        time: O(log n + log m) , where n -> rows, m -> cols
        int row = matrix.length;
        int col = matrix[0].length;

        if(row == 1) // if there's only 1 row, just normal binary search
            return binarySearch1d(matrix, target, 0, 0, col-1);

        int rStart = 0;
        int rEnd = row-1;
        int cStart = 0;
        int cEnd = col-1;
        int midCol = cStart + (cEnd - cStart) / 2;

        while(rStart < rEnd-1){
        // while there are more than 2 rows. when there are only 2 rows remaining, loop will exit.
            int midRow = rStart + (rEnd - rStart) / 2;

            if(matrix[midRow][midCol]==target)
                return new int[]{midRow, midCol};
            else if(matrix[midRow][midCol]>target){
                rEnd = midRow;
            }else{
                rStart = midRow;
            }
        }

// method 1:
        int[] temp = binarySearch1d(matrix, target, rStart, 0, cEnd);
        if(temp[0] == -1)
            temp = binarySearch1d(matrix, target, rStart+1, 0, cEnd);

        return temp;
// method 1 ----------*

// method 2:
////      { check the middle column elements of the 2 remaining rows.
//        if(matrix[rStart][midCol]==target)
//            return new int[]{rStart, midCol};
//
//        if(matrix[rStart+1][midCol]==target)
//            return new int[]{rStart+1, midCol};
////      }
//
//
//// check the left side elements of 1st row middle column
//        if(target<=matrix[rStart][midCol-1])
//            return binarySearch1d(matrix, target, rStart, 0, midCol-1);
//
//// check the right side elements of 1st row middle column
//        else if(target>=matrix[rStart][midCol+1] && target<=matrix[rStart][cEnd])
//            return binarySearch1d(matrix, target, rStart, midCol+1, cEnd);
//
//// check the left side elements of 2nd row middle column
//        else if(target<=matrix[rStart+1][midCol-1])
//            return binarySearch1d(matrix, target, rStart+1, 0, midCol-1);
//
//// check the right side elements of 2nd row middle column
//        else
//            return binarySearch1d(matrix, target, rStart+1, midCol+1, cEnd);
//
////        return new int[]{-1,-1}; no need for this as it will never be reached.
////        if no IF statements are evaluated, the last else block will execute and that result will be returned.

// method 2 ----------*
    }

    static int[] bs2d(int[][] arr, int target){
        int row_low = 0;
        int col_low = 0;
        int col_high = arr[0].length-1;
        int row_high = arr.length-1; // row count

//        while(row_low<=row_high && col_high>=0){
//            //starts from 0, c-1
//            if(arr[row_low][col_high]==target){
//                return new int[]{row_low, col_high};
//            }else if(arr[row_low][col_high] < target){
//                row_low = row_low+1;
//            }else if(arr[row_low][col_high] > target){
//                col_high = col_high-1;
//            }
//        }

        while(row_high>=0 && col_low <= col_high){
            //starts from r-1, 0
            if(arr[row_high][col_low]==target){
                return new int[]{row_high, col_low};
            }else if(arr[row_high][col_low] < target){
                col_low = col_low+1;
            }else if(arr[row_high][col_low] > target){
                row_high = row_high-1;
            }
        }

        return new int[]{-1,-1};
    }
}
