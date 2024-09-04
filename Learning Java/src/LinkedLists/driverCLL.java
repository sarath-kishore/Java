package LinkedLists;

public class driverCLL {
    public static void main(String[] args) {
        CLL list = new CLL();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();
        list.showHead();
        list.showTail();

        list.delete(5);
        list.display();
        list.showHead();
        list.showTail();

        list.delete(1);
        list.display();
        list.showHead();
        list.showTail();
    }
}
