package LinkedLists;
//cyclic LL
public class CLL {
    private Node head;
    private Node tail;
    CLL(){
        this.head = null;
        this.tail = null;
    }

    public void showHead(){
        System.out.println("Head: "+ head.val);
    }
    public void showTail(){
        System.out.println("Tail: "+ tail.val);
    }


    public void insert(int val){
        Node node = new Node(val);
        if(head==null){
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        tail.next = node;
        tail = node;
        return;
    }

    public void delete(int val)
    {
        if(head == null){
            return;
        }

        Node current = head;

        if(current.val == val){
            head = current.next;
            tail.next = head;
            return;
        }

        do{
            if(current.next.val == val){
                if(current.next == tail){
                    tail = current;
                }

                current.next = current.next.next;
                return;
            }
            current = current.next;
        }while(current!=head);
    }

    public void display(){
        Node current = head;
    if(current!=null) {
        do {
            System.out.print(current.val + " -> ");
            current = current.next;
        } while (current != head);
    }
        System.out.println("End ");
    }
    private class Node{
        private int val;
        private Node next;

        Node(int val){
            this.val = val;
        }

    }
}
