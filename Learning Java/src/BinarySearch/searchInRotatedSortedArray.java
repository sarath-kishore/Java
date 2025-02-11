package BinarySearch;

public class searchInRotatedSortedArray {
    public static void main(String[] args) {
//        int[] arrAll = new int[]{4,5,6,7,0,1,2};  // 3
//        int[] arrAll = new int[]{5,6,7,0,1,2,4}; // 2
//        int[] arrAll = new int[]{4,5,1,2,3}; // 1
//        int[] arrAll = new int[]{1,2,4,5,6,7,0}; // 5
//        int[] arrAll = new int[]{0,1,2,4,5,6,7}; // 6
//        int[] arrAll = new int[]{11,13,15,17}; // 3
//        int[] arrAll = new int[]{2,5,6,0,0,1,2};
//        int[] arrAll = new int[]{1,0,1,1,1};
//        int[] arrAll = new int[]{2,2,2,9,2};
//        int[] arrAll = new int[]{1};
        int[] arrAll = new int[]{1,3,3};
        System.out.println("pivot: " + findPivot(arrAll));
//        System.out.println("rotation count: " + countRotations(arrAll));
//        System.out.println("element index: " + findElement(arrAll, 0));
    }

    static int countRotations(int[] arr){
        return (findPivot(arr) + 1) % arr.length;
    }
    static int findElement(int[] arr, int target){
        int pivot = findPivot(arr);
        int ans = bs(arr, target, 0, pivot);  // left part of the array.
        if(ans<0 && pivot+1!=arr.length){
            ans = bs(arr, target, pivot+1, arr.length-1);
        }
        return ans;
    }

    static int findPivot2(int[] arr){
        int l = 0;
        int r = arr.length-1;
//11,13,15,17
        while(l<r){
            int mid = l + (r-l)/2;

            if(mid<r && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid] < arr[mid-1])
                return mid-1;
            else if(arr[l] <= arr[mid]){
                l = mid+1;
            }else { //if(arr[l] > arr[mid])
// there has to be a default else statement, in case there is only one element at last and mid = l = r;
// we need this block to make sure the bounds get updated and loop breaks.
// this is incase we use l<=r as loop condition.
                r = mid-1;
            }

            System.out.println(mid + " | " + l + " | " + r);
        }

        return l;
    }

    static int findPivot(int[]arr){
        // returns pivot index
        if(arr.length==1){
            return 0;
        }
        int low = 0;
        int high = arr.length-1;

        while(low<high){ // low<high and not <= because we need to compare mid with mid+1.
            int mid= (low+high) / 2;
            if(arr[mid]>arr[mid+1]){ // 4,5,6,7,0,1,2
                return mid;
            }else if(arr[mid]<arr[low]){  // 6,7,0,1,2,4,5
                high = mid-1;
            }else if(arr[mid]>arr[high] || arr[mid]>arr[low]){
                // 1,2,4,5,6,7,0 if(arr[mid]>arr[high]) or if(arr[mid]>arr[low])
                // mid is anyway not the pivot, as checked by the 1st if statement.
                low = mid+1;
            }else if(arr[mid]==arr[low]){ // if mid and start are duplicates
                if(arr[low]>arr[low+1]){
                    return low;
                }
                low = low+1;
            }else if(arr[mid]==arr[high]){ // if mid and end are duplicates
                if(arr[high]<arr[high-1]){
                    return high;
                }
                high = high-1;
            }
        }

        return low;
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
}
