package BinarySearch;

public class binarySearch {
    public static void main(String[] args) {

        int[] arrAll = new int[]{0,1,2,5,6,7};
        System.out.println("finite array element index: " + bs(arrAll, 5, 0, arrAll.length-1));

        int[] arrDesc = new int[]{7,6,5,2,1,0};
        System.out.println("desc finite array element index: " + orderAgnosticBS(arrDesc, 3, 0, arrAll.length-1));


        int[] infArr = {1,2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,18,19};
        System.out.println("infinite array, element index: " + bs_infinite(infArr, 2));
    }

    static int bs(int[] arr, int target, int low, int high){

        while(low<=high){
            int mid = (low+high) / 2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                high = mid-1;
            }
            if(arr[mid]<target){
                low = mid+1;
            }
        }

        return -1;
    }

    static int orderAgnosticBS(int[] arr, int target, int low, int high){

        boolean isAsc = arr[low] < arr[high];

        while(low<=high){
            int mid = (low+high) / 2;
            if(arr[mid]==target){
                return mid;
            }

            if(isAsc){
                if(arr[mid]>target){
                    high = mid-1;
                }else if(arr[mid]<target){
                    low = mid+1;
                }
            }else{
                if(arr[mid]<target){
                    high = mid-1;
                }else if(arr[mid]>target){
                    low = mid+1;
                }
            }

        }

        return -1;
    }

    static int bs_infinite(int[] arr, int target){
        // this assumes that the high index will never go out of bounds for the array, since it is infinite.
        // for test purposes, do not use a target that is outside the upper bound of given array.
        // will still result in logn time only.
        // bs will take 1 logn. in order to find the bounds, we are doubling the high pointer,
        // basically the reverse of binary tree, (in bs we keep dividing, here we keep doubling the range, bottom to top,
        // but the number of steps remain the same). hence finding the bounds takes 1 logn time.
        // total 2 logn time, which is equal to logn.
        int low = 0;
        int high = 4;

        while(arr[high]<target){
            low = high+1;
//            high = high + (2 * (high-low+1)); //doubling the current box size (+1 because of 0 indexing)
            high = high * 2;
        }

        return bs(arr, target, low, high);
    }
}
