package com.bhriguai.trees.problems;

public class KthSmallestInBST {
    static int cnt = 0;
    static int Kth = 0;
    static Integer elem = 0;

    public static Integer getKthSmallest(Node node, int printedSofar, int K) {
        if (node != null) {
            printedSofar = getKthSmallest(node.left, printedSofar, K);
            System.out.println(node.value + " " + ++printedSofar);
            printedSofar = getKthSmallest(node.right, printedSofar, K);
        }
        return printedSofar;
    }

    public static void getKthSmallest(Node node) {
        if (node != null) {
            getKthSmallest(node.left);
            if (cnt == Kth) return;
            elem = node.value;
            System.out.println(elem + " " + ++cnt);
            if (cnt == Kth) return;
            getKthSmallest(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.generateBst();
        Kth = 5;
        getKthSmallest(bst.getRoot());
        System.out.println("3rd Smallest IDX - " + elem);
    }
}
