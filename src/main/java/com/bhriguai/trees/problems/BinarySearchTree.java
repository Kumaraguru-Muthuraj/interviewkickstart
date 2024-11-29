package com.bhriguai.trees.problems;


import com.bhriguai.Utils;

import java.util.Arrays;
import java.util.List;

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

    public void generateBst() {
        List<Integer> l = Utils.getNumbers(10);
        Utils.print("List", l);
        this.buildBst(l);
        this.printInorder(this.root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.generateBst();
    }

}
