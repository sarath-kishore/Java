package Trie;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxXORofQueries {
    static class Pair implements Comparable<Pair>{
        int el;
        int max;
        int idx;
        Pair(int el, int max, int idx){
            this.el = el;
            this.max = max;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.max, o.max);
        }
    }
    static void maxXORofQueries(){
//        int[] arr = {3, 10, 5, 25, 2, 8};
//        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}}; // out: -1, 3, 3, 1

//        int[] arr = {0,1,2,3,4};
//        int[][] queries = {{3,1},{1,3},{5,6}}; // out: 3, 3, 7

        int[] arr = {5,2,4,6,6,3};
        int[][] queries = {{12,4},{8,1},{6,3}}; // out: 15,-1,5

        PriorityQueue<Pair> pq = new PriorityQueue<>(); // sort the queries in order of max values

        for(int i =0; i<queries.length; i++){
            int[] q = queries[i];
            pq.offer(new Pair(q[0], q[1], i));
        }

        Arrays.sort(arr); // sort elements in order to add the elements in trie based on max value of queries

        XORTrie trie = new XORTrie();

        int[] result = new int[queries.length];

        int i=0;
        while(!pq.isEmpty()){
            Pair query = pq.poll();
            while(i<arr.length && arr[i] <= query.max){
                trie.insert(arr[i]);
                i++;
            }
            if(i>0)
                result[query.idx] = trie.getMax(query.el);
            else
                result[query.idx] = -1;
            // if no elements are lesser than max value of query, it is not possible. so add -1 to the result;
        }

        for(int j=0; j<queries.length; j++){
            System.out.println("For query: " + queries[j][0] + ", " + queries[j][1] + " -> " + result[j]);
        }
    }
}

// Offline queries
//    You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].
//
//        The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.
//
//        Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.