package com.bhriguai.trees.foundation;

import com.bhriguai.trees.problems.BinarySearchTree;
import com.bhriguai.trees.problems.Node;

public class MinMaxBST {
    BinarySearchTree bst = new BinarySearchTree();

    public static void main(String[] args) {
        MinMaxBST mmBst = new MinMaxBST();
        mmBst.bst.generateBst();
        System.out.println("Min - " + mmBst.bst.getMin(mmBst.bst.getRoot()));
        System.out.println("Max - " + mmBst.bst.getMax(mmBst.bst.getRoot()));

    }
}
