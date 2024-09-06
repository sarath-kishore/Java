package Arrays;

import java.util.Arrays;
import java.util.*;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 4, 5, 3, 4, -1};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }

    static int[] maxSlidingWindow(int[] A, int k) {
        // add your logic here
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deq = new ArrayDeque<>();

        int count = 0;
        for(int i =0; i<A.length; i++){
            if(!deq.isEmpty() &&  i - deq.peekFirst() == k)
                deq.pollFirst();

            while(!deq.isEmpty() && A[deq.peekLast()] <= A[i]){
                deq.pollLast();
            }

            deq.offerLast(i);
            count++;

            if(deq.size() > k)
                deq.pollFirst();

            if(count>=k)
                ans.add(A[deq.peekFirst()]);
        }

        int[] result = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            result[i] = ans.get(i);
        }

        return result;
    }
}
