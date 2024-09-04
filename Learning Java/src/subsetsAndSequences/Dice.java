package subsetsAndSequences;
import java.util.*;
public class Dice {
    public static void main(String[] args) {
        System.out.println(dice("", 4, 3));

        int[] arr = {2,3,1};
        System.out.println("Number of subsequences to get target sum: " + countSubseq(arr, "", 3, 0));
    }
    public static List<String> dice(String p, int target, int face){
        if(target==0){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= face && i<=target; i++) {
            ans.addAll(dice(p+i, target-i, face));
        }
        return ans;
    }

    static int countSubseq(int[]arr, String p, int target, int idx){
        if(target==0){
            System.out.println(p);
            return 1;
        }

        if(idx==arr.length || target<0) // this condition will execute when the target sum is never achieved.
            return 0;

        int count=0;

        count += countSubseq(arr, p+arr[idx], target-arr[idx], idx+1);

        // the following IF condition will make the function stop when 1 solution is found.
        if(count > 0)
            return count;

        count += countSubseq(arr, p, target, idx+1);

        return count;
    }
}
