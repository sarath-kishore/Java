package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringLCSubseq {
    public static void main(String[] args) {
        String s = "abaaa";
        String t = "baabaca";
//        String s = "rabbbit";
//        String t = "rabbit";
        System.out.println("Longest length: " + LengthLCS(s, t));
        System.out.println("Longest Subsequence any: " + LongestLCSany(s, t));
        System.out.println("Longest Subsequence All: " + LongestLCSAll(s, t));

//        String ps = "bbbab";
        String ps = "bbabcbcab";
        System.out.println("Longest Palindromic Subsequence length: " + LengthLPS(ps));
        System.out.println("Longest Palindromic Subsequence any: " + LongestLPSany(ps));
    }

    static int LengthLPS(String s){
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = t.length();
        return LengthLCShelper(s, t)[n][m];
    }
    static List<String> LongestLPSany(String s){
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = LengthLCShelper(s, t);
        return LongestLCSanyHelper(s, t, dp);
    }
    static Set<String> LongestLCSAll(String s, String t){
        int[][] dp = LengthLCShelper(s, t);
        int n = s.length();
        int m = t.length();
        List<String> ans = new ArrayList<>();
        LongestLCSAllHelper(s, t, dp, "", n, m, ans);
        System.out.println("printing from LongestLCSAllHelper: " + ans);
        return new HashSet<>(ans); // Set removes duplicates

//        System.out.println("printing from LongestLCSAllHelper2");
//        return new ArrayList<>(LongestLCSAllHelper2(s, t, dp, "", n, m));
    }

    static Set<String> LongestLCSAllHelper2(String s, String t, int[][] dp, String temp, int idx1, int idx2){
        int n = s.length();
        int m = t.length();

//        StringBuilder str = new StringBuilder(temp);
        if(idx1==0 || idx2==0){
            Set<String> set = new HashSet<>();
            set.add(new StringBuilder(temp).reverse().toString());
            return set;
        }

        Set<String> ans = new HashSet<>();

        if(s.charAt(idx1-1) == t.charAt(idx2-1)){
            ans.addAll(LongestLCSAllHelper2(s, t, dp, (temp + s.charAt(idx1-1)), idx1-1, idx2-1));
        }else if(dp[idx1-1][idx2] > dp[idx1][idx2-1]){
            ans.addAll(LongestLCSAllHelper2(s, t, dp, temp, idx1-1, idx2));
        }else if(dp[idx1-1][idx2] < dp[idx1][idx2-1]){
            ans.addAll(LongestLCSAllHelper2(s, t, dp, temp, idx1, idx2-1));
        }else{
            // if(dp[idx1-1][idx2] == dp[idx1][idx2-1])
            // if both previous col and row cells are equal, move to all places.
            ans.addAll(LongestLCSAllHelper2(s, t, dp, temp, idx1-1, idx2));
            ans.addAll(LongestLCSAllHelper2(s, t, dp, temp, idx1, idx2-1));
        }

        return ans;
    }


    static void LongestLCSAllHelper(String s, String t, int[][] dp, String temp, int idx1, int idx2, List<String> ans){
        int n = s.length();
        int m = t.length();

//        StringBuilder str = new StringBuilder(temp);
        if(idx1==0 || idx2==0){
            ans.add(new StringBuilder(temp).reverse().toString());
            return;
        }

        if(s.charAt(idx1-1) == t.charAt(idx2-1)){
            LongestLCSAllHelper(s, t, dp, (temp + s.charAt(idx1-1)), idx1-1, idx2-1, ans);
        }else if(dp[idx1-1][idx2] > dp[idx1][idx2-1]){
            LongestLCSAllHelper(s, t, dp, temp, idx1-1, idx2, ans);
        }else if(dp[idx1-1][idx2] < dp[idx1][idx2-1]){
            LongestLCSAllHelper(s, t, dp, temp, idx1, idx2-1, ans);
        }else{
            // if(dp[idx1-1][idx2] == dp[idx1][idx2-1])
            // if both previous col and row cells are equal, move to all places.
            LongestLCSAllHelper(s, t, dp, temp, idx1-1, idx2, ans);
            LongestLCSAllHelper(s, t, dp, temp, idx1, idx2-1, ans);
        }

        return;
    }

    static List<String> LongestLCSany(String s, String t){
        int[][] dp = LengthLCShelper(s, t);
        return LongestLCSanyHelper(s, t, dp);
    }
    static List<String> LongestLCSanyHelper(String s, String t, int[][] dp){
        int n = s.length();
        int m = t.length();

        StringBuilder str = new StringBuilder();
        List<String> ans = new ArrayList<>();
         int idx1 = n;
         int idx2 = m;

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
        return LengthLCShelper(s, t)[n][m];
    }
    static int[][] LengthLCShelper(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][]dp = new int[n+1][m+1];

        for(int idx1=1; idx1<=n; idx1++){
            for(int idx2=1; idx2<=m; idx2++){
                if(s.charAt(idx1-1) == t.charAt(idx2-1)){
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                }else
                    dp[idx1][idx2] = 0 + Math.max(dp[idx1][idx2-1], dp[idx1-1][idx2]);
            }
        }

        return dp;
    }
}
