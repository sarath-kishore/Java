package Trie;

public class MaxXORofTwoNumbers {

    static void maxXORofTwoNumbers(){
//        int[] arr = {9,8,1,2,7, 5}; // out: 15
        // to find max XOR of 2 numbers in the same array, use arr in both loops.

        int[]arr1 = {3, 10, 5, 25, 2};
        int[] arr2 = {8, 1, 2, 12, 7}; // out: 30
        // to find max XOR of elements between 2 arrays, use each array in each loop.

        XORTrie trie = new XORTrie();

        for(int i : arr1){
            trie.insert(i);
        }

        int maxXOR = 0;

        for(int i : arr2){
            maxXOR = Math.max(maxXOR, trie.getMax(i));
        }

        System.out.println(maxXOR);
    }
}
