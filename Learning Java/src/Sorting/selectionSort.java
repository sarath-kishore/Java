package Sorting;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23,4,1,7,3,8,2,1};
        selectionSort(new int[]{23,4,1,7,3,8,2,1});
    }
    public static void selectionSort(int[] arr) {
        //Your code goes here
        for(int i=0;i<arr.length-1; i++){
            int minidx=i, minval=arr[i];

            System.out.print("i: " + i + " - ");
            for(int k=0; k<arr.length; k++){
                System.out.print( arr[k] +" ");
            }
            System.out.println();

            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<minval){
                    minval=arr[j];
                    minidx = j;
                }
            }
            int temp = arr[i];
            arr[i] = minval;
            arr[minidx] = temp;

        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }

    }
}
