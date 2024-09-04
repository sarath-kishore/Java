package Arrays;

import java.util.*;
public class arrayTwoSum {

    public static void main(String[] args) {
        // int[] arr = new int[]{1,2,3,4,5,6,7};
        // int[] arr = new int[]{1,2,3,4};
        int[] arr = new int[]{2,7,11,15};
//        int[] arr = new int[]{1,2,3,1,1,1,1};
//        int[] arr = new int[]{8,15,17,0,11};
        int target = 17;
        int[] ans = twoSum(arr, target);
        System.out.println("i: " + ans[0] + " j: " + ans[1]);
    }

    static int[] twoSum(int[] nums, int target){
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int rem = target - nums[i];
            if(hm.containsKey(rem)){
                ans[1] = i;
                ans[0] = hm.get(rem);
                break;
            }
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], i);
            }
        }
        return ans;
    }

}
