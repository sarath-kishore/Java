package LinkedLists;

public class driverLL {
    public static void main(String[] args) {
        LL list = new LL();
//        list.insertLast(1);
//        list.insertLast(2);
//        list.insertLast(3);
////        list.insertLast(2);
//        list.insertLast(1);
////        list.insertLast(1);
//        list.display();
//        list.getMid();
////        list.deleteMid();
//        list.display();
//
//        list.showHead();
//        list.showTail();
//        list.isPalindrome();

        list.insertLast(15);
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertLast(16);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertLast(10);
        list.insertLast(11);
        list.display();
        list.rotateRight(10);
        list.display();
//        list.getMid();
        System.out.println("List size: " + list.size);
        list.showHead();
        list.showTail();


//        list.reverseRecur();
//        list.reverseIter();
////        list.reverseBetween(2,7);
//        list.display();
//        System.out.println("List size: " + list.size);
//        list.showHead();
//        list.showTail();

//        list.display(3);
//        list.deleteFirst();
//        list.display();
//        list.deleteLast();
//        list.display();
//        System.out.println("List size: " + list.size);
//
//        list.insert(6, 2);
//        list.display();
//        System.out.println("List size: " + list.size);
//        list.showHead();
//        list.showTail();
//        list.delete(3);
//        list.display();
//        System.out.println("List size: " + list.size);
//        list.showHead();
//        list.showTail();
//
//        list.insertRecur(8, 0);
//        list.display();
//        System.out.println("List size: " + list.size);
//        list.showHead();
//        list.showTail();
    }
}
