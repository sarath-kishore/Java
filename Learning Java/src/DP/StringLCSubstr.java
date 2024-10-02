package DP;

import java.util.ArrayList;
import java.util.List;

public class StringLCSubstr {
    public static void main(String[] args) {
        String s = "abcad";
        String t = "abzad";
        System.out.println("Longest common substring length: " + LengthLCS(s, t));
        System.out.println("Longest common substring any: " + LongestLCSany(s, t));





////        the following 2 methods and their helpers will not work for Longest Palindromic Substrings
//
//        String ps = "aacabdkacaa"; // consider this case. the reversal of ps would be "aacakdbacaa".
//// here "aaca" even on reversal would remain the same and when "aacabdkacaa" compared with "aacakdbacaa" it will get matched
//// and will return "aaca" as a palindromic substring and longest length as 4. which is obviously wrong.
//// this code with slight modifications would work from substrings, subsequences and palindromic subsequences, but not for palindromic substrings.
//
////        String ps = "aabdb";
//        System.out.println("Longest Palindromic substring length: " + LengthLPS(ps));
//        System.out.println("Longest Palindromic substring any: " + LongestLPSany(ps));
    }

    static List<String> LongestLPSany(String s){
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = LengthLCShelper(s, t);
        return LongestLPSanyHelper(s, t, dp);
    }

    static List<String> LongestLPSanyHelper(String s, String t, int[][] dp){
//        this code will not work for Longest Palindromic Substrings
        int n = s.length();
        int m = t.length();

        int max = -1;
        int[] maxIdx = new int[2];

        for(int idx1=0; idx1<=n; idx1++){
            for(int idx2=0; idx2<=m; idx2++){
                if(max < dp[idx1][idx2]){
                    max = dp[idx1][idx2];
                    maxIdx[0] = idx1;
                    maxIdx[1] = idx2;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int idx1 = maxIdx[0];
        int idx2 = maxIdx[1];
        while(idx1 > 0 && dp[idx1][idx2]>0){
            ans.append(s.charAt(idx1-1));
            if(dp[idx1][idx2] == dp[idx1-1][idx2-1])
                break;
            idx1--;
            idx2--;
        }
        System.out.println("Longest palindromic substring: " + ans.toString());
        // return ans.reverse().toString(); // since this is palindrome, no need to reverse
        List<String> temp = new ArrayList<>();
        temp.add(ans.toString());
        return temp;
    }
    static int LengthLPS(String s){
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = t.length();
        int[][]dp = LengthLCShelper(s, t);
        int max = -1;

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    static List<String> LongestLCSany(String s, String t){
        int[][] dp = LengthLCShelper(s, t);
        return LongestLCSanyHelper(s, t, dp);
    }
    static List<String> LongestLCSanyHelper(String s, String t, int[][] dp){
//        this code will not work for Longest Palindromic Substrings
        int n = s.length();
        int m = t.length();

        StringBuilder str = new StringBuilder();
        List<String> ans = new ArrayList<>();

        int max = -1;

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                max = Math.max(max, dp[i][j]);
            }
        }

        int idx1 = max;
        int idx2 = max;

        while(idx1>0 && idx2>0){
            if(s.charAt(idx1-1) == t.charAt(idx2-1)){
                str.append(s.charAt(idx1-1));
                idx1--;
                idx2--;
            }else if(dp[idx1-1][idx2] > dp[idx1][idx2-1]){
                idx1--;
            }else if(dp[idx1-1][idx2] < dp[idx1][idx2-1]){
                idx2--;
            }else{
                // if(dp[idx1-1][idx2] == dp[idx1][idx2-1])
                // if both previous col and row cells are equal, move to either place.
                idx2--;
            }
        }

//         System.out.println(str.reverse().toString());
        ans.add(str.reverse().toString());

        return ans;

    }

    static int LengthLCS(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = LengthLCShelper(s, t);
        int max = -1;

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    static int[][] LengthLCShelper(String s, String t){
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

//        for(int j=0; j<n; j++){
//            System.out.print("\t" + t.charAt(j) + "\t");
//        }
//        System.out.println();
        for(int idx1 = 1; idx1<=n; idx1++){
//            System.out.print(s.charAt(idx1-1));
            for(int idx2 = 1; idx2<=n; idx2++){
                if(s.charAt(idx1-1) == t.charAt(idx2-1))
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                else
                    dp[idx1][idx2] = 0;

//                System.out.print("\t" + s.charAt(idx1-1) + dp[idx1][idx2] + t.charAt(idx2-1) + "\t");
            }
//            System.out.println();
        }

        return dp;
    }
}
