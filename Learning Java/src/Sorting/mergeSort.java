package Sorting;

public class mergeSort {
    public static void main(String[] args) {
         int[] arr = new int[]{8, 4, 5, 1, 33, 2, 6, 9};
//        int[] arr = new int[]{2,13,4,1,3,6,28};
        // int[] arr = new int[]{23,4,1,7,3,8,2,1};

        for(int a=0; a<arr.length; a++){
            System.out.print(arr[a] +" ");
        }

        System.out.println();

        mergeSort(arr, 1, arr.length);

        for(int k=0; k<arr.length; k++){
            System.out.print(arr[k] +" ");
        }
    }

    public static void mergeSort(int[] arr, int l, int r){
        // Write your code here
        if(l>=r){
            return;
        }

        int mid = (l+r) / 2;
        mergeSort(arr, l,  mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r ){
        // Write your code here
        int i=l-1, j=mid;
        int[] left = new int[mid-l+1];
        int[] right = new int[r-mid];

        for(int k=0;k<left.length;k++, i++){
            left[k] = arr[i];
        }

        for(int k=0;k<right.length;k++, j++){
            right[k] = arr[j];
        }

        int k = l-1;
        i = 0;
        j = 0;

        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<left.length){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            arr[k] = right[j];
            j++;
            k++;
        }


        for(int a=l-1; a<r; a++){
            System.out.print(arr[a] +" ");
        }
        System.out.println();

    }
}
