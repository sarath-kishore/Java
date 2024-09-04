package LinkedLists;

public class DLL {
    public int size;
    private Node head;
    private Node tail;
    DLL(){
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

        Node target = get(idx);
        target.next.prev = target.prev;
        target.prev.next = target.next;
        size--;
        return;
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

        Node target = get(idx);
        Node node = new Node(val);
        node.next = target;
        node.prev = target.prev;
        target.prev.next = node;
        target.prev = node;
        size++;

    }
    public void deleteFirst(){
        if(head!=null) {
            head = head.next;
            head.prev = null;
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
    public Node get(int idx){
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

        if(head==null)
            tail = node;

        if(head!=null)
            head.prev = node;

        node.next = head;
        head = node;
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        node.prev = tail;
        tail.next = node;
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

    public void displayReverse(){
        Node current = tail;

        while(current!=null){
            System.out.print(current.val + " -> ");
            current = current.prev;
        }
        System.out.println("Start ");
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
        private Node prev;
        Node(int val){
            this.val = val;
        }
    }
}
