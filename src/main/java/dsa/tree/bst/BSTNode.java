package dsa.tree.bst;

public class BSTNode {

    BSTNode left, right;
    int data;

    /* Constructor */
    public BSTNode() {
        left = null;
        right = null;
        data = 0;
    }

    /* Constructor */
    public BSTNode(int n) {
        left = null;
        right = null;
        data = n;
    }

    /* Function to set left node */
    public void setLeft(BSTNode n) {
        left = n;
    }

    /* Function to set right node */
    public void setRight(BSTNode n) {
        right = n;
    }

    /* Function to get left node */
    public BSTNode getLeft() {
        return left;
    }

    /* Function to get right node */
    public BSTNode getRight() {
        return right;
    }

    /* Function to set data to node */
    public void setData(int d) {
        data = d;
    }

    /* Function to get data from node */
    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

}
