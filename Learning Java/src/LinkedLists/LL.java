package LinkedLists;

public class LL {
    int size;
    private Node head;
    private Node tail;
    LL(){
        this.size = 0;
    }

    public void showHead(){
        System.out.println("Head: "+ head.val);
    }
    public void showTail(){
        System.out.println("Tail: "+ tail.val);
    }
    public void delete(int idx){
        if(idx >= this.size)
        {
            System.out.println("Index out of bounds. ");
            return;
        }
        if(idx == 0){
            deleteFirst();
            return;
        }

        if(idx == size-1){
            deleteLast();
            return;
        }

        Node target = get(idx-1); // get the previous element, because in singly LL we can't know the previous element.
        target.next = target.next.next;
        size--;
        return;
    }

    public void reorderList(Node head) {
        Node mid = getMid(head);
        Node rightHead = reverseList(mid);
        Node leftHead = head;
        Node leftNext = leftHead.next;
        Node rightNext = rightHead.next;

        while(leftNext!=null && rightNext!=null){
            leftHead.next = rightHead;
            rightHead.next = leftNext;
            leftHead = leftNext;

            leftNext = leftNext.next;

            rightHead = rightNext;
            rightNext = rightNext.next;

        }


    }

    public Node rotateRight(int k) {
        if(head==null || head.next==null){
            return head;
        }

        Node current = head;

        k = k%size;

        if(k<1){
            return head;
        }

        head = reverseList(head);
        int count=0;
        Node prev = null;
        current = head;
        Node next = current==null ? null : current.next;
        Node newLeftTail = head;



        while(count<k){
            current.next = prev;
            prev = current;
            current = next;
            next = next==null ? null : next.next;

            count++;
        }

        head = prev;
        newLeftTail.next = reverseList(current);

        return head;
    }
    public Node reverseList(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = head.next;

        while(current!=null){
            current.next = prev;
            prev = current;
            current = next;
            next = (next!=null) ? next.next : null;
        }
        return prev; // returns new head;
    }

    public boolean isPalindrome(){


        Node mid = getMid(head);
//        mid = isEven ? mid.next: mid;


        Node first = head;
        Node second = reverseList(mid);

        while(first!=null && second!=null){
            if(first.val != second.val){
                System.out.println("Not a palindrome");
                return false;
            }
            first = first.next;
            second = second.next;
        }
        System.out.println("It is a palindrome");
        return true;
    }
    public void reverseBetween(int left, int right){
        if(head==null || head.next == null){
//            return head;
            return;
        }

        int count = 1;
        Node current = head;
        Node prev = null;

        while(count<left){
            prev = current;
            current = current.next;
            count++;
        }

        Node leftPrev = prev; // this is the element before the left position
        Node newTail = current; // this is the element at the left position

        prev = current;
        current = current!=null ? current.next : null;
        Node next = current!=null ? current.next : null;


        count++; // incrementing because, in the below loop we are iterating till <= right.
        // right is also included in the reversal.
        // when exiting the above loop, count will be at the position of left.

        while(count<=right){
            current.next = prev;
            prev = current;
            current = next;
            next = next!=null ? next.next : null;

            count++;
        }

        Node rightNext = current; // this is the element next to the right position
        Node newHead = prev; // this is the element at the right position

        if(leftPrev!=null)
            leftPrev.next = newHead;
        else
            head = newHead;

        newTail.next = rightNext;
        if(rightNext==null)
            tail = newTail;
    }
    public void reverseIter(){
        if(head==null || head.next == null){
//            return head;
            return;
        }
        Node prev = null;
        Node current = head;
        Node next = head.next;
        tail = head;
        while(current!=null){
            current.next = prev;
            prev = current;
            current = next;
            next = next!=null ? next.next : null;
        }
        head = prev;
    }

    public void reverseRecur(){
        reverseRecur(head);
    }

    private void reverseRecur(Node current){
    // this method requires tail pointer for base condition.

        if(current == tail){
            head = tail;
            return;
        }

        reverseRecur(current.next);
        tail.next = current;
        tail = current;
        tail.next = null;
    }

    public void deleteMid(){
        Node midPrev = getMidPrev(head);
        if(midPrev!=null)
            midPrev.next = midPrev.next.next;
        else
            head = null; // if there's only 1 element in the list,  removing the mid will empty out the list.
    }
    public Node getMidPrev(Node head){
        Node slow = head;
        Node fast = head;
        Node midPrev = null;
        while(fast!=null && fast.next!=null){
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return midPrev;
    }

    public Node getMid(){
        return getMid(head);
    }
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head;
        Node midPrev = head;
        while(fast!=null && fast.next!=null){
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

//         if fast==null, it is even.
//        Node mid = (fast==null) ? midPrev : slow;
        Boolean isEven = (fast==null);
        System.out.println("Middle node: " + slow.val + " isEven: " + isEven);
        return slow;
    }

    private Node insertRecur(int val, int idx, Node current){
        // useful method when tail is not given or size is unknown.
       if(current==null && idx!=0){
           System.out.println("Index out of bounds");
           return current;
       }
       if(idx == 0){
           Node temp = new Node(val, current);
           size++;
           return temp;
       }

       current.next = insertRecur(val, --idx, current.next);
       return current;
    }
    public void insertRecur(int val, int idx){
        System.out.println("val: "+ val + " idx: " + idx);
        head = insertRecur(val, idx, head);
    }

    public void insert(int val, int idx){
        System.out.println("val: "+ val + " idx: " + idx);

        if(idx > this.size)
        {
            System.out.println("Index out of bounds. ");
            return;
        }

        Node current = head;

        if(idx == 0) {
            insertFirst(val);
            return;
        }
        if(idx == size) {
            insertLast(val);
            return;
        }

        Node target = get(idx-1); // get the previous element, because in singly LL we can't know the previous element.
        Node node = new Node(val);
        node.next = target.next;
        target.next = node;
        size++;

    }
    public void deleteFirst(){
        if(head!=null) {
            head = head.next;
            size--;
        }
    }

    public void deleteLast(){
        Node current = head;

        while(current.next.next!=null){
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;

    }
    private Node get(int idx){
        int i=0;
        Node current = head;
        while(current!=null){
            if(i == idx){
                return current;
            }
            current = current.next;
            i++;
        }
        return null;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        if(head==null){
            tail = node;
        }
        node.next = head;
        head = node;
        size++;

    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(tail == null){
            head = node;
        }else{
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void display(){
        Node current = head;

        while(current!=null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("End ");
    }

    public void display(int idx){
        Node node = get(idx);
        if(node!=null) {
            System.out.println("Element at given index: " + node.val);
        }else{
            System.out.println("Index out of bound");
        }
    }
    private class Node {
        private int val;
        private Node next;
        Node(int val){
            this.val = val;
        }
        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
