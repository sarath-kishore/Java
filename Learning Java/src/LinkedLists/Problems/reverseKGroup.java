package LinkedLists.Problems;

import java.util.List;

public class reverseKGroup {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ListNode head = new ListNode();
        ListNode prev = head;
        for(int i: arr){
            ListNode curr = new ListNode(i);
            prev.next = curr;
            prev = curr;
        }
        head = head.next;


//        ListNode curr = head;
//        while(curr != null){
//            System.out.print(curr.val + "\t");
//            curr = curr.next;
//        }
//        System.out.println();


        int k = 5;
        ListNode newHead = new reverseKGroup().new Solution().reverseKGroup(head, k);

        while(newHead != null){
            System.out.print(newHead.val + "\t");
            newHead = newHead.next;
        }
    }
//      Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // add your logic here
            if(k <= 1 || head == null)
                return head;

            ListNode ans = head;
            ListNode curr = head;
            ListNode lastTail = null;

            while(curr != null){
                ListNode prev = null;
                ListNode next = null;

                ListNode currHead = curr;
                ListNode currTail = getTail(curr, k);

                if(currTail != null){
                    ListNode ender = currTail.next;

                    while(curr!=null && curr != ender){
                        next = curr.next;
                        curr.next = prev;
                        prev = curr;
                        curr = next;
                    }

                    if(lastTail!=null)
                        lastTail.next = currTail;
                    lastTail = currHead;


                    if(ans == head)
                        ans = currTail;

                }else{
                    if(lastTail!=null)
                        lastTail.next = currHead;
                    break;
                }
            }

            return ans;
        }


        ListNode getTail(ListNode head, int k){
            int count = 0;
            ListNode prev = null;
            while(count < k && head!=null){
                prev = head;
                head = head.next;
                count++;
            }

            if(count == k)
                return prev;

            return null;
        }

    }
}
