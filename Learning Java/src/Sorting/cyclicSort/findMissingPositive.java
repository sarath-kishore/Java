package Sorting.cyclicSort;

import java.util.Arrays;
//cyclic sort
public class findMissingPositive {


    public static void main(String[] args) {
        int[] arrAll = new int[]{7,8,1,2,11};
//        int[] arrAll = new int[]{1,2,0};
//        int[] arrAll = new int[]{1,-1,0,3};
        System.out.println("missing positive element: " + firstMissingPositive(arrAll));
    }
    public static int firstMissingPositive(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correctIndex = arr[i]-1;
            if(arr[i] > 0 && arr[i]<arr.length && arr[i]!=arr[correctIndex]){
                swap(arr, i, correctIndex);
            }else{
                i++;
            }
        }
        System.out.println("array: " + Arrays.toString(arr));
        for(int j=0; j<arr.length; j++){
            if(arr[j]!=j+1)
            {
                System.out.println("answer");
                return j+1;}
        }
        return arr.length+1;
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
