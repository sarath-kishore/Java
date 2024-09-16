package Sorting;
import java.util.List;
import java.util.ArrayList;
public class InversionCount {
    public static void main(String[] args) {
//        int[] arr = {2, 4, 1, 3, 5}; //3
//        int[] arr = {2, 3, 4, 5, 6}; //0
//        int[] arr = {10, 10, 10}; //0
        int[] arr = {5,4,3,2,1}; //10

        System.out.println(getInversionCount(arr));
    }
        static int getInversionCount(int[] array) {
            // Add your logic here
            return sort(array, 0, array.length-1);
        }

        static int sort(int[] arr, int l, int r){
            if(l==r)
                return 0;
            int mid = l + (r-l)/2;
            int count = 0;
            count += sort(arr, l, mid);
            count += sort(arr, mid+1, r);
            count += merge(arr, l, mid, r);

            return count;
        }

        static int merge(int[] arr, int l, int mid, int r){
            int i = l;
            int j = mid+1;

            int count = 0;
            List<Integer> temp = new ArrayList<>();

            while(i<=mid && j<=r){
                if(arr[i] > arr[j]){
                    temp.add(arr[j++]);
                    count += (mid - i + 1);
                }
                else{
                    temp.add(arr[i++]);
                }
            }

            while(i<=mid)
                temp.add(arr[i++]);

            while(j<=r)
                temp.add(arr[j++]);

            for(int k=l; k<=r; k++)
                arr[k] = temp.get(k-l);

            return count;
        }
}

//
//    Given an array of integers. Find the Inversion Count in the array.  Two array elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
//
//        Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
//        If an array is sorted in the reverse order then the inversion count is the maximum.