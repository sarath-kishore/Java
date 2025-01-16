package Tree.BalancedTrees.BST;

import Tree.BalancedTrees.Node;
import Tree.BalancedTrees.Tree;

public class BinarySearchTree implements Tree {

    private Node root = null;

    public BinarySearchTree() {
    }


    @Override
    public Tree insert(int data) {
        root = insert(data, root);
        return this;
    }

    private Node insert(int data, Node node) {
        if(node == null)
            return new Node(data);

        if(Integer.compare(data, node.getData()) < 0)
            node.setLeftChild(insert(data, node.getLeftChild()));
        else if(Integer.compare(data, node.getData()) > 0)
            node.setRightChild(insert(data, node.getRightChild()));
//        else{
//            (Integer.compare(data, node.getData()) == 0) -> meaning data already exists. do nothing.
//        }

        return node;
    }

    @Override
    public void delete(int data) {
        this.root = delete(data, root);
    }

    private Node delete(int data, Node node) {
        if(node == null)
            return null;

        if(Integer.compare(data, node.getData()) < 0){
            node.setLeftChild(delete(data, node.getLeftChild()));
        }else if(Integer.compare(data, node.getData()) > 0){
            node.setRightChild(delete(data, node.getRightChild()));
        }else{
            // value found. delete this node.

            // if this node has 0 or 1 child
            if(node.getLeftChild() == null)
                return node.getRightChild();
            else if(node.getRightChild() == null)
                return node.getLeftChild();

            // if this node has 2 children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }

        return node;
    }

    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node node) {
        if(node == null)
            return;
        traverseInOrder(node.getLeftChild());
        System.out.print(node.getData() + " - ");
        traverseInOrder(node.getRightChild());
    }

    @Override
    public int getMax() {
        if(this.isEmpty())
            return 0;
        return getMax(root);
    }

    protected int getMax(Node node) {
        while(node.getRightChild()!=null)
            node = node.getRightChild();
        return node.getData();
    }

    @Override
    public int getMin() {
        if(this.isEmpty())
            return 0;
        return getMin(root);
    }

    private int getMin(Node node) {
        while(node.getLeftChild()!=null)
            node = node.getLeftChild();
        return node.getData();
    }


    @Override
    public boolean isEmpty() {
        return root == null;
    }
}
