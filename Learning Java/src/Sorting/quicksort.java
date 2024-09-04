package Sorting;

import java.util.*;

public class quicksort {

    public static void main(String[] args) {
        // int[] arr = new int[]{8, 4, 5, 1, 33, 2, 9};
        int[] arr = new int[]{2,13,4,1,3,6,1,28};
        // int[] arr = new int[]{23,4,1,7,3,8,2,1};


        for(int a=0; a<arr.length; a++){
            System.out.print(arr[a] +" ");
        }

        System.out.println();

        quickSort(arr, 0, arr.length-1);

        for(int k=0; k<arr.length; k++){
            System.out.print(arr[k] +" ");
        }
    }

    static void quickSort(int[] arr, int low, int high){

        if(low>=high)
            return;

        int p_index = partition(arr, low, high);
//        int p_index = partition2(arr, low, high);  //uses the last element as pivot

        quickSort(arr, low, p_index-1);
        quickSort(arr, p_index+1, high);
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static int partition(int[] arr, int low, int high){
//uses the first element as pivot
        
        // int pivot = arr[low]; // using the 1st element as pivot leads to worst time, when the array is already sorted. best avg time would be to choose a pivot randomly.

        // the following 3 lines helps in picking a pivot randomly.
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high-low) + low;
        int pivot = arr[pivotIndex];

        swap(arr, pivotIndex, low); //swaps pivot to the first element, so that the same old code can be used as usual.

        System.out.println("pivot: " + pivot);

        int i=low;
        int j=high;

        for(int k=i; k<=j; k++){
            System.out.print(arr[k] +" ");
        }
        System.out.println();

        while(i<j){
            while(arr[i]<=pivot && i<high){
                i++;
            }

            while(arr[j]>=pivot && j>low){
                j--;
            }

            if(i<j){
                swap(arr, i, j);
            }

        };
        arr[low] = arr[j];
        arr[j] = pivot;

        return j;

        // arr[high] = arr[i];
        // arr[i] = pivot;

        // return i;

    }

    static int partition2(int[] arr, int low, int high){
//uses the last element as pivot
        int pivot = arr[high];
        System.out.println("pivot: " + pivot);

        int i=low;
        int j=high;

        for(int k=i; k<=j; k++){
            System.out.print(arr[k] +" ");
        }
        System.out.println();

        while(i<j){
            while(arr[i]<=pivot && i<j){
                i++;
            }

            while(arr[j]>=pivot && i<j){
                j--;
            }

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        };
        // arr[low] = arr[j];
        // arr[j] = pivot;

        // return j;

        arr[high] = arr[i];
        arr[i] = pivot;

        return i;

    }

}
