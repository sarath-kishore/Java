package Tree.BalancedTrees.AVL2;
import Tree.BalancedTrees.Tree;

public class App {
    public static void main(String[] args) {

//        Tree avlTree = new AVLTree();
//        avlTree.insert(10).insert(2).insert(6).insert(8).insert(25).insert(18).insert(35).insert(15).insert(22).insert(42)
//                .insert(30).insert(40).insert(12).insert(17).insert(19).insert(24).insert(28).insert(33).insert(38);
//
//        avlTree.traverse();
//
//        System.out.println("Max is: " + avlTree.getMax());
//        System.out.println("Min is: " + avlTree.getMin());
//
//        System.out.println("Deleting 42 from Tree");
//        avlTree.delete(42);
//
//        System.out.println("New Max is: " + avlTree.getMax());
//        avlTree.traverse();
//
//        System.out.println("Deleting 10 from Tree");
//        avlTree.delete(10);
//
//        System.out.println("New Max is: " + avlTree.getMax());
//
//        avlTree.traverse();



        Tree avlTree = new AVLTree();
//        avlTree.insert(10).insert(20).insert(30).insert(40).insert(50); // ascending
//        avlTree.insert(50).insert(40).insert(30).insert(20).insert(10); //descending
//        avlTree.insert(30).insert(10).insert(20); // LR
//        avlTree.insert(10).insert(30).insert(20); // RL
//        avlTree.insert(10).insert(20).insert(10); // duplicates

        avlTree.traverse();
        System.out.println("Max is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());
    }
}
