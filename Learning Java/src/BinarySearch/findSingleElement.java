package BinarySearch;

public class findSingleElement {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

//        int[] arr = new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6};
        // int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4};
        // int[] arr = new int[]{1, 1, 2, 2, 3};
//        int[] arr = new int[]{1, 2, 2, 3, 3};
        int[] arr = new int[]{1, 2, 3, 2, 1, 4, 3};
        System.out.print(singleNumber3(arr));
//        System.out.print(singleNumber2(arr));
        // System.out.print(singleNumber1(arr));

    }

    public static int singleNumber3(int[] nums) {
        // best solution for unsorted arrays. O(n).
        int single = 0; //any number XOR'd with 0 is the number itself.

        for(int i=0; i<nums.length; i++){
            single = single ^ nums[i];
        }

        return single;
    }
    public static int singleNumber2(int[] nums) {
// uses binary search. most efficient for sorted arrays. O(log n).
        int low = 0;
        int high = nums.length-1;
        while(low!=high){

            int mid = (low + high) / 2;

            if(nums[mid]!=nums[mid+1]){
                if((high-mid) % 2 !=0)
                    low = mid+1;
                else
                    high = mid-2;
            }else if(nums[mid]!=nums[mid-1]){
                if((mid-low) % 2 !=0)
                    high = mid-1;
                else
                    low = mid+2;
            }

        }

        return nums[low];
    }

    public static int singleNumber1(int[] nums) {
        // works only for sorted arrays. O(n). not as efficient as the above.
        int single = -1;
        for(int i=0; i<nums.length-1; ){
            if(nums[i]!=nums[i+1]){
                single = nums[i];
                break;
            }
            i+=2;
        }

        if(single<0)
            single = nums[nums.length-1];
        return single;
    }
}
