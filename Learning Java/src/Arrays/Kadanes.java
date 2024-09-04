package Arrays;

public class Kadanes {
    // maximum subarray sum or product
    public static void main(String[] args) {
        System.out.println((int)Math.log10(12345)+1);
//        int[] arr = new int[]{1,2,7,-4,3,2,-10,9,1};
//        int[] arr = new int[]{10,20,-30,40,-50,60};
        int[] arr = new int[]{-7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10};
        System.out.println(maximumSubarraySum(arr));

//        int[] nums = {-3,-1,-1};
//        int[] nums = {0,2};
        int[] nums = {3,-1,4};
        System.out.println(maxProduct(nums));

    }

    public static int maxProduct(int[] nums) {
        int maxProd1 = Integer.MIN_VALUE;
        int maxProd2 = Integer.MIN_VALUE;
        int prod = 1;
        for(int i : nums){
            prod = prod==0 ? i: prod*i;
            maxProd1 = Math.max(prod, maxProd1);
            System.out.println("prod1: " + prod + ", max1: " + maxProd1);
        }

        prod = 1;
        for(int i=nums.length-1; i>=0; i--){
            int n = nums[i];
            prod = prod==0 ? n: prod*n;
            maxProd2 = Math.max(prod, maxProd2);
            System.out.println("prod2: " + prod + ", max2: " + maxProd2);
        }

        return Math.max(maxProd1, maxProd2);
    }
    public static long maximumSubarraySum(int []a) {
        // this works properly when negative numbers are part of the array.

        long max_sum = Long.MIN_VALUE;
        long sum = 0;
        for(int i=0; i<a.length; i++){
//this method uses O(n) time
            sum+=a[i];
            max_sum = Math.max(max_sum, sum);
            sum = Math.max(sum,0);
        }

        return Math.max(max_sum,0); // use this if neg values should return 0.
//        return max_sum;   // use this if you want neg results also.


//        long max_sum = Integer.MIN_VALUE;
//this method uses O(n^2) time
//        for(int i=0; i<a.length; i++){
//            long sum = 0;
//            for(int j=i; j<a.length; j++){
//                sum+=a[j];
//                max_sum = Math.max(max_sum, sum);
//            }
//        }
//
//        return Math.max(max_sum,0);
    }
}
