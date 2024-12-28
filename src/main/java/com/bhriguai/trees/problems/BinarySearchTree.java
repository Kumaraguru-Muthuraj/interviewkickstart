package com.bhriguai.trees.problems;


import com.bhriguai.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BinarySearchTree {
    private Node root = null;
    public Node getRoot() {
        return root;
    }
    public Node buildBst(List<Integer> l) {
        for (Integer i : l) {
           if (root == null) {
               root = new Node(i);
           } else {
               Node par = root;
               Node cur = root;
               while (cur != null) {
                   par = cur;
                   if (i <= cur.value) {
                       cur = cur.left;
                   } else {
                       cur = cur.right;
                   }
               }
               if (i <= par.value) {
                   par.left = new Node(i);
               } else {
                   par.right = new Node(i);
               }
           }
        }
        return root;
    }

    public void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.value + ", ");
            printInorder(root.right);
        }
    }

    public Integer getRandomNode() {
        return 0;
    }

    public void generateBst() {
        Set<Integer> s = Utils.getUniqueNumbers(20);
        List<Integer> l = new ArrayList<>(s); //Arrays.asList(50, 20, 75, 100, 25, 150, 10, 5, 1);
        Utils.print("List", l);
        this.buildBst(l);
        this.printInorder(this.root);
        System.out.println();
    }

    public static Integer getMin(Node r) {
        Node cur = r;
        if (cur == null) {
            return null;
        } else {
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur.value;
        }
    }
    public static Integer getMax(Node r) {
        Node cur = r;
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
        BinarySearchTree bst = new BinarySearchTree();
        bst.generateBst();
    }

}
