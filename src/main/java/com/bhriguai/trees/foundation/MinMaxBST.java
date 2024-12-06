package com.bhriguai.trees.foundation;

import com.bhriguai.trees.problems.BinarySearchTree;
import com.bhriguai.trees.problems.Node;

public class MinMaxBST {
    BinarySearchTree bst = new BinarySearchTree();
    public Integer getMin() {
        Node cur = bst.getRoot();
        if (cur == null) {
            return null;
        } else {
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur.value;
        }
    }
    public Integer getMax() {
        Node cur = bst.getRoot();
        if (cur == null) {
            return null;
        } else {
            while (cur.right != null) {
                cur = cur.right;
            }
            return cur.value;
        }
    }

    public static void main(String[] args) {
        MinMaxBST mmBst = new MinMaxBST();
        mmBst.bst.generateBst();
        //mmBst.bst.printInorder(mmBst.bst.getRoot());
        System.out.println("Min - " + mmBst.getMin());
        System.out.println("Max - " + mmBst.getMax());

    }
}
