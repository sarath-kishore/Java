package Sorting.cyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class findDuplicateElement {
    // can also be solved using a frequency array method. probably the best time.

    public static void main(String[] args) {
//        int[] arrAll = new int[]{1,2,0};
        int[] arrAll = new int[]{1,1,4,5,0};
//        int[] arrAll = new int[]{4,3,7,8,2,3,1,2,1};
//        System.out.println("duplicate elements: " + findhs(arrAll).toString());
        System.out.println("duplicate elements: " + findcs(arrAll).toString());
    }

    static List<Integer> findcs(int[] arr){
        // using cyclic sort
        // works correctly only when the minimum array length is equal to max element + 1.
        // probably because this code is meant for 0 indexed algorithm.
        // and, number of missing element in the range 0 to n should be equal to the number of duplicates.
        List<Integer> ls = new ArrayList<>();
        int i=0;
        while(i<arr.length){
            int correctIndex = arr[i];
            if(correctIndex<arr.length && arr[i]!=arr[correctIndex]){
                swap(arr, i, correctIndex);
            }
            else
                i++;
        }

        for(int j=0; j<arr.length; j++){
            if(j!=arr[j])
                ls.add(arr[j]);
        }

        return ls;
    }
    static List<Integer> findhs(int[] arr){
        // using hashset

        List<Integer> ls = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(hs.contains(arr[i]))
                ls.add(arr[i]);
            hs.add(arr[i]);
        }
        return ls;
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
