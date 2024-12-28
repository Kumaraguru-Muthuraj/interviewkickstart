package com.bhriguai.trees.foundation;

import com.bhriguai.trees.problems.BinarySearchTree;
import com.bhriguai.trees.problems.Node;

import java.util.ArrayList;
import java.util.Collections;

public class MinMaxBST {
    BinarySearchTree bst = new BinarySearchTree();

    public static void main(String[] args) {
        MinMaxBST mmBst = new MinMaxBST();
        mmBst.bst.generateBst();
        System.out.println("Min - " + mmBst.bst.getMin(mmBst.bst.getRoot()));
        System.out.println("Max - " + mmBst.bst.getMax(mmBst.bst.getRoot()));
        ArrayList<Integer> l;

    }
}
/*


    For your reference:
    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }



    static BinaryTreeNode addNode(BinaryTreeNode root, Integer val) {
        if (root == null) {
            return new BinaryTreeNode(val);
        } else {
            BinaryTreeNode parent = null;
            BinaryTreeNode cur = root;
            while (cur != null) {
                parent = cur;
                if (val < cur.value) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
            if (val < parent.value) {
                parent.left = new BinaryTreeNode(val);
            } else if (parent.value < val) {
                parent.right = new BinaryTreeNode(val);
            }
            return root;
        }
    }

    static BinaryTreeNode buildTree(BinaryTreeNode curRoot, ArrayList<Integer> list, int l, int h) {
        if (l <= h) {
            Integer rootIdx = (l + h) / 2;
            curRoot = addNode(curRoot, list.get(rootIdx));
            buildTree(curRoot, list, l, rootIdx - 1);
            buildTree(curRoot, list, rootIdx + 1, h);
        }
        return curRoot;
    }

    static BinaryTreeNode build_balanced_bst(ArrayList<Integer> list) {
        BinaryTreeNode root = buildTree(null, list, 0, list.size() - 1);
        return root;
    }

 */
