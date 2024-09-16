package Arrays;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class LongestSubarrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {1 ,2 ,-2 ,4 ,-4}; // out: {2 ,-2 ,4 ,-4}
//        int[] arr = {4, 2, -3, 1, 6,-2,5,-3,1,2,4,-7};
        List< Integer > result = findLargestZeroSumSequence(arr);
        System.out.println(result);
    }

    public static List< Integer > findLargestZeroSumSequence(int[] arr){
        Map<Integer, Integer> map = new HashMap<>(); // prefix sum, index
        int sum = 0;
        int maxLen = -1;
        int lastIdx = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            if(sum == 0) {
                maxLen = i + 1;
                lastIdx = i;
            }
            if(map.containsKey(sum)){
                if(maxLen < i - map.get(sum)){
                    maxLen = i - map.get(sum);
                    lastIdx = i;
                }
            }else{
                map.put(sum, i);
            }
        }

        List< Integer > ans = new ArrayList<>();
        for(int i = lastIdx - maxLen + 1; i<=lastIdx; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}
