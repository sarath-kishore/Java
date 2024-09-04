package Sorting;

public class countingSort {
// doesn't work well with decimals and large arrays
    public static void main(String[] args){
        int[] arr = {2,4,6,8,3,7,1};
//        int[] arr = {2,4,0,8,3,7,1};
        for(int k=0; k<arr.length; k++){
            System.out.print(arr[k] +" ");
        }
        System.out.println();

        countSort(arr);

        for(int k=0; k<arr.length; k++){
            System.out.print(arr[k] +" ");
        }
    }

    static void countSort(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i : arr){
            max = Math.max(max, i);
        }

    System.out.println("max: "+max);

        int[] freq = new int[max+1];

        for(int i : arr){
            freq[i]++;
        }

        int idx = 0;
        for(int i =0; i<freq.length; i++){
            while(freq[i]>0){
                arr[idx] = i;
                idx++;
                freq[i]--;
            }
        }

    }
}
