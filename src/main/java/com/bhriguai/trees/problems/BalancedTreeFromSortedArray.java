package com.bhriguai.trees.problems;

import java.util.ArrayList;

public class BalancedTreeFromSortedArray {
    static Node addNode(Node root, Integer val) {
        if (root == null) {
            return new Node(val);
        } else {
            Node parent = null;
            Node cur = root;
            while (cur != null) {
                parent = cur;
                if (val < cur.value) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            if (val < parent.value) {
                parent.left = new Node(val);
            } else if (parent.value < val) {
                parent.right = new Node(val);
            }
            return root;
        }
    }

    static Node buildTree(Node curRoot, ArrayList<Integer> list, int l, int h) {
        if (l <= h) {
            Integer rootIdx = l + (h - l) / 2;
            curRoot = addNode(curRoot, list.get(rootIdx));
            buildTree(curRoot, list, l, rootIdx - 1);
            buildTree(curRoot, list, rootIdx + 1, h);
        }
        return curRoot;
    }

    static Node build_balanced_bst(ArrayList<Integer> list) {
        Node root = buildTree(null, list, 0, list.size() - 1);
        return root;
    }
}



