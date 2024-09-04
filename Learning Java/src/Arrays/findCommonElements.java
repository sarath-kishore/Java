package Arrays;

import java.util.*;

public class findCommonElements {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        int[] A = new int[]{3, 8, 5, 8, 5, 3, 5, 10, 9, 1, 7, 5, 6, 0, 10, 7, 10, 2, 1, 0, 3, 9, 4, 6, 0, 3, 8, 5, 7, 4, 0, 3, 5, 8, 5, 7, 0, 9, 9, 6, 1, 0, 2, 2, 5, 1, 5, 0, 4 };
        int[] B = new int[]{10, 10, 6, 1, 5, 2, 10, 0, 8, 0, 6, 10, 3 };
        findIntersection(A, B);
    }

    public static void findIntersection(int[] A, int[] B) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<A.length; i++){
            hs.add(A[i]);
        }

        for(int i=0; i<B.length; i++){
            if(hs.contains(B[i])){
                System.out.print(B[i] + " ");
            }
        }
    }
}
