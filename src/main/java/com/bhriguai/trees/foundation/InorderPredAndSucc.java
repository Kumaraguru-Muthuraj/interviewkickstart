package com.bhriguai.trees.foundation;

import com.bhriguai.trees.problems.BinarySearchTree;
import com.bhriguai.trees.problems.Node;

public class InorderPredAndSucc {

    Integer pred(Node root, Integer predOf) {

        return 0;
    }

    static Integer succ(Node root, Integer succOf) {
        if (root == null) {
            return null;
        } else {
            Node ancestor = null;
            Node curr = root;
            while (curr != null) {
                if (curr.value <= succOf) {
                    curr = curr.right;
                } else {
                    ancestor = curr;
                    curr = curr.left;
                }
            }
            return ancestor.value;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.generateBst();
        System.out.println("Inorder successor - " + succ(bst.getRoot(), 20));
    }
}
