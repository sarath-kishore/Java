package Tree;
import java.util.* ;

// https://www.naukri.com/code360/problems/verify-preorder-sequence-in-binary-search-tree_1281309?leftPanelTabValue=PROBLEM
public class ValidateBSTpreorder {
    public static boolean isBSTPreorder(int[] arr) {
        // Write your code here.
        int min = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int item : arr){
            if(item < min)
                return false;
            while(!st.isEmpty() && item > st.peek()){
                min = st.pop();
            }
            st.push(item);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {40, 30, 35, 80, 100};
//        int[] arr = {5, 2, 3, 1, 7, 8};
        System.out.println(isBSTPreorder(arr));
    }
}
