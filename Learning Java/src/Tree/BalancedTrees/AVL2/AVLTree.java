package Tree.BalancedTrees.AVL2;

import Tree.BalancedTrees.Tree;
import Tree.BalancedTrees.Node;

public class AVLTree implements Tree{
// this is a completely independent implementation.
    private Node root = null;
    public Tree insert(int data) {
        root = insert(data, root);
        return this;
    }

    private Node insert(int data, Node node){
        if(node == null)
            return new Node(data);

        if(Integer.compare(data, node.getData()) < 0){
            node.setLeftChild(insert(data, node.getLeftChild()));
        }else if(Integer.compare(data, node.getData()) > 0){
            node.setRightChild((insert(data, node.getRightChild())));
        }
        else{
            // do nothing
            return node; // no need to update height or rotate. no changes, simply takes time.
        }

        updateHeight(node);
        return applyRotation(node);
    }

    public void delete(int data){
        this.root = delete(data, root);
        return;
    }
    private Node delete(int data, Node node){
        if(node == null)
            return null;

        if(Integer.compare(data, node.getData()) < 0)
            node.setLeftChild(delete(data, node.getLeftChild()));
        else if(Integer.compare(data, node.getData()) > 0)
            node.setRightChild(delete(data, node.getRightChild()));
        else{
            // node found
            // if node has 0 or 1 child
            if(node.getLeftChild() == null)
                return node.getRightChild();
            else if(node.getRightChild() == null)
                return node.getLeftChild();

            // node has 2 children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }

        updateHeight(node);
        return applyRotation(node);
    }


    private void updateHeight(Node node) {
        int maxHeight = Math.max(
                                getHeight(node.getLeftChild()),
                                getHeight(node.getRightChild())
                        );

        node.setHeight(maxHeight + 1);
    }

    private int getHeight(Node node){
        return node != null ? node.getHeight() : 0;
    }

    private Node applyRotation(Node node) {
        if(node == null)
            return null;

        if(getBalance(node) < 1){
            // right heavy R -> left rotate
            if(getBalance(node.getRightChild()) > 0) // right child is left heavy L
                rightRotate(node.getRightChild());
// in AVL trees, the balance of the child of imbalanced node, should be 0 or aligned with the imbalanced node.
// in cases like this, when the child has opposite imbalance of the parent node,
// even by 1 in the opposite sign, (though for a tree to be imbalanced the difference should be < -1 or > +1).
// then only this case of double rotation is needed.


            return leftRotate(node);

        }else if(getBalance(node) > 1){
            // left heavy L -> right rotate
            if(getBalance(node.getLeftChild()) < 0)
                leftRotate(node.getLeftChild());

            return rightRotate(node);
        }
        return node;
    }

    private Node leftRotate(Node node) {
        Node rightChild = node.getRightChild();
        Node centerNode = rightChild.getLeftChild();

        rightChild.setLeftChild(node);
        node.setRightChild(centerNode);

        updateHeight(rightChild);
        updateHeight(node);

        return rightChild;
    }

    private Node rightRotate(Node node) {
        Node leftChild = node.getLeftChild();
        Node centerNode = leftChild.getRightChild();

        leftChild.setRightChild(node);
        node.setLeftChild(centerNode);

        updateHeight(leftChild);
        updateHeight(node);

        return leftChild;
    }



    private int getBalance(Node node) {
        return node != null ? getHeight(node.getLeftChild()) - getHeight(node.getRightChild()) : 0;
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

}
