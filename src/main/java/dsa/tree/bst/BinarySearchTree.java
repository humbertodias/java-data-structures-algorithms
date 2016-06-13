package dsa.tree.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * Class BST 
 **/
public class BinarySearchTree {

    private BSTNode root;

    /**
     * Constructor 
     **/
    public BinarySearchTree() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Functions to insert data */
    public void insert(int data) {
        root = insert(root, data);
    }

    /* Function to insert data recursively */
    private BSTNode insert(BSTNode node, int data) {
        if (node == null) {
            node = new BSTNode(data);
        } else if (data <= node.getData()) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    /* Functions to delete data */
    public void delete(int k) {
        if (isEmpty()) {
            System.out.println("Tree Empty");
        } else if (search(k) == false) {
            System.out.println("Sorry " + k + " is not present");
        } else {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    private BSTNode delete(BSTNode root, int k) {
        BSTNode p, p2, n;
        if (root.getData() == k) {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null) {
                return null;
            } else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null) {
                    p = p.getLeft();
                }
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        } else {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r) {
        if (r == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    /* Function to search for an element recursively */
    private boolean search(BSTNode r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rval = r.getData();
            if (val < rval) {
                r = r.getLeft();
            } else if (val > rval) {
                r = r.getRight();
            } else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    /* Function for inorder traversal */
    public List<BSTNode> inorder() {
        List<BSTNode> walk = new ArrayList<>();
        inorder(root, walk);
        return walk;
    }

    private void inorder(BSTNode r, List<BSTNode> walk) {
        if (r != null) {
            inorder(r.getLeft(), walk);
//            System.out.print(r.getData() + " ");
            walk.add(r);
            inorder(r.getRight(), walk);
        }
    }

    /* Function for preorder traversal */
    public List preorder() {
        List<BSTNode> walk = new ArrayList<>();
        preorder(root, walk);
        return walk;
    }

    private void preorder(BSTNode r, List<BSTNode> walk) {
        if (r != null) {
            //           System.out.print(r.getData() + " ");
            walk.add(r);
            preorder(r.getLeft(), walk);
            preorder(r.getRight(), walk);
        }
    }

    /* Function for postorder traversal */
    public List<BSTNode> postorder() {
        List<BSTNode> walk = new ArrayList<>();

        postorder(root, walk);
        return walk;
    }

    private void postorder(BSTNode r, List<BSTNode> walk) {
        if (r != null) {
            postorder(r.getLeft(), walk);
            postorder(r.getRight(), walk);
//            System.out.print(r.getData() + " ");
            walk.add(r);
        }
    }
}
