package subsetsAndSequences;
import java.util.*;

public class numberPad {
    public static void main(String[] args) {
        System.out.println(letterCombinations("29"));
        System.out.println(countLetterCombinations("29"));
    }

    public static int countLetterCombinations(String digits) {
        if(digits.isEmpty())
            return 0;
        return countCombinations("", digits);
    }

    public static int countCombinations(String p , String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        String str = hm.get(ch);
        int ans = 0;
        for(int i=0; i<str.length(); i++){
            char s = str.charAt(i);
            ans += countCombinations(p+s, up.substring(1));
        }

        return ans;
    }

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if(digits.isEmpty())
            return ans;
        return combinations("", digits);
    }

    public static List<String> combinations(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        char ch = up.charAt(0);
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        String str = hm.get(ch);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            char s = str.charAt(i);
            ans.addAll(combinations(p+s, up.substring(1)));
        }

        return ans;
    }

}
