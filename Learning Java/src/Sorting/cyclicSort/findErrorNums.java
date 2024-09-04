package Sorting.cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findErrorNums {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,1};
        System.out.println("elements: " + findNumsCS(arr).toString());
        // prints the element index and the supposed element.
    }
    static List<Integer> findNumsCS(int[] arr){
        // range 1 to n.

        List<Integer> ls = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
            int correctIndex = arr[i]-1;
            if(arr[i]!=arr[correctIndex]){
                swap(arr, i, correctIndex);
            }
            else{
                i++;
            }
        }
        System.out.println("elements: " + Arrays.toString(arr));
        for(int j=0; j<arr.length; j++){
            if(j!=arr[j]-1)
            {
                ls.add(arr[j]);
                ls.add(j+1);
            }
        }

        return ls;
    }



    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
