//package BFS;
//
//public class ZigZag_traversal {
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//    class Solution {
//        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//            List<List<Integer>> ans = new ArrayList<>();
//
//
//            Deque<TreeNode> deque = new ArrayDeque<>();
//            if(root!=null)
//                deque.addLast(root);
//
//            while(!deque.isEmpty()){
//
//                List<Integer> temp = new ArrayList<>();
//                int size = deque.size();
//                int i = 0;
//                while(i<size){
//                    TreeNode node = deque.pollLast();
//                    System.out.println("LTR: " + node.val);
//                    temp.add(node.val);
//                    if(node.left!=null)
//                        deque.addFirst(node.left);
//                    if(node.right!=null)
//                        deque.addFirst(node.right);
//                    i++;
//                }
//                if(temp.size()>0)
//                    ans.add(temp);
//                List<Integer> temp2 = new ArrayList<>();
//                size = deque.size();
//                i = 0;
//                while(i<size){
//                    TreeNode node = deque.pollFirst();
//                    System.out.println("RTL: " + node.val);
//                    temp2.add(node.val);
//                    if(node.right!=null)
//                        deque.addLast(node.right);
//                    if(node.left!=null)
//                        deque.addLast(node.left);
//                    i++;
//                }
//                if(temp2.size()>0)
//                    ans.add(temp2);
//            }
//
//            return ans;
//        }
//    }
//}
