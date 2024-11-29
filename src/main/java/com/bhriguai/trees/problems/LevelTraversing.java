package com.bhriguai.trees.problems;

import java.util.*;

public class LevelTraversing {
    public static void levelTrav(BinarySearchTree t) {
        System.out.print("Level traverse - ");
        Node r = t.getRoot();
        List<Node> q = new LinkedList<>();
        if (r != null) {
            q.add(r);
        }
        while (!q.isEmpty()) {
            Node cur = q.remove(0);
            System.out.print(cur.value + ", ");
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.generateBst();
        levelTrav(t);
    }
}
