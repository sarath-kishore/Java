package DP;

public class StringLPSubstr {
    public static void main(String[] args) {
//        String ps = "aacabdkacaa";
        String ps = "babad";
        System.out.println("Longest Palindromic substring : " + brute(ps));
        System.out.println("Longest Palindromic substring : " + optimal(ps));
    }
    static String optimal(String s){
        // time: (n^2)
        String[] res = {""};
        int maxLen = -1;
        for(int ctr=0; ctr<s.length(); ctr++){ // middle pointer
            // check odd palindromes
            int l = ctr;
            int r = ctr;
            findPalin(s, l, r, res); //odd length

            // check even palindromes
            l = ctr;
            r = ctr+1;
            findPalin(s, l, r, res); //even length

            // if(odd.length() > even.length()){
            //     res = odd;
            // }else{
            //     res = even;
            // }
        }

        return res[0];
    }

    static void findPalin(String s, int l, int r, String[] res){
        int maxLen = res[0].length();
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            int len = r-l+1;
            if(len > maxLen){
                maxLen = len;
                res[0] = s.substring(l, r+1);
            }
            l--;
            r++;
        }
        return;
    }

    static String brute(String s){
        // time: (n^3)
        String ans = "";
        int maxLen = -1;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(isPalindrome(s.substring(i, j+1)) && j-i+1>maxLen){
                    maxLen = j-i+1;
                    ans = s.substring(i, j+1);
                }
            }
        }

        return ans;
    }

    static boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}
