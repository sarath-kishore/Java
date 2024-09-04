package Recursion;

public class bubbleSort {
    public static void main(String[] args) {
        // int[] arr = new int[]{8, 4, 5, 1, 33, 2, 6, 9};
//        int[] arr = new int[]{2,13,4,1,3,6,28};
         int[] arr = new int[]{23,4,1,7,3,8,2,1};

        for(int a=0; a<arr.length; a++){
            System.out.print(arr[a] +" ");
        }

        System.out.println();

        sort(arr, arr.length-1, 0);

        for(int k=0; k<arr.length; k++){
            System.out.print(arr[k] +" ");
        }
    }

    static void sort(int[] arr, int r, int c){
        if(r==0){
            return;
        }

        if(c < r){
            if(arr[c]>arr[c+1]){
                swap(arr, c, c+1);
            }
            sort(arr, r, c+1);
        }else{
            sort(arr, r-1, 0);
        }

    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
}
