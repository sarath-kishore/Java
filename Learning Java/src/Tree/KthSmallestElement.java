//package Tree;
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//public class KthSmallestElement {
//    private int ans;
//    private int k;
//    public int kthSmallest(TreeNode root, int k) {
//        ans = 0;
//        this.k = k;
//        helper(root);
//        return ans;
//        // PriorityQueue<Integer> heap = new PriorityQueue<>();
//        // helper(root, heap);
//
//        // for(int i=0; i<k-1; i++){
//        //     heap.poll();
//        // }
//        // return heap.poll();
//    }
//    // void helper(TreeNode node, PriorityQueue<Integer> heap){
//    void helper(TreeNode node){
//        if(node==null)
//            return;
//
//        // helper(node.left, heap);
//        // heap.offer(node.val);
//        // helper(node.right, heap);
//
//        helper(node.left);
//        k--;
//        if(k==0)
//            ans = node.val;
//        helper(node.right);
//    }
//
//}
