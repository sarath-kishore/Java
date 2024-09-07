package TwoPointer;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeat("pwwkew")); //3
        System.out.println(longestSubstringWithoutRepeat("bbbbb")); //1
        System.out.println(longestSubstringWithoutRepeat("abcabcbb")); //3
    }
    static int longestSubstringWithoutRepeat(String s) {
            // add your logic here
//            return better(s);
             return best(s);
        }

        static int better(String s){
//        time: O(2n)
            HashSet<Character> set = new HashSet<>();
            int max = -1;

            for(int l=0, r=0; r<s.length(); r++){
                char ch = s.charAt(r);
                while(set.contains(ch)){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(ch);
                max = Math.max(max, r-l+1);
            }

            return max;
        }

        static int best(String s){
//        time: O(n)
            Map<Character, Integer> map = new HashMap<>();
            int max = -1;
            for(int l=0, r=0; r<s.length();r++){
                char ch = s.charAt(r);
                if(map.containsKey(ch))
                    l = Math.max(l, map.get(ch)+1);

                map.put(ch, r);
                max = Math.max(max, r-l+1);
            }

            return max;
        }
}
