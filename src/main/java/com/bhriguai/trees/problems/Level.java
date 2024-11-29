package com.bhriguai.trees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    Integer value;
    ArrayList<TreeNode> children;

    TreeNode(Integer value) {
        this.value = value;
        this.children = new ArrayList(3);
    }
}

public class Level {

    static ArrayList<ArrayList<Integer>> level_order(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // The queue currently has all the nodes from only a single level.
            int current_level_node_count = queue.size();
            ArrayList<Integer> current_level = new ArrayList<>();

            // Visiting the nodes from the current level.
            for (int i = 0; i < current_level_node_count; ++i) {
                TreeNode current_node = queue.poll();

                current_level.add(current_node.value);
                for (TreeNode child_node : current_node.children) {
                    queue.add(child_node);
                }
            }

            result.add(current_level);
        }

        return result;
    }
}
