package LinkedLists;

public class driverDLL {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.display();
        list.displayReverse();
        list.deleteFirst();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertLast(10);
        list.display();
        list.displayReverse();
        System.out.println("List size: " + list.size);
        list.showHead();
        list.showTail();
//
        list.display(3);
        list.deleteFirst();
        list.display();
        list.deleteLast();
        list.display();
        System.out.println("List size: " + list.size);
//
        list.insert(6, 0);
        list.display();
        list.displayReverse();
        System.out.println("List size: " + list.size);
        list.showHead();
        list.showTail();
        list.delete(0);
        list.display();
        System.out.println("List size: " + list.size);
        list.showHead();
        list.showTail();
        list.display();
        list.displayReverse();

    }
}
