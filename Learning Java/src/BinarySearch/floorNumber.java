package BinarySearch;

public class floorNumber {
    public static void main(String[] args) {
        // input will be sorted.

        int[] arrAll = new int[]{2,3,8,9,14,16,18};
        System.out.println("closest element: " + findFloor(arrAll, 7));
    }

    static int findFloor(int[] arr, int target){
        // return the 1st element in the array that is <= target
        // greatest number that is <= target

        int low=0;
        int high = arr.length-1;

        while(low<=high){
            int mid = (low+high) / 2;
//            System.out.println("middle element: " + arr[mid]);
            if(arr[mid]==target){
                System.out.println("Element found");
                return arr[mid]; // has to be returned from here, otherwise low and high will not change, and result in infinite loop.
            }
            if(arr[mid]>target){
                high = mid-1;
            }
            if(arr[mid]<target){
                low = mid+1;
            }
        }

        return arr[high];

    }
}
