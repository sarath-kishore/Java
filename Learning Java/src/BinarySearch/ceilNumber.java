package BinarySearch;

import java.util.Arrays;

public class ceilNumber {
    public static void main(String[] args) {
        // input will be sorted.
        int[] arrAll = new int[]{2,3,8,9,14,16,18};
        System.out.println("closest element: " + findCeil(arrAll, 7));

//        char[] charArr = {'c', 'f', 'j'};
        char[] charArr = {'e','e','e','e','e','e','n','n','n','n'};
        System.out.println("closest character: " + nextGreatestLetter(charArr, 'a'));
        System.out.println("closest character: " + nextGreatestLetter(charArr, 'e'));
        System.out.println("closest character: " + nextGreatestLetter(charArr, 'z'));

        int[] FLP = {5,7,7,7,7,8,8,10};
//        System.out.println("indices: " + Arrays.toString(firstAndLastPosition(FLP, 7)));
    }

    static int findPosition(int[] arr, int target, boolean findFirstIndex){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            // floor code. finds the first element smaller than target
            int mid = (low+high) /2;

            if(arr[mid]<target){
                low = mid+1;
            }else if(arr[mid]>target){
                high = mid-1;
            }else if(arr[mid]==target){
                // mid will give us the answer because we are actually looking for the exact element and not greater or smaller than target.
                ans = mid;
                if(findFirstIndex){
                    // since we need the first occurence of the element, we keep moving the high pointer to the left.
                    high = mid-1;
                }else{
                    // since we need the last occurence of the element, we keep moving the low pointer to the right.
                    low = mid+1;
                }
            }
        }

        return ans;
    }
    static int[] firstAndLastPosition(int[] arr, int target){
        // return the 1st and last indices of target element in the array.
        // combination of both ceil and floor, both without the > or < to operation.
        // use 2 binary search -> 2 log(n) time = logn time. ignoring constant.
        // or use the result of 1st search to determine if the 2nd search is needed. if the element doesnt exist,
        // there's no need to waste resources looking for the 2nd index.

        int[] ans = {-1,-1};

        ans[0] = findPosition(arr, target, true);

        if(ans[0]>=0){
            ans[1] = findPosition(arr, target, false);
        }
        return ans;
    }

    static char nextGreatestLetter(char[] arr, char target){
        // return the 1st element in the array that is > target, not equal
        // smallest character that is > target, not equal
        // characters wrap around.
        // lowercase english letters.

        int low=0;
        int high = arr.length-1;

        target = (char) (target % arr[high]);

        while(low<=high){
            int mid = (low+high) / 2;
//            System.out.println("middle element: " + arr[mid]);
//            if(arr[mid]==target){
            // if this condition exists for this problem, it will result in wrong answers in case of duplicate elements in the given array.
//                System.out.println("Element found");
//                return arr[mid+1]; // has to be returned from here, otherwise low and high will not change, and result in infinite loop.
//            }
            if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return arr[low];
    }
    static int findCeil(int[] arr, int target){
        // return the 1st element in the array that is >= target
        // smallest number that is >= target

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

        return arr[low];

    }
}
