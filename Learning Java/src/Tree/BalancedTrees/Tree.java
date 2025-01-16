package Tree.BalancedTrees;

public interface Tree {
    Tree insert(int data);
    void delete(int data);
    void traverse();
    int getMax();
    int getMin();
    boolean isEmpty();
}
