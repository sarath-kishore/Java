package BinarySearch;

public class findPeakElement {
    public static void main(String[] args) {

//        int[] arrAll = new int[]{7, 2 ,5, 10, 8};
        int[] arrAll = new int[]{1,2,1,3,5,6,4};
//        int[] arrAll = new int[]{1,2};
//        int[] arrAll = new int[]{1};
//        int[] arrAll = new int[]{6,5,4,3,2,3,2};
//        int[] mountArr = new int[]{1,2,3,4,5,3,1};
        int[] mountArr = new int[]{0,1,2,4,2,1};
        System.out.println("peak index: " + findPeak(arrAll, 0, arrAll.length-1));
        System.out.println("search in montain: " + findInMountain(mountArr, 4));

    }

    static int findInMountain(int[] arr, int target){
        // assumes there's only 1 mountain in the given array
        int ans = -1;
        int low = 0;
        int high = arr.length-1;

        int peak = findPeak(arr, low, high);
        ans = orderAgnosticBS(arr, target, low, peak);
//        System.out.println("ans: " + ans + " low: " + low + " peak: " + peak);

        if(ans>=0){
            return ans;
        }

        low = peak +1;
        return orderAgnosticBS(arr, target, low, high);
    }



    static int findPeak(int[] arr, int low, int high){

        while(low<high){ // low<high and not low<=high. because we are not going to be checking the same element,
            // and we also need to check the mid element with the next one, so if low==high, and we're at the last element,
            // then comparing with mid+1 would go out of bounds.

            int mid = (low+high) / 2;

            if(arr[mid]>arr[mid+1]){
                // you are in the decrementing part of the array
                // this could be the ans, but look at the left.
                // this is why high != mid-1;
                high = mid;
            }else{
                // you are in the ascending part of the array.
                // because we know that the mid+1 > mid element.
                low = mid+1;
            }
        }

        return low; // or return high, as both will be equal at this point,
                    // because that is the stopping condition for the while loop
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
}
