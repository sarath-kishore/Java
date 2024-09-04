package Arrays;

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

//        int[] arr = new int[]{1,2,3,1,1,1,1};
//        int[] arr = new int[]{8,15,17,0,11};
        int[] arr = new int[]{1,2,3,4,0,5,6,7,8};
//        int[] arr = new int[]{1,-1,1};
        int k = 1;

//        int[] arr = new int[]{100000, -999812, -218}; int k = 0; //doesn't work with this code. expected output: 0
        System.out.println(longestSubarrayWithSumK(arr, k));
    }

    public static int longestSubarrayWithSumK(int []a, long k) {
        // this doesn't work properly when negative numbers are part of the array.
        // reason: when the sum of neg + pos numbers become 0 the index will not be updated and hence the range will be wrong.
        int max_len = 0;
        long sum=0;

        for(int i=0, j=0; j<a.length; j++){
            sum+=a[j];
            while(i<=j && sum>k){
                sum-=a[i];
                i++;
            }

            if(sum==k){
                max_len = Math.max(max_len, j-i+1); //here, we are adding 1 to the difference between j-i because, we need to count the i'th element as well.
                                                    // the sum is given by the subarray of elements from i to j including i'th element.
            }
        }
        return max_len;
    }
}
