package BinarySearch;
import java.util.Arrays;
public class MaximizeMinimum {
    public static void main(String[] args) {
//        int[] heights = {13,5,1,8,21,2}; int k = 3;
        int[] heights = {1,3,1}; int k = 2;

        System.out.println(solve(heights, k));
    }

    static int solve(int[] arr, int k){
        int ans = 0;
        int l = 0;
        Arrays.sort(arr);
        int r = arr[arr.length-1];

        while(l<=r){
            int mid = l + (r-l)/2;
            if(canClimb(arr, mid, k)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }

    static boolean canClimb(int[] arr, int minDiff, int k){
        int count = 1;
        int lastHeight = arr[0];

        for(int i : arr){
            if(i - lastHeight >= minDiff){
                lastHeight = i;
                count++;
            }
            if(count == k)
                return true;
        }
        return false;
    }
}



//
//    Problem Statement:
//
//        You are given n mountains in a linear order, represented by an array height of length n, where height[i] denotes the height of the mountain at position i. You are also given an integer k, which represents the number of mountains you need to climb.
//
//        You must climb exactly k mountains in increasing order, meaning the height of each subsequent mountain you climb must be greater than or equal to the previous one. The points you earn when climbing are calculated as the absolute difference between the heights of consecutive mountains you climb.
//
//        Your task is to maximize the minimum point earned after climbing the k mountains, i.e., you want to maximize the smallest difference among all the points you earned during the climb.
//
//        Constraints:
//
//        2 ≤ k ≤ height.length ≤ 10^5
//        1 ≤ height[i] ≤ 10^9
//
//        Example Test Cases:
//
//        Example 1:
//        Input: heights = [13, 5, 1, 8, 21, 2], k = 3
//        Output: 8
//        Explanation: Choose the mountains with the heights [5, 13, 21]. The points earned by climbing are: |5 - 13| = 8, |13 - 21| = 8, and |5 - 21| = 16. The minimum of these points is min(8, 8, 16) = 8, which is the maximum possible minimum point that can be achieved.
//
//        Example 2:
//        Input: heights = [1, 3, 1], k = 2
//        Output: 2
//        Explanation: Choose the mountains with the heights [1, 3]. The points earned are |1 - 3| = 2. So, the maximum minimum point that can be achieved is 2.
//
//        The objective is to find the optimal sequence of mountains to climb such that the minimum point difference is as large as possible after climbing exactly k mountains.