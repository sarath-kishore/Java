package Sorting;

public class insertionSort {
    public static void main(String[] args) {
        insertionSort(new int[]{23,4,1,7,3,8,2,1}, 8);
    }
    public static void insertionSort(int[] arr, int size) {
        //Your code goes here
        for(int i=0; i<size; i++){
            int selection = arr[i];
            int selection_idx = i;
            for(int j=i; j>=0; j--){
                if(selection < arr[j]){
                    int temp = arr[selection_idx];
                    arr[selection_idx] = arr[j];
                    arr[j] = temp;
                    selection_idx = j;
                }
            }
        }

        for(int k=0; k< size; k++){
            System.out.print(arr[k] + " ");
        }
    }
}
