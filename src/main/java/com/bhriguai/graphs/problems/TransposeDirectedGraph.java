package com.bhriguai.graphs.problems;

import java.util.ArrayList;
import java.util.List;

/*
Create A Transpose Of A Directed Graph
Given a strongly connected directed graph, return its transpose. The graph will be given as a reference to one of its nodes;
the rest of the graph can be discovered by walking its edges.

Example
Description of the text format of the test cases
You might need this for debugging your solution on IK UpLevel platform.
Input and output file each contain a list or directed edges representing a directed graph.
The input example is represented by

{
"edges": [
[1, 2],
[2, 3],
[3, 1]
]
}
and the output
Output
is represented by
[
[2, 1],
[3, 2],
[1, 3]
]
 */
public class TransposeDirectedGraph {
    static List<Boolean> traversed = new ArrayList<>();
    static GraphNode traverse(GraphNode node) {
        if (node != null && !traversed.get(node.value)) {
            traversed.set(node.value, true);
            System.out.println(node.value);
            if (!node.neighbors.isEmpty()) {
                for (GraphNode child : node.neighbors) {
                    traverse(child);
                }
            }
        }
        return node;
    }

    static GraphNode create_transpose(GraphNode node) {

        return node;
    }

}
