package Sorting.cyclicSort;

public class cyclicSort {
// index = value - 1;
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,4,5};
        sort(arr);
        for(int k=0; k<arr.length; k++){
            System.out.print(arr[k] +" ");
        }
    }

    static void sort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correctIndex = arr[i]-1;
            if(arr[i]!=arr[correctIndex]){
                swap(arr,i, correctIndex);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
