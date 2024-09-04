package Arrays;

import java.util.*;
public class longestSubarrayWithSumK_neg_pos {

    public static void main(String[] args) {
//        System.out.println("Hello, World!");

//        int[] arr = new int[]{1,2,3,1,1,1,1};
//        int[] arr = new int[]{8,15,17,0,11};
        int[] arr = new int[]{1,2,3,4,0,5,6,7,8};
//        int[] arr = new int[]{1,-1,1}; //expected output: 3
        int k = 10;
//        int[] arr = new int[]{100000, -999812, -218}; int k = 0; //expected output: 0
        System.out.println(longestSubarrayWithSumK(arr, k));
    }

    public static int longestSubarrayWithSumK(int []a, long k) {
        // this works properly when negative numbers are part of the array.
        int max_len = 0;
        long sum=0;

        HashMap<Long, Integer> hm = new HashMap<>();


        for(int i=0; i<a.length; i++){
            sum+=a[i];
            long rem = sum-k;
            if(hm.containsKey(rem)) {
                max_len = Math.max(max_len, (i - hm.get(rem)));
                //here, we don't add 1 to the difference between i-hm.get(rem)
                //because, we dont need to count the hm.get(rem)'th element.
                //the sum is given by sub array of elements starting after the hm.get(rem)'th element.
            }

            if(sum==k){
                max_len = Math.max(max_len, (i + 1));
            }

            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            }

        }
        return max_len;
    }


}
