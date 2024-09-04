package subsetsAndSequences;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class subSeq {
    public static void main(String[] args) {
        String t = "12";
System.out.println(Integer.parseInt(t)+1);
        System.out.println(permutations("", "abc"));
        System.out.println(permutationsCount("", "abc"));

        System.out.println("------");
        printSubsetsRecurFor("", "abc", 0);
        System.out.println("------");

        System.out.println("------");
        printSubsetsRecur("", "abc");
        System.out.println("------");


        ArrayList<String> subsets = printSubsetsReturn("", "abcd");
        System.out.println(subsets);
//        for (String element : subsets) {
//            System.out.println(element);
//        }

        printSubsetsIter();
     }

     static int permutationsCount(String p, String up){
        if(up.isEmpty())
            return 1;
        char ch = up.charAt(0);
        int count = 0;
        int n = p.length()+1;
        for(int i=0; i<n; i++){
            String first = p.substring(0, i);
            String last = p.substring(i, p.length());

            count +=  permutationsCount(first + ch + last, up.substring(1));
        }

        return count;
     }

     static ArrayList<String> permutations(String p, String up){
        if(up.isEmpty()){
//            System.out.println(p);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        int n = p.length() + 1;
        char ch = up.charAt(0);

        ArrayList<String> perms = new ArrayList<>();

        for(int i=0; i<n; i++){
            String first = p.substring(0, i);
            String last = p.substring(i, p.length());

            perms.addAll(permutations(first + ch + last, up.substring(1)));
        }

        return perms;
     }

     static void printSubsetsIter(){
        // time complexity: O(n * 2^n); 2^n is the number of subsets.
         // same is the space complexity. there will be n different elements multiplied by 2^n subsets.

         // string begin
//        String str = "abcd";
//
//        List<String> old_ans = new ArrayList<>();
//         old_ans.add("");
//        for(char ch : str.toCharArray()){
//            int n = old_ans.size();
//            for(int i=0; i<n; i++){
//                StringBuilder temp = new StringBuilder(old_ans.get(i));
//                temp.append(ch);
//                old_ans.add(String.valueOf(temp));
//            }
//        }
        //  string end

         // int begin

         int[] arr = {1,2,2};
        List<List<Integer>> old_ans = new ArrayList<>();
        old_ans.add(new ArrayList<>());
        for(int new_element: arr){
            int n = old_ans.size();
            for(int i=0; i<n; i++){
                List<Integer> new_answer = new ArrayList<>(old_ans.get(i));
                new_answer.add(new_element);
                old_ans.add(new_answer);
            }
        }

         // int end

        System.out.println(old_ans);

     }

    static ArrayList<String> printSubsetsReturn(String p, String up){
        // recursive method
        // subset rule -> take something or remove something in each step. (Processed/unprocessed)
        if(up.isEmpty()){
//            System.out.println(p);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        char ch = up.charAt(0);

        ArrayList<String> left =  printSubsetsReturn(p + ch, up.substring(1)); // take something
        ArrayList<String> right = printSubsetsReturn(p , up.substring(1)); // remove something

        left.addAll(right);
        return left;
    }

    static void printSubsetsRecur(String p, String up){
        // recursive method
        // subset rule -> take something or remove something in each step. (Processed/unprocessed)
        // when unrpocessed becomes empty, that's when the processed will have the required answer.
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);


        printSubsetsRecur(p + ch, up.substring(1)); // take something
        printSubsetsRecur(p , up.substring(1)); // remove something
//        printSubsetsRecur(p + (ch + 0), up.substring(1)); // to substitute with ascii value
    }


    static void printSubsetsRecurFor(String p, String str, int start){
        // recursive method uses Forloop
        // subset rule -> take something or remove something in each step. (Processed/unprocessed)
        // when unrpocessed becomes empty, that's when the processed will have the required answer.
//        if(start == str.length()){
            System.out.println(p);
//            return;
//        }

        for(int i = start; i<str.length(); i++){
            char ch = str.charAt(i);
            printSubsetsRecurFor(p + ch, str, i+1);
        }



//        printSubsetsRecur(p + ch, up.substring(1)); // take something
//        printSubsetsRecur(p , up.substring(1)); // remove something
//        printSubsetsRecur(p + (ch + 0), up.substring(1)); // to substitute with ascii value
    }
}
