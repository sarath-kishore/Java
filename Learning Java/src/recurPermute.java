import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recurPermute {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3};
//        int[] arr = {1,2,3};
        int[] arr = {3,1,2,4};
        List<List<Integer>> ans = permute(arr);
        for(List<Integer> temp: ans){
            System.out.println(temp.toString());
        }
        System.out.println("-------------------");
        System.out.println(nextPermutation(arr).toString());
    }

    static List<Integer> nextPermutation(int[] nums){
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        List<List<Integer>> allPerms = permute(sorted);
        for(List<Integer> temp: allPerms){
            System.out.println(temp.toString());
        }
        System.out.println("-------------------");
        int current_idx = 0;
        List<Integer> given = new ArrayList<>(Arrays.asList(toIntegerArray(nums)));

        for(int i=0; i<allPerms.size(); i++){
            if(allPerms.get(i).equals(given))
                current_idx = i;
        }

        System.out.println("Current index: "+ current_idx);
        System.out.println("Next index: "+ (current_idx+1)%allPerms.size());
        return allPerms.get((current_idx+1)%allPerms.size());

    }

     static Integer[] toIntegerArray(int[] intArray) {
        Integer[] result = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = intArray[i];
        }
        return result;
    }

    static List<List<Integer>> permute(int[] arr){
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(arr, ds, freq, ans);
        return ans;
    }

    static void findPermutations(int[] arr, List<Integer> ds, boolean[] freq, List<List<Integer>> ans){
        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!freq[i]){
                ds.add(arr[i]);
                freq[i] = true;
                findPermutations(arr, ds, freq, ans);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }

}
